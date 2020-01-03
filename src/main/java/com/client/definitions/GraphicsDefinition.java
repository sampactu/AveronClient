package com.client.definitions;

import com.client.MRUNodes;
import com.client.Model;
import com.client.Stream;
//import com.client.ByteBuf;
import com.client.StreamLoader;

public final class GraphicsDefinition {

	public static void unpackConfig(StreamLoader streamLoader) {
		Stream stream = new Stream(streamLoader.getDataForName("spotanim.dat"));
		int length = stream.readUnsignedShort();
		if (cache == null)
			cache = new GraphicsDefinition[length + 15000];
		for (int j = 0; j < length; j++) {
			if (cache[j] == null) {
				cache[j] = new GraphicsDefinition();
			}
			if (j == 65535) {
				j = -1;
			}
			cache[j].index = j;
			cache[j].setDefault();
			cache[j].readValues(stream);
		}
		cache[1282] = new GraphicsDefinition();
		cache[1282].index = 1282;
		cache[1282].modelId = 44811;
		cache[1282].animationId = 7155;
		cache[1282].aAnimation_407 = AnimationDefinition.anims[cache[1282].animationId];
	}

	private void readValues(Stream stream) {
		while(true) {
			final int opcode = stream.readUnsignedByte();
			
			if (opcode == 0) {
				return;
			} else if (opcode == 1) {
				modelId = stream.readUnsignedShort();
			} else if (opcode == 2) {
				animationId = stream.readUnsignedShort();
				
				if (AnimationDefinition.anims != null) {
					aAnimation_407 = AnimationDefinition.anims[animationId];
				}
			} else if (opcode == 4) {
				resizeX = stream.readUnsignedShort();
			} else if (opcode == 5) {
				resizeY = stream.readUnsignedShort();
			} else if (opcode == 6) {
				rotation = stream.readUnsignedShort();
			} else if (opcode == 7) {
				ambience = stream.readUnsignedByte();
			} else if (opcode == 8) {
				contrast = stream.readUnsignedByte();
			} else if (opcode == 40) {
				final int len = stream.readUnsignedByte();
				for (int i = 0; i < len; i++) { //(i was K) here is the example - because apparently that works O.o
					try {
						colorToFind[i] = stream.readUnsignedShort();
						colorToReplace[i] = stream.readUnsignedShort();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else if (opcode == 41) {
				final int len = stream.readUnsignedByte();
				for (int i = 0; i < len; i++) {
					textureToFind[i] = stream.readUnsignedShort();
					textureToReplace[i] = stream.readUnsignedShort();
				}
			} else {
				//System.out.println("Error unrecognised spotanim config code: " + opcode);
			}
		}
	}

	
	public static GraphicsDefinition fetch(int modelId) {
		for (GraphicsDefinition anim : cache) {
			if (anim == null) {
				continue;
			}
			if (anim.modelId == modelId) {
				return anim;
			}
		}
		return null;
	}

	public Model getModel() {
		Model model = (Model) aMRUNodes_415.insertFromCache(index);
		if (model != null)
			return model;
		model = Model.method462(modelId);
		if (model == null)
			return null;
		for (int i = 0; i < colorToFind.length; i++)
			if (colorToFind[0] != 0) //default frame id
				model.replaceColor(colorToFind[i], colorToReplace[i]);

		aMRUNodes_415.removeFromCache(model, index);
		return model;
	}
	
	private void setDefault() {
		modelId = -1;
		animationId = -1;
		colorToFind = new int[6];
		colorToReplace = new int[6];
		resizeX = 128;
		resizeY = 128;
		rotation = 0;
		ambience = 0;
		contrast = 0;
	}

	public GraphicsDefinition() {
		anInt400 = 9;
		animationId = -1;
		colorToFind = new int[6];
		colorToReplace = new int[6];
		resizeX = 128;
		resizeY = 128;
	}
	
	public int getModelId() {
		return modelId;
	}
	
	public int getIndex() {
		return index;
	}

	public final int anInt400;
	public static GraphicsDefinition cache[];
	private int index;
	private int modelId;
	public int animationId;
	public AnimationDefinition aAnimation_407;
	public int[] colorToFind;
	public int[] colorToReplace;
	public int[] textureToFind;
	public int[] textureToReplace;
	public int resizeX;
	public int resizeY;
	public int rotation;
	public int ambience;
	public int contrast;
	public static MRUNodes aMRUNodes_415 = new MRUNodes(30);

}
