package com.client;
 
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.*;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.client.sign.Signlink;
 
public class UpdateCache implements Runnable {
    public static final String ZIP_URL = "http://averon-rsps.com/download/Averon.zip";
    public static final String VERSION_URL = "http://averon-rsps.com/download/version.txt";
    public static final String VERSION_FILE = Signlink.getCacheDirectory()+"cacheVersion.dat";
    
    private Client client;
    Client frame;
    public UpdateCache(Client client) {
                this.client = client;
    }
       
    private void drawLoadingText(int amount, String text) {
                client.drawLoadingText(amount, text);
    }
   
    public double getCurrentVersion(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(VERSION_FILE)));
            return Double.parseDouble(br.readLine());
        } catch (Exception e) {
            return 0.1;
        }
    }
   
    public double getNewestVersion(){
        try {
            URL tmp = new URL(VERSION_URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(tmp.openStream()));
            return Double.parseDouble(br.readLine());
        } catch (Exception e) {
            handleException(e);
            return -1;
        }
    }
   
    private void handleException(Exception e){
        StringBuilder strBuff = new StringBuilder();
        strBuff.append("Please Move Files to Desktop and try loading again! Connection Error\r\n\r\n");
        StringBuilder append = strBuff.append(e.getClass().getName()).append(" \"").append(e.getMessage()).append("\"\r\n");
        for(StackTraceElement s : e.getStackTrace())
            strBuff.append(s.toString()).append("\r\n");
        SwingUtilities.invokeLater(() -> alert("Exception [" + e.getClass().getSimpleName() + "]",strBuff.toString(),true));
    }
   
    private void alert(String msg){
        alert("Message",msg,false);
    }
   
    private void alert(String title,String msg,boolean error){
        JOptionPane.showMessageDialog(null,
               msg,
               title,
                (error ? JOptionPane.ERROR_MESSAGE : JOptionPane.PLAIN_MESSAGE));
    }
   
    @Override
    public void run() {
        drawLoadingText(0, "Checking for updates...");
            try{
            double newest = getNewestVersion();
            if(newest > this.getCurrentVersion()){
                    updateClient();
                    OutputStream out = new FileOutputStream(VERSION_FILE);
                    out.write(String.valueOf(newest).getBytes());;
                }
            }catch(Exception e){
                handleException(e);
            }
        }
   
    private void updateClient() {
        File clientZip = downloadClient();
        if(clientZip != null){
        unZip(clientZip);
        }
    }
   
    private void unZip(File clientZip) {
        try {
            unZipFile(clientZip,new File(Signlink.getCacheDirectory()));
            clientZip.delete();
        } catch (IOException e) {
            handleException(e);
        }
    }
   
    private void unZipFile(File zipFile,File outFile) throws IOException{
        ZipInputStream zin = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipFile)));
        ZipEntry e;
        long max = 0;
        long curr = 0;
        while((e = zin.getNextEntry()) != null)
            max += e.getSize();
        zin.close();
        ZipInputStream in = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipFile)));
        while((e = in.getNextEntry()) != null){
            if(e.isDirectory())
                new File(outFile,e.getName()).mkdirs();
            else{
                FileOutputStream out = new FileOutputStream(new File(outFile,e.getName()));
                byte[] b = new byte[1024];
                int len;
                while((len = in.read(b)) != -1){
                    curr += len;
                        out.write(b, 0, len);
                        setUnzipPercent((int)((curr * 100) / max));
                }
                out.flush();
                out.close();
            }
        }
    }
 
    public int percent = 0;
   
    public void setDownloadPercent(int amount){
            percent = amount;
            drawLoadingText(amount, "Downloading Cache" + " - " + amount + "%");
    }
   
    public int percent2 = 0;
   
    public void setUnzipPercent(int amount2){
            percent2 = amount2;
            drawLoadingText(amount2, "Extracting Cache" + " - " + amount2 + "%");
    }
 
    private File downloadClient(){
        File ret = new File(Signlink.getCacheDirectory()+"Averon.zip");
        try{
        OutputStream out = new FileOutputStream(ret);
        URLConnection conn = new URL(ZIP_URL).openConnection();
        InputStream in = conn.getInputStream();
        long max = conn.getContentLength();
        long curr = 0;
        byte[] b = new byte[1024];
        int len;
        while((len = in.read(b, 0, b.length)) > -1){
            out.write(b,0,len);
            curr += len;
            setDownloadPercent((int)((curr * 100) / max));
        }
        out.flush();
        out.close();
        in.close();
        return ret;
        }catch(Exception e){
            handleException(e);
                ret.delete();
            return null;
        }
    }
}