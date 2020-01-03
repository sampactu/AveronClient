package com.client.definitions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Arrays;
//
//import org.apache.commons.io.FileUtils;
import java.util.Arrays;

import com.client.Animation;
import com.client.Client;
import com.client.Configuration;
import com.client.MRUNodes;
import com.client.Model;
import com.client.Stream;
//import com.client.ByteBuf;
import com.client.StreamLoader;

public final class NpcDefinition {
	public int rdc = 0;
	public int recolourhue = 0;
	public int rdc3 = 0; 
	public static NpcDefinition forID(int i) {
		for (int j = 0; j < 20; j++)
			if (cache[j].interfaceType == i)
				return cache[j];

		anInt56 = (anInt56 + 1) % 20;
		NpcDefinition entityDef = cache[anInt56] = new NpcDefinition();
		stream.currentOffset = streamIndices[i];
		entityDef.interfaceType = i;
		entityDef.readValues(stream);
		
        /* Fishing Fix Start */
		switch(i) {
        case 1511:
        case 6825:
        case 310:
        case 314:
        case 317:
        case 318:
        case 328:
        case 331:
        case 3913:
        case 3317:
        case 4712:
        case 1524:
        case 3417:
        case 3657:
        case 635:
            entityDef.models = new int[] { 1491 };
            entityDef.onMinimap = false;
            entityDef.name = "Fishing spot";
            break;
        }
	    /* Fishing Fix End */
	    if(i == 3218 || i == 3217){
			entityDef.actions = new String[] { "Talk-to", null, null, null, null };
		}
		if (i == 233) {
			entityDef.name = "Instance Penguin";
			entityDef.description = "A penguin for all your instancing needs.";
			entityDef.actions = new String[] { "Talk-to", null, null, null, null };
		}
		if (i == 7913) {
			entityDef.name = "Iron man shop keeper";
			entityDef.description = "A shop specifically for iron men.";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if (i == 7818) {
			entityDef.name = "Tektus Adventurer";
			entityDef.description = "He is here to guide you on your journey!";
		}
		if (i == 7041) {
			entityDef.name = "Ticket Exchange";
			entityDef.description = "You can exchange your tickets here.";
		}
		if (i == 6599) {
			entityDef.name = "PKP Store";
			entityDef.description = "You can buy things with PKP Tokens here.";
			entityDef.actions = new String[] { "Open Shop", null, null, null, null };
		}
		if(i == 3257){
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i == 1306){
			entityDef.actions = new String[] { "Makeover", null, null, null, null };
		}
		if(i == 4306){
			entityDef.actions = new String[] { "Open Shop", null, null, null, null };
		}
		if(i == 534){
			entityDef.actions = new String[] { "Makeover", null, null, null, null };
		}
		if(i == 3219){
			entityDef.name = "Consumables";
			entityDef.actions = new String[] { "Open Shop", null, null, null, null };
		}
		if(i == 3216){
			entityDef.name = "Melee Shop";
			entityDef.actions = new String[] { "Open Shop", null, null, null, null };
		}
		if(i == 1909){
			entityDef.name = "Daily Tasks";
			entityDef.actions = new String[] { "Talk-to", null, null, null, null };
		}
		if(i == 3217){
			entityDef.name = "Ranged Shop";
			entityDef.actions = new String[] { "Open Shop", null, null, null, null };
		}
		if(i == 3218){
			entityDef.name = "Magic Shop";
			entityDef.actions = new String[] { "Open Shop", null, null, null, null };
		}
		if(i == 7303){
			entityDef.name = "Clue Master";
			entityDef.actions = new String[] { "Exchange Clues", null, null, null, null };
		}
		if(i == 7413){
			entityDef.name = "Combat Dummy";
			entityDef.actions = new String[] { "Attack", null, null, null, null };
		}
		if(i == 4625){
			entityDef.name = "Donator shop";
			entityDef.actions = new String[] { "Talk-to", "Trade", null, null, null };
		}
		if (i == 306) {
			entityDef.name = "Averon Guide";
			entityDef.description = "Averon Info Source";
		}
		if(i == 2989){
			entityDef.name = "Prestige Manager";
			entityDef.actions = new String[] { "Talk-to", "Open Shop", "Manage", null, null };
		}
		if( i== 2580){
			entityDef.name = "Mage of Zamorak";
			entityDef.actions = new String[] { "Talk-to", "Teleport", null, null, null };
		}
		if (i == 5314) {
			entityDef.name = "Mystical Wizard";
			entityDef.actions = new String[] { "Teleport", "Previous Location", null, null, null };
			entityDef.description = "This wizard has the power to teleport you to many locations.";
		}
		if (i == 2377) {
			entityDef.name = "Tektus";
			entityDef.description = "Destroyer of Worlds";
			entityDef.combatLevel = 999;
			entityDef.models = new int[] { 39518, 39520, 39522, 39524, 39526 };
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.anInt86 = 250;
			entityDef.anInt91 = 250;
			entityDef.standAnim = 808;
			entityDef.walkAnim = 819;
		}
		if (i == 2378) {
			entityDef.name = "Angel of Death";
			entityDef.description = "The Angel Of Death";
			entityDef.combatLevel = 999;
			entityDef.models = new int[] { 39515, 39509, 39507, 39505, 39503, 39501 };
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.anInt86 = 250;
			entityDef.anInt91 = 250;
			entityDef.standAnim = 808;
			entityDef.walkAnim = 819;
		}
		if (i == 8614) {
			entityDef.name = "Sulphur Lizard";
			entityDef.description = "A cold-blooded creature, partial to warmth.";
			entityDef.combatLevel = 50;
			entityDef.standAnim = 8282;
			entityDef.walkAnim = 8281;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.anInt86 = 100;
			entityDef.anInt91 = 100;
		}
		if (i == 8612) {
			entityDef.name = "Drake";
			entityDef.description = "A dragon-like creature with no wings.";
			entityDef.combatLevel = 192;
			entityDef.standAnim = 8274;
			entityDef.walkAnim = 8273;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.anInt86 = 100;
			entityDef.anInt91 = 100;
		}
		if (i == 8610) {
			entityDef.name = "Wyrm";
			entityDef.description = "Don't let it wyrm its way in.";
			entityDef.combatLevel = 99;
			entityDef.standAnim = 8266;
			entityDef.walkAnim = 8266;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.anInt86 = 100;
			entityDef.anInt91 = 100;
		}
		if (i == 8066) {
			entityDef.name = "Vorkath";
			entityDef.combatLevel = 732;
			entityDef.models = new int[] { 35023 };
			entityDef.standAnim = 7950;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, null, null, null, null };
			entityDef.anInt86 = 100;
			entityDef.anInt91 = 100;
		}
		if (i == 8071) {
			entityDef.name = "Vorkath";
			entityDef.combatLevel = 732;
			entityDef.models = new int[] { 35023 };
			entityDef.standAnim = 7948;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.anInt86 = 100;
			entityDef.anInt91 = 100;
		}
		if(i==7144){
	entityDef.anInt75 = 0;
		}
		if(i==963){
			entityDef.anInt75 = 6;
		}
		if(i==7145){
	entityDef.anInt75 = 1;
		}
		if(i==7146){
	entityDef.anInt75 = 2;
		}
		return entityDef;
	}

	public static int totalAmount;

	public static void unpackConfig(StreamLoader streamLoader) {
		stream = new Stream(streamLoader.getDataForName("npc.dat"));
		Stream stream = new Stream(streamLoader.getDataForName("npc.idx"));
		totalAmount = stream.readUnsignedShort();
		streamIndices = new int[totalAmount];
		int i = 2;
		for (int j = 0; j < totalAmount; j++) {
			streamIndices[j] = i;
			i += stream.readUnsignedShort();
		}

		cache = new NpcDefinition[20];
		for (int k = 0; k < 20; k++)
			cache[k] = new NpcDefinition();
		System.out.println(forID(1635).name + ", " + Arrays.toString(forID(1635).actions));
	
	}

	/*
	 * public void readValues(Stream stream) { do { int i =
	 * stream.readUnsignedByte(); if (i == 0) return; if (i == 1) { int j =
	 * stream.readUnsignedByte(); models = new int[j]; for (int j1 = 0; j1 < j;
	 * j1++) models[j1] = stream.readShort();
	 * 
	 * } else if (i == 2) name = stream.readString(); else if (i == 3) description =
	 * stream.readString(); else if (i == 12) squareLength =
	 * stream.readSignedByte(); else if (i == 13) standAnim =
	 * stream.readShort(); else if (i == 14) walkAnim =
	 * stream.readShort(); else if (i == 17) { walkAnim =
	 * stream.readShort(); anInt58 = stream.readShort(); anInt83 =
	 * stream.readShort(); anInt55 = stream.readShort(); if (anInt58
	 * == 65535) { anInt58 = -1; } if (anInt83 == 65535) { anInt83 = -1; } if
	 * (anInt55 == 65535) { anInt55 = -1; } } else if (i >= 30 && i < 40) { if
	 * (actions == null) actions = new String[5]; actions[i - 30] =
	 * stream.readString(); if (actions[i - 30].equalsIgnoreCase("hidden"))
	 * actions[i - 30] = null; } else if (i == 40) { int k =
	 * stream.readUnsignedByte(); originalColors = new int[k]; newColors = new
	 * int[k]; for (int k1 = 0; k1 < k; k1++) { originalColors[k1] =
	 * stream.readShort(); newColors[k1] = stream.readShort(); }
	 * 
	 * } else if (i == 60) { int l = stream.readUnsignedByte(); dialogueModels = new
	 * int[l]; for (int l1 = 0; l1 < l; l1++) dialogueModels[l1] =
	 * stream.readShort();
	 * 
	 * } else if (i == 90) stream.readShort(); else if (i == 91)
	 * stream.readShort(); else if (i == 92) stream.readShort(); else
	 * if (i == 93) minimapDot = false; else if (i == 95) combatLevel =
	 * stream.readShort(); else if (i == 97) anInt91 =
	 * stream.readShort(); else if (i == 98) anInt86 =
	 * stream.readShort(); else if (i == 99) aBoolean93 = true; else if (i ==
	 * 100) anInt85 = stream.readSignedByte(); else if (i == 101) anInt92 =
	 * stream.readSignedByte() * 5; else if (i == 102) anInt75 =
	 * stream.readUnsignedByte(); else if (i == 103) getDegreesToTurn =
	 * stream.readUnsignedByte(); else if (i == 106) { anInt57 =
	 * stream.readShort(); if (anInt57 == 65535) anInt57 = -1; anInt59 =
	 * stream.readShort(); if (anInt59 == 65535) anInt59 = -1; int i1 =
	 * stream.readUnsignedByte(); childrenIDs = new int[i1 + 1]; for (int i2 = 0; i2
	 * <= i1; i2++) { childrenIDs[i2] = stream.readShort(); if
	 * (childrenIDs[i2] == 65535) childrenIDs[i2] = -1; }
	 * 
	 * } else if (i == 107) aBoolean84 = false; } while (true); }
	 */
	private void readValues(Stream stream) {
		while (true) {
			int opcode = stream.readUnsignedByte();
			if (opcode == 0) {
				return;
			} else if (opcode == 1) {
				int len = stream.readUnsignedByte();
				models = new int[len];
				for (int i = 0; i < len; i++) {
					models[i] = stream.readUnsignedShort();
			}

			} else if (opcode == 2) {
				name = stream.readString();
			} else if (opcode == 3) {
				description = stream.readString();
			} else if (opcode == 12) {
				boundDim = stream.readSignedByte();
			} else if (opcode == 13) {
				standAnim = stream.readUnsignedShort();
		    } else if (opcode == 14) {
				walkAnim = stream.readUnsignedShort();
		    } else if (opcode == 17) {
				walkAnim = stream.readUnsignedShort();
				anInt58 = stream.readUnsignedShort();
				anInt83 = stream.readUnsignedShort();
				anInt55 = stream.readUnsignedShort();
				if (anInt58 == 65535) {
					anInt58 = -1;
				}
				if (anInt83 == 65535) {
					anInt83 = -1;
				}
				if (anInt55 == 65535) {
					anInt55 = -1;
				}
			} else if (opcode >= 30 && opcode < 35) { //was 40
				if (actions == null) {
					actions = new String[5];
				}
				actions[opcode - 30] = stream.readString();
				
				if (actions[opcode - 30].equalsIgnoreCase("hidden")) {
					actions[opcode - 30] = null;
				}
			} else if (opcode == 40) {
				int len = stream.readUnsignedByte();
				originalColors = new int[len];
				newColors = new int[len];
				for (int i = 0; i < len; i++) {
					originalColors[i] = stream.readUnsignedShort();
					newColors[i] = stream.readUnsignedShort();
				}
			 } else if (opcode == 41) {
	                int len = stream.readUnsignedByte();

	                for (int i = 0; i < len; i++) {
	                    stream.readUnsignedShort(); // textures
	                    stream.readUnsignedShort();
	                }
			} else if (opcode == 60) {
				int len = stream.readUnsignedByte();
				dialogueModels = new int[len];
				for (int i = 0; i < len; i++) {
					dialogueModels[i] = stream.readUnsignedShort();
				}
			} else if (opcode == 93) {
				onMinimap = false;
			} else if (opcode == 95) {
				combatLevel = stream.readUnsignedShort();
			} else if (opcode == 97) {
				anInt91 = stream.readUnsignedShort();
			} else if (opcode == 98) {
				anInt86 = stream.readUnsignedShort();
			} else if (opcode == 99) {
				aBoolean93 = true;
			} else if (opcode == 100) {
				anInt85 = stream.readSignedByte();
			} else if (opcode == 101) {
				anInt92 = stream.readSignedByte();
			} else if (opcode == 102) {
				anInt75 = stream.readUnsignedShort();
			} else if (opcode == 103) {
				getDegreesToTurn = stream.readUnsignedShort();
			} else if (opcode == 106 || opcode == 118) {
				anInt57 = stream.readUnsignedShort();
				
				if (anInt57 == 65535) { //anInt57 = Varbit
					anInt57 = -1;
				}
				anInt59 = stream.readUnsignedShort();
				
				if (anInt59 == 65535) {
					anInt59 = -1;
				}
				
				int value = -1;
				
				if (opcode == 118) {
                    value = stream.readUnsignedShort();
                }
				
				int len = stream.readUnsignedByte();
				childrenIDs = new int[len + 2];
				for (int i = 0; i <= len; i++) {
					childrenIDs[i] = stream.readUnsignedShort();
					if (childrenIDs[i] == 65535) {
						childrenIDs[i] = -1;
				}
			}
			childrenIDs[len + 1] = value;
		} else if (opcode == 107) {
			clickable = false;
		} else if (opcode == 109) {
			//who knows
		} else {
            System.out.println(String.format("npc def invalid opcode: %d", opcode));
		}
	}
}

	public Model method160() {
		if (childrenIDs != null) {
			NpcDefinition entityDef = method161();
			if (entityDef == null)
				return null;
			else
				return entityDef.method160();
		}
		if (dialogueModels == null) {
			return null;
		}
		boolean flag1 = false;
		for (int i = 0; i < dialogueModels.length; i++)
			if (!Model.method463(dialogueModels[i]))
				flag1 = true;

		if (flag1)
			return null;
		Model aclass30_sub2_sub4_sub6s[] = new Model[dialogueModels.length];
		for (int j = 0; j < dialogueModels.length; j++)
			aclass30_sub2_sub4_sub6s[j] = Model.method462(dialogueModels[j]);

		Model model;
		if (aclass30_sub2_sub4_sub6s.length == 1)
			model = aclass30_sub2_sub4_sub6s[0];
		else
			model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);

		if (originalColors != null)
			for (int k = 0; k < originalColors.length; k++)
				model.replaceColor(originalColors[k], newColors[k]);
		if (rdc > 0)
			model.method1337(rdc);
			if (recolourhue != 0)
			model.method1338(recolourhue);
			if (rdc3 != 0)
			model.method1339(rdc3);
			  
		return model;
	}

	public NpcDefinition method161() {
		int j = -1;
		if (anInt57 != -1 && anInt57 <= 2113) {
			VarBit varBit = VarBit.cache[anInt57];
			int k = varBit.anInt648;
			int l = varBit.anInt649;
			int i1 = varBit.anInt650;
			int j1 = Client.anIntArray1232[i1 - l];
			j = clientInstance.variousSettings[k] >> l & j1;
		} else if (anInt59 != -1)
			j = clientInstance.variousSettings[anInt59];
		if (j < 0 || j >= childrenIDs.length || childrenIDs[j] == -1)
			return null;
		else
			return forID(childrenIDs[j]);
	}

	public Model method164(int j, int k, int ai[]) {
		if (childrenIDs != null) {
			NpcDefinition entityDef = method161();
			if (entityDef == null)
				return null;
			else
				return entityDef.method164(j, k, ai);
		}
		Model model = (Model) mruNodes.insertFromCache(interfaceType);
		if (model == null) {
			boolean flag = false;
			for (int i1 = 0; i1 < models.length; i1++)
				if (!Model.method463(models[i1]))
					flag = true;

			if (flag)
				return null;
			Model aclass30_sub2_sub4_sub6s[] = new Model[models.length];
			for (int j1 = 0; j1 < models.length; j1++)
				aclass30_sub2_sub4_sub6s[j1] = Model.method462(models[j1]);

			if (aclass30_sub2_sub4_sub6s.length == 1)
				model = aclass30_sub2_sub4_sub6s[0];
			if (rdc > 0)
				model.method1337(rdc);
				if (recolourhue != 0)
				model.method1338(recolourhue);
				if (rdc3 != 0)
				model.method1339(rdc3);
			else
				model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
			if (originalColors != null) {
				for (int k1 = 0; k1 < originalColors.length; k1++)
					model.replaceColor(originalColors[k1], newColors[k1]);

			}
			model.method469();
			model.method479(64 + anInt85, 850 + anInt92, -30, -50, -30, true);
			// model.method479(84 + anInt85, 1000 + anInt92, -90, -580, -90, true);
			mruNodes.removeFromCache(model, interfaceType);
		}
		Model model_1 = Model.EMPTY_MODEL;
		model_1.method464(model, Animation.method532(k) & Animation.method532(j));
		if (k != -1 && j != -1)
			model_1.method471(ai, j, k);
		else if (k != -1)
			model_1.method470(k);
		if (anInt91 != 128 || anInt86 != 128)
			model_1.method478(anInt91, anInt91, anInt86);
		model_1.method466();
		model_1.faceGroups = null;
		model_1.vertexGroups = null;
		if (boundDim == 1)
			model_1.aBoolean1659 = true;
		return model_1;
	}

	private NpcDefinition() {
		anInt55 = -1;
		anInt57 = walkAnim;
		anInt58 = walkAnim;
		anInt59 = walkAnim;
		combatLevel = -1;
		anInt64 = 1834;
		walkAnim = -1;
		boundDim = 1;
		anInt75 = -1;
		standAnim = -1;
		interfaceType = -1L;
		getDegreesToTurn = 32;
		anInt83 = -1;
		clickable = true;
		anInt86 = 128;
		onMinimap = true;
		anInt91 = 128;
		aBoolean93 = false;
		rdc = 0;
        recolourhue = 0;
        rdc3 = 0;
	}

	public static void nullLoader() {
		mruNodes = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public static void dumpList() {
		try {
			File file = new File(System.getProperty("user.home") + "/Desktop/npcList " + Configuration.dumpID + ".txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (int i = 0; i < totalAmount; i++) {
					NpcDefinition definition = forID(i);
					if (definition != null) {
						writer.write("npc = " + i + "\t" + definition.name + "\t" + definition.combatLevel + "\t"
								+ definition.standAnim + "\t" + definition.walkAnim + "\t");
						writer.newLine();
					}
				}
			}

			System.out.println("Finished dumping npc definitions.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dumpSizes() {
		try {
			File file = new File(System.getProperty("user.home") + "/Desktop/npcSizes 143.txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (int i = 0; i < totalAmount; i++) {
					NpcDefinition definition = forID(i);
					if (definition != null) {
						writer.write(i + "	" + definition.boundDim);
						writer.newLine();
					}
				}
			}

			System.out.println("Finished dumping npc definitions.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int anInt55;
	public static int anInt56;
	public int anInt57;
	public int anInt58;
	public int anInt59;
	public static Stream stream;
	public int combatLevel;
	public final int anInt64;
	public String name;
	public String actions[];
	public int walkAnim;
	public byte boundDim;
	public int[] newColors;
	public static int[] streamIndices;
	public int[] dialogueModels;
	public int anInt75;
	public int[] originalColors;
	public int standAnim;
	public long interfaceType;
	public int getDegreesToTurn;
	public static NpcDefinition[] cache;
	public static Client clientInstance;
	public int anInt83;
	public boolean clickable;
	public int anInt85;
	public int anInt86;
	public boolean onMinimap;
	public int childrenIDs[];
	public String description;
	public int anInt91;
	public int anInt92;
	public boolean aBoolean93;
	public int[] models;
	public static MRUNodes mruNodes = new MRUNodes(30);

}