package com.client.definitions;

import java.io.FileWriter;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.client.Animation;
import com.client.Client;
import com.client.MRUNodes;
import com.client.Model;
import com.client.OnDemandFetcher;
//import com.client.ByteBuf;
import com.client.Stream;
import com.client.StreamLoader;

public final class ObjectDefinition {

	public void applyTexturing(Model m, int id) {
		if (id == 26764)
			m.setTexture(26);
	}

	public static ObjectDefinition forID(int i) {
		if (i > streamIndices.length)
			i = streamIndices.length - 2;

		if (i == 25913 || i == 25916 || i == 25917)
			i = 15552;

		for (int j = 0; j < 20; j++)
			if (cache[j].type == i)
				return cache[j];

		cacheIndex = (cacheIndex + 1) % 20;
		ObjectDefinition objectDef = cache[cacheIndex];
		stream.currentOffset = streamIndices[i];
		objectDef.type = i;
		objectDef.setDefaults();
		objectDef.readValues(stream);
		if (i >= 26281 && i <= 26290) {
			objectDef.actions = new String[] { "Choose", null, null, null, null };
		}
		switch (i) {

		case 8207:
			objectDef.actions = new String[] { "Care-To", null, null, null, null };
			objectDef.name = "Herb Patch";
			break;
			case 8720:
				objectDef.name = "Vote shop";
				break;
		case 8210:
			objectDef.actions = new String[] { "Rake", null, null, null, null };
			objectDef.name = "Herb Patch";
			break;
			case 29150:
				objectDef.actions = new String[] { "Venerate", null, null, null, null };
				break;
		case 8139:
		case 8140:
		case 8141:
		case 8142:
			objectDef.actions = new String[] { "Inspect", null, null, null, null };
			objectDef.name = "Herbs";
			break;
		case 3840:
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Fill";
			objectDef.actions[1] = "Empty-From";
			objectDef.name = "Compost Bin";
			break;
			case 172:
				objectDef.name = "Ckey chest";
			break;
			case 12309:
				objectDef.actions = new String[5];
				objectDef.actions[0] = "Bank";
				objectDef.actions[1] = "Buy gloves";
				objectDef.actions[2] = null;
				objectDef.name = "Chest";
				break;
		case 24101:
			objectDef.actions[2] = "Trading Post";
			break;
		case 24150:
			objectDef.actions = new String[5];
			objectDef.actions[0] = null;
			objectDef.actions[1] = null;
			objectDef.name = "Well of Goodwill";
			objectDef.description = "The well of goodwill.";
			break;
		case 26782:
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Recharge";
			objectDef.actions[1] = null;
			objectDef.name = "Fountain of Rune";
			objectDef.description = "Fountain of Rune.";
			break;
		case 1750:
			objectDef.modelIds = new int[] { 8131, };
			objectDef.name = "Willow";
			objectDef.width = 2;
			objectDef.length = 2;
			objectDef.ambientLighting = 25;
			objectDef.actions = new String[] { "Chop down", null, null, null, null };
			objectDef.mapscene = 3;
			break;

		case 1751:
		case 10820:
			objectDef.modelIds = new int[] { 8037, 8040, };
			objectDef.name = "Oak";
			objectDef.width = 3;
			objectDef.length = 3;
			objectDef.ambientLighting = 25;
			objectDef.actions = new String[] { "Chop down", null, null, null, null };
			objectDef.mapscene = 1;
			break;
//Mount Karuulm
		case 34531:
			objectDef.actions = new String[] { "Climb", null, null, null, null };
			objectDef.name = "Steps";
			objectDef.description = "Just a bunch of steps";
			break;
		case 34530:
			objectDef.actions = new String[] { "Climb", null, null, null, null };
			objectDef.name = "Steps";
			objectDef.description = "Just a bunch of steps";
			break;
		case 34580:
		case 34583:
			objectDef.actions = new String[] { "Search", null, null, null, null };
			objectDef.name = "Stone Chest";
			objectDef.description = "It's a Stone Chest";
			break;
					
		case 10060:
			objectDef.actions = new String[] { null, null, null, null, null };
			objectDef.name = "Shop Barrier";
			objectDef.description = "Averon Shop Barrier";
			break;
		case 7814:
			objectDef.actions = new String[] { "Teleport", null, null, null, null };
			break;

		case 8356:
			objectDef.actions = new String[] { "Teleport", "Mt. Quidamortem", null, null, null };
			break;

		case 28900:
			objectDef.actions = new String[] { "Teleport", "Recharge Crystals", null, null, null };
			break;

		case 28837:
			objectDef.actions = new String[] { "Set Destination", null, null, null, null };
			break;

		case 7811:
			objectDef.name = "District Supplies";
			objectDef.actions = new String[] { "Blood Money", "Free", "Quick-Sets", null, null };
			break;

		case 1752:
			objectDef.modelIds = new int[] { 4146, };
			objectDef.name = "Hollow tree";
			objectDef.ambientLighting = 25;
			objectDef.actions = new String[] { "Chop down", null, null, null, null };
			objectDef.originalModelColors = new int[] { 13592, 10512, };
			objectDef.modifiedModelColors = new int[] { 7056, 6674, };
			objectDef.mapscene = 0;
			break;
		case 4873:
			objectDef.name = "Wilderness Lever";
			objectDef.actions = new String[] { "Enter Deep Wildy", null, null, null, null };
			break;
		case 29735:
			objectDef.name = "Basic Slayer Dungeon";
			break;
		case 2544:
			objectDef.name = "Dagannoth Manhole";
			break;
		case 29345:
			objectDef.name = "Training Teleports Portal";
			objectDef.actions = new String[] { "Teleport", null, null, null, null };
			break;
		case 29346:
			objectDef.name = "Wilderness Teleports Portal";
			objectDef.actions = new String[] { "Teleport", null, null, null, null };
			break;
		case 29347:
			objectDef.name = "Boss Teleports Portal";
			objectDef.actions = new String[] { "Teleport", null, null, null, null };
			break;
		case 29349:
			objectDef.name = "Mini-Game Teleports Portal";
			objectDef.actions = new String[] { "Teleport", null, null, null, null };
			break;
		case 4155:
			objectDef.name = "Zul Andra Portal";
			break;
		case 2123:
			objectDef.name = "Mt. Quidamortem Slayer Dungeon";
			break;
		case 4150:
			objectDef.name = "Warriors Guild Mini-game Portal";
			break;
		case 11803:
			objectDef.name = "Donator Slayer Dungeon";
			break;
		case 4151:
			objectDef.name = "Barrows Mini-game Portal";
			break;
		case 1753:
			objectDef.modelIds = new int[] { 8157, };
			objectDef.name = "Yew";
			objectDef.width = 3;
			objectDef.length = 3;
			objectDef.ambientLighting = 25;
			objectDef.actions = new String[] { "Chop down", null, null, null, null };
			objectDef.mapscene = 3;
			break;
		case 10822:
			objectDef.modelIds = new int[] { 8157, };
			objectDef.name = "Yew";
			objectDef.width = 3;
			objectDef.length = 3;
			objectDef.ambientLighting = 25;
			objectDef.actions = new String[] { "Chop down", null, null, null, null };
			objectDef.mapscene = 3;
			break;
		case 6943:
			objectDef.modelIds = new int[] { 1270, };
			objectDef.name = "Bank booth";
			objectDef.impenetrable = false;
			objectDef.ambientLighting = 25;
			objectDef.contrast = 25;
			objectDef.actions = new String[] { null, "Bank", "Collect", null, null };
			break;

		case 25016:
		case 25017:
		case 25018:
		case 25029:
			objectDef.actions = new String[] { "Push-Through", null, null, null, null };
			break;

		case 19038:
			objectDef.actions = new String[] { null, null, null, null, null };
			objectDef.width = 3;
			objectDef.length = 3;
			objectDef.scaleZ = 340; // Width
			objectDef.scaleX = 500; // Thickness
			objectDef.scaleY = 400; // Height
			break;

		case 18826:
		case 18819:
		case 18818:
			objectDef.width = 3;
			objectDef.length = 3;
			objectDef.scaleZ = 200; // Width
			objectDef.scaleX = 200; // Thickness
			objectDef.scaleY = 100; // Height
			break;

		case 27777:
			objectDef.name = "Gangplank";
			objectDef.actions = new String[] { "Travel to CrabClaw Isle", null, null, null, null };
			objectDef.width = 1;
			objectDef.length = 1;
			objectDef.scaleZ = 80; // Width
			objectDef.scaleX = 80; // Thickness
			objectDef.scaleY = 250; // Height
			break;
		case 13641:
			objectDef.name = "Teleportation Device";
			objectDef.actions = new String[] { "Quick-Teleport", null, null, null, null };
			objectDef.width = 1;
			objectDef.length = 1;
			objectDef.scaleZ = 80; // Width
			objectDef.scaleX = 80; // Thickness
			objectDef.scaleY = 250; // Height
			break;

		case 11700:
			objectDef.modelIds = new int[] { 4086 };
			objectDef.name = "Venom";
			objectDef.width = 3;
			objectDef.length = 3;
			objectDef.solid = false;
			objectDef.contouredGround = true;
			objectDef.animation = 1261;
			objectDef.modifiedModelColors = new int[] { 31636 };
			objectDef.originalModelColors = new int[] { 10543 };
			objectDef.scaleX = 160;
			objectDef.scaleY = 160;
			objectDef.scaleZ = 160;
			objectDef.actions = new String[5];
			// objectDef.description = new String(
			// "It's a cloud of venomous smoke that is extremely toxic.");
			break;
			
		case 2936:
			objectDef.name = "Trading Post";
			objectDef.description = "Averon's Trading Post";
			objectDef.actions[0] = "Open";
			break;
		case 23676:
			objectDef.name = "Averon Teleporter";
			objectDef.description = "Averon's Teleporter";
			objectDef.actions[0] = "Teleport";
			break;
		case 11601: // 11601
			objectDef.originalTexture = new short[] { 2 };
			objectDef.modifiedTexture = new short[] { 46 };
			break;
		}
		if (Client.debugModels) {

			if (objectDef.name == null || objectDef.name.equalsIgnoreCase("null"))
				objectDef.name = "test";

			objectDef.hasActions = true;
		}
		return objectDef;
	}

	public static void dumpList() {
		try {
			FileWriter fw = new FileWriter(System.getProperty("user.home") + "./object_data.json");
			fw.write("[\n");
			for (int i = 0; i < totalObjects; i++) {
				ObjectDefinition def = ObjectDefinition.forID(i);
				String output = "[\"" + StringUtils.join(def.actions, "\", \"") + "\"],";

				String finalOutput = "	{\n" + "		\"id\": " + def.type + ",\n		" + "\"name\": \"" + def.name
						+ "\",\n		\"models\": " + Arrays.toString(def.modelIds) + ",\n		\"actions\": "
						+ output.replaceAll(", \"\"]", ", \"Examine\"]").replaceAll("\"\"", "null")
								.replace("[\"null\"]", "[null, null, null, null, \"Examine\"]")
								.replaceAll(", \"Remove\"", ", \"Remove\", \"Examine\"")
						+ "	\n		\"width\": " + def.scaleZ + "\n	},";
				fw.write(finalOutput.replaceAll("\"name\": \"null\",", "\"name\": null,"));

				// .replaceAll("\"name\": \"null\",", "\"name\": null,")
				fw.write(System.getProperty("line.separator"));
			}
			fw.write("]");
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void applyTexture(Model model, int id) {
		switch (id) {
		case 26764:// Venenatis Webs
			model.setTexture(26);
			break;
		}
	}

	private void setDefaults() {
		modelIds = null;
		modelTypes = null;
		name = null;
		description = null;
		modifiedModelColors = null;
		originalModelColors = null;
		// originalTexture = null;
		// modifiedTexture = null;
		width = 1;
		length = 1;
		solid = true;
		impenetrable = true;
		hasActions = false;
		contouredGround = false;
		delaysShading = false;
		occludes = false;
		animation = -1;
		decorDisplacement = 16;
		ambientLighting = 0;
		contrast = 0;
		actions = null;
		mapFunction = -1;
		mapscene = -1;
		inverted = false;
		castsShadow = true;
		scaleX = 128;
		scaleY = 128;
		scaleZ = 128;
		surroundings = 0;
		translateX = 0;
		translateY = 0;
		translateZ = 0;
		obstructsGround = false;
		hollow = false;
		supportItems = -1;
		anInt774 = -1;
		anInt749 = -1;
		childrenIDs = null;
	}

	public void method574(OnDemandFetcher class42_sub1) {
		if (modelIds == null)
			return;
		for (int j = 0; j < modelIds.length; j++)
			class42_sub1.method560(modelIds[j] & 0xffff, 0);
	}

	public static void nullLoader() {
		mruNodes1 = null;
		mruNodes2 = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public static int totalObjects;

	public static void unpackConfig(StreamLoader streamLoader) {
		stream = new Stream(streamLoader.getDataForName("loc.dat"));
		Stream stream = new Stream(streamLoader.getDataForName("loc.idx"));
		totalObjects = stream.readUnsignedShort();
		streamIndices = new int[totalObjects];
		int i = 2;
		for (int j = 0; j < totalObjects; j++) {
			streamIndices[j] = i;
			i += stream.readUnsignedShort();
		}
		cache = new ObjectDefinition[20];
		for (int k = 0; k < 20; k++)
			cache[k] = new ObjectDefinition();
		dumpList();
	}

	public boolean method577(int i) {
		if (modelTypes == null) {
			if (modelIds == null)
				return true;
			if (i != 10)
				return true;
			boolean flag1 = true;
			Model model = (Model) mruNodes2.insertFromCache(type);
			for (int k = 0; k < modelIds.length; k++)
				flag1 &= Model.method463(modelIds[k] & 0xffff);
			applyTexturing(model, type);
			return flag1;
		}
		Model model = (Model) mruNodes2.insertFromCache(type);
		for (int j = 0; j < modelTypes.length; j++)
			if (modelTypes[j] == i)
				return Model.method463(modelIds[j] & 0xffff);
		applyTexturing(model, type);
		return true;
	}

	public Model modelAt(int i, int j, int k, int l, int i1, int j1, int k1) {
		Model model = method581(i, k1, j);
		if (model == null)
			return null;
		if (contouredGround || delaysShading)
			model = new Model(contouredGround, delaysShading, model);
		if (contouredGround) {
			int l1 = (k + l + i1 + j1) / 4;
			for (int i2 = 0; i2 < model.numVertices; i2++) {
				int j2 = model.vertexX[i2];
				int k2 = model.vertexZ[i2];
				int l2 = k + ((l - k) * (j2 + 64)) / 128;
				int i3 = j1 + ((i1 - j1) * (j2 + 64)) / 128;
				int j3 = l2 + ((i3 - l2) * (k2 + 64)) / 128;
				model.vertexY[i2] += j3 - l1;
			}

			model.method467();
		}
		return model;
	}

	public boolean method579() {
		if (modelIds == null)
			return true;
		boolean flag1 = true;
		for (int i = 0; i < modelIds.length; i++)
			flag1 &= Model.method463(modelIds[i] & 0xffff);
		return flag1;
	}

	public ObjectDefinition method580() {
		int i = -1;
		if (anInt774 != -1) {
			VarBit varBit = VarBit.cache[anInt774];
			int j = varBit.anInt648;
			int k = varBit.anInt649;
			int l = varBit.anInt650;
			int i1 = Client.anIntArray1232[l - k];
			i = clientInstance.variousSettings[j] >> k & i1;
		} else if (anInt749 != -1)
			i = clientInstance.variousSettings[anInt749];
		if (i < 0 || i >= childrenIDs.length || childrenIDs[i] == -1)
			return null;
		else
			return forID(childrenIDs[i]);
	}

	private Model method581(int j, int k, int l) {
		Model model = null;
		long l1;
		if (modelTypes == null) {
			if (j != 10)
				return null;
			l1 = (type << 6) + l + ((long) (k + 1) << 32);
			Model model_1 = (Model) mruNodes2.insertFromCache(l1);
			if (model_1 != null)
				return model_1;
			applyTexture(model, type);
			if (modelIds == null)
				return null;
			boolean flag1 = inverted ^ (l > 3);
			int k1 = modelIds.length;
			for (int i2 = 0; i2 < k1; i2++) {
				int l2 = modelIds[i2];
				if (flag1)
					l2 += 0x10000;
				model = (Model) mruNodes1.insertFromCache(l2);
				if (model == null) {
					model = Model.method462(l2 & 0xffff);
					applyTexture(model, type);
					if (model == null)
						return null;
					if (flag1)
						model.method477();
					mruNodes1.removeFromCache(model, l2);
				}
				if (k1 > 1)
					aModelArray741s[i2] = model;
			}

			if (k1 > 1)
				model = new Model(k1, aModelArray741s);
		} else {
			int i1 = -1;
			for (int j1 = 0; j1 < modelTypes.length; j1++) {
				if (modelTypes[j1] != j)
					continue;
				i1 = j1;
				break;
			}

			if (i1 == -1)
				return null;
			l1 = (type << 8) + (i1 << 3) + l + ((long) (k + 1) << 32);
			Model model_2 = (Model) mruNodes2.insertFromCache(l1);
			if (model_2 != null)
				return model_2;
			int j2 = modelIds[i1];
			boolean flag3 = inverted ^ (l > 3);
			if (flag3)
				j2 += 0x10000;
			model = (Model) mruNodes1.insertFromCache(j2);
			if (model == null) {
				model = Model.method462(j2 & 0xffff);
				applyTexture(model, type);// try
				if (model == null)
					return null;
				if (flag3)
					model.method477();
				mruNodes1.removeFromCache(model, j2);
			}
		}
		boolean flag;
		flag = scaleX != 128 || scaleY != 128 || scaleZ != 128;
		boolean flag2;
		flag2 = translateX != 0 || translateY != 0 || translateZ != 0;
		Model model_3 = new Model(modifiedModelColors == null && modifiedTexture == null, Animation.method532(k),
				l == 0 && k == -1 && !flag && !flag2, model);
		if (k != -1) {
			model_3.method469();
			model_3.method470(k);
			model_3.faceGroups = null;
			model_3.vertexGroups = null;
		}
		while (l-- > 0)
			model_3.method473();
		if (modifiedModelColors != null) {
			for (int k2 = 0; k2 < modifiedModelColors.length; k2++)
				model_3.method476(modifiedModelColors[k2], originalModelColors[k2]);

		}
		if (modifiedTexture != null) {
			for (int k2 = 0; k2 < modifiedTexture.length; k2++)
				model_3.replaceTexture(modifiedTexture[k2], originalTexture[k2]);

		}
		if (flag)
			model_3.method478(scaleX, scaleZ, scaleY);
		if (flag2)
			model_3.method475(translateX, translateY, translateZ);
		// model_3.method479(64 + aByte737, 768 + aByte742 * 5, -50, -10, -50,
		// !aBoolean769);
		// ORIGINAL^

		model_3.method479(64 + ambientLighting, 768 + contrast * 5, -50, -10, -50, !delaysShading);

		if (supportItems == 1)
			model_3.itemDropHeight = model_3.modelHeight;
		mruNodes2.removeFromCache(model_3, l1);
		return model_3;
	}

	public void readValues(Stream stream) {
		int flag = -1;
		do {
		//int lastSuccess = -1;
		//while(true) {
			int opcode = stream.readUnsignedByte();
			if (opcode == 0) 
				break;
			 if (opcode == 1) {
				int len = stream.readUnsignedByte();
				if (len > 0) {
					if (modelIds == null || lowMem) {
						modelTypes = new int[len];
						modelIds = new int[len];
						
						for (int k1 = 0; k1 < len; k1++) {
							modelIds[k1] = stream.readUnsignedShort();
							modelTypes[k1] = stream.readUnsignedByte();
						}
					} else {
						stream.currentOffset += len * 3;
					}
				}
			} else if (opcode == 2) {
				name = stream.readString();
			} else if (opcode == 3) {
				description = stream.readString();
		    } else if (opcode == 5) {
				int len = stream.readUnsignedByte();
				if (len > 0) {
					if (modelIds == null || lowMem) {
						modelTypes = null;
						modelIds = new int[len];
						for (int i = 0; i < len; i++) {
							modelIds[i] = stream.readUnsignedShort();
						}
					} else {
						stream.currentOffset += len * 2;
					}
				}
			} else if (opcode == 14) {
				width = stream.readUnsignedByte();
			} else if (opcode == 15) {
				length = stream.readUnsignedByte();
		    } else if (opcode == 17)  {
				solid = false;
		    } else if (opcode == 18) {
				impenetrable = false;
		    } else if (opcode == 19) {
				hasActions = (stream.readUnsignedByte() == 1);
		    } else if (opcode == 21) {
				contouredGround = true;
		    } else if (opcode == 22) {
				delaysShading = true;
		    } else if (opcode == 23) {
				occludes = true;
		    } else if (opcode == 24) { // Object Animations
				animation = stream.readUnsignedShort();
				if (animation == 65535) {
					animation = -1;
				}
		    } else if (opcode == 27) {
				clipType = 1;
			} else if (opcode == 28) {
				decorDisplacement = stream.readUnsignedByte();
			} else if (opcode == 29) {
				ambientLighting = stream.readSignedByte();
			} else if (opcode == 39) {
				contrast = stream.readSignedByte();
			} else if (opcode >= 30 && opcode < 35) { //was 39
				if (actions == null) {
					actions = new String[5]; //was 9
				}
				actions[opcode - 30] = stream.readString();
				if (actions[opcode - 30].equalsIgnoreCase("hidden")) {
					actions[opcode - 30] = null;
				}
			} else if (opcode == 40) {
				int len = stream.readUnsignedByte();
				modifiedModelColors = new int[len];
				originalModelColors = new int[len];
				for (int i = 0; i < len; i++) {
					modifiedModelColors[i] = stream.readUnsignedShort();
					originalModelColors[i] = stream.readUnsignedShort();
				}
			} else if (opcode == 41) {
				int len = stream.readUnsignedByte();
				originalTexture = new short[len];
				modifiedTexture = new short[len];
				for (int i = 0; i < len; i++) {
					originalTexture[i] = (short) stream.readUnsignedShort();
					modifiedTexture[i] = (short) stream.readUnsignedShort();
				}
			} else if (opcode == 60) {
				mapFunction = stream.readUnsignedShort();
			} else if (opcode == 62) {
				inverted = true;
			} else if (opcode == 64) {
				castsShadow = false;
			} else if (opcode == 65) {
				scaleX = stream.readUnsignedShort();
			} else if (opcode == 66) {
				scaleY = stream.readUnsignedShort();
			} else if (opcode == 67) {
				scaleZ = stream.readUnsignedShort();
			} else if (opcode == 68) {
				mapscene = stream.readUnsignedShort();
			} else if (opcode == 69) {
				surroundings = stream.readUnsignedByte();
			} else if (opcode == 70) {
				translateX = stream.readUnsignedShort();
			} else if (opcode == 71) {
				translateY = stream.readUnsignedShort();
			} else if (opcode == 72) {
				translateZ = stream.readUnsignedShort();
			} else if (opcode == 73) {
				obstructsGround = true;
			} else if (opcode == 74) {
				hollow = true;
			} else if (opcode == 75) {
				supportItems = stream.readUnsignedByte();
			} else if (opcode == 78) {
				stream.readUnsignedShort(); // ambient sound id
				stream.readUnsignedByte();
				/*} else if (opcode == 79) { // old
					stream.readUnsignedShort();
					stream.readUnsignedShort();
					stream.readUnsignedByte();
					int len = stream.readUnsignedByte();
				
					for (int i = 0; i < len; i++) {
						stream.readUnsignedShort();
					}*/
			} else if (opcode == 79) {
				stream.currentOffset += 5;
                int len = stream.readSignedByte();
                stream.currentOffset += (len * 2);
			} else if (opcode == 81) {
				stream.readUnsignedByte();	
			} else if (opcode == 82) {
					mapFunction = stream.readUnsignedShort();
					
					if (mapFunction == 65535) {
						mapFunction = -1;
					}
			} else if (opcode == 77 || opcode == 92) {
				anInt774 = stream.readUnsignedShort();
				
				if (anInt774 == 65535) { //Varp
					anInt774 = -1;
				}
				
				anInt749 = stream.readUnsignedShort();
				
				if (anInt749 == 65535) { //Varbit
					anInt749 = -1;
				}
				
				int value = -1;

				if (opcode == 92) {
                    value = stream.readUnsignedShort();

                    if (value == 65535) {
                        value = -1;
                    }
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
			} 
		} while (true);
			 
		//	} else {
		//		
		//		System.out.println("invalid object opcode: " + opcode + " last " + lastSuccess);
		//		continue;
		//	}
		//	 lastSuccess = opcode;
		//}
		if (flag == -1 && name != "null" && name != null) {
			hasActions = modelIds != null && (modelTypes == null || modelTypes[0] == 10);
			if (actions != null)
				hasActions = true;
		}
		if (hollow) {
			solid = false;
			impenetrable = false;
		}
		if (supportItems == -1)
			supportItems = solid ? 1 : 0;
	}

	private ObjectDefinition() {
		type = -1;
	}

	private short[] originalTexture;
	private short[] modifiedTexture;
	public boolean obstructsGround;
	@SuppressWarnings("unused")
	public int contrast;
	@SuppressWarnings("unused")
	private byte ambientLighting;
	private int translateX;
	public String name;
	private int scaleZ;
	private static final Model[] aModelArray741s = new Model[4];
	public int width;
	private int translateY;
	public int mapFunction;
	private int[] originalModelColors;
	private int scaleX;
	public int anInt749;
	private boolean inverted;
	public static boolean lowMem;
	private static Stream stream;
	public int type;
	public static int[] streamIndices;
	public boolean impenetrable;
	public int mapscene;
	public int childrenIDs[];
	public int supportItems;
	public int length;
	public boolean contouredGround;
	public boolean occludes;
	public static Client clientInstance;
	private boolean hollow;
	public boolean solid;
	public int surroundings;
	private boolean delaysShading;
	private static int cacheIndex;
	private int scaleY;
	public int[] modelIds;
	public int anInt774;
	public int decorDisplacement;
	private int[] modelTypes;
	public String description;
	public boolean hasActions;
	public boolean castsShadow;
	public static MRUNodes mruNodes2 = new MRUNodes(30);
	public int animation;
	private static ObjectDefinition[] cache;
	private int translateZ;
	private int[] modifiedModelColors;
	public static MRUNodes mruNodes1 = new MRUNodes(500);
	public String actions[];
	int clipType = 2;

}
