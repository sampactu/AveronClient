package com.client.definitions;

//import com.client.ByteBuf;
import com.client.Stream;
import com.client.StreamLoader;

public final class VarBit {

	public static void unpackConfig(StreamLoader streamLoader) {
		Stream stream = new Stream(streamLoader.getDataForName("varbit.dat"));
		int cacheSize = stream.readUnsignedShort();
		
		if (cache == null) {
			cache = new VarBit[cacheSize];
		}
		
		System.out.println(String.format("Loaded: %d varbits", cacheSize));
		
		for (int i = 0; i < cacheSize; i++) {
			if (cache[i] == null)
				cache[i] = new VarBit();
			    cache[i].readValues(stream);
		}

		if (stream.currentOffset != stream.buffer.length)
			System.out.println("varbit load mismatch");
	}

	private void readValues(Stream stream) {
		anInt648 = stream.readUnsignedShort(); //ConfigId
		anInt649 = stream.readUnsignedByte(); //lsb
		anInt650 = stream.readUnsignedByte(); //msb
	
	}

	private VarBit() {
		aBoolean651 = false;
	}

	public static VarBit cache[];
	public int anInt648;
	public int anInt649;
	public int anInt650;
	private boolean aBoolean651;

}
