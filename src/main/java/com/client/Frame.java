package com.client;

public final class Frame {
	static Frame[][] animationlist;

	public static void load(int file, byte[] data) {
		try {
			final Stream buffer = new Stream(data);
			final FrameBase frame = new FrameBase(buffer);
			final int len = buffer.readUShort();
			animationlist[file] = new Frame[len * 3];
			final int[] array2 = new int[500];
			final int[] array3 = new int[500];
			final int[] array4 = new int[500];
			final int[] array5 = new int[500];
			for (int j = 0; j < len; ++j) {
				final int k = buffer.readUShort();
				final Frame[] array6 = animationlist[file];
				final int n2 = k;
				final Frame q = new Frame();
				array6[n2] = q;
				final Frame q2 = q;
				q.aClass18_637 = frame;
				final int f = buffer.readUByte();
				int c2 = 0;
				int n3 = -1;
				for (int l = 0; l < f; ++l) {
					final int f2;
					if ((f2 = buffer.readUByte()) > 0) {
						if (frame.transformationType[l] != 0) {
							for (int n4 = l - 1; n4 > n3; --n4) {
								if (frame.transformationType[n4] == 0) {
									array2[c2] = n4;
									array3[c2] = 0;
									array5[c2] = (array4[c2] = 0);
									++c2;
									break;
								}
							}
						}
						array2[c2] = l;
						int n4 = 0;
						if (frame.transformationType[l] == 3) {
							n4 = 128;
						}
						if ((f2 & 0x1) != 0x0) {
							array3[c2] = buffer.readShort2();
						} else {
							array3[c2] = n4;
						}
						if ((f2 & 0x2) != 0x0) {
							array4[c2] = buffer.readShort2();
						} else {
							array4[c2] = n4;
						}
						if ((f2 & 0x4) != 0x0) {
							array5[c2] = buffer.readShort2();
						} else {
							array5[c2] = n4;
						}
						n3 = l;
						++c2;
					}
				}
				q2.anInt638 = c2;
				q2.transformationIndices = new int[c2];
				q2.transformX = new int[c2];
				q2.transformY = new int[c2];
				q2.transformZ = new int[c2];
				for (int l = 0; l < c2; ++l) {
					q2.transformationIndices[l] = array2[l];
					q2.transformX[l] = array3[l];
					q2.transformY[l] = array4[l];
					q2.transformZ[l] = array5[l];
				}
			}
		} catch (Exception ex) {
		}
	}

	static void nullLoader() {
		animationlist = null;
	}

	public static Frame method531(int int1) {
		try {
			int file = int1 >> 16;
			int frame = int1 & 0xFFFF;
			if (animationlist[file].length == 0) {
				Client.instance.onDemandFetcher.provide(1, file);
				return null;
			}
			if (animationlist[file][frame] == null) {
				return null;
			}
			return animationlist[file][frame];
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	static boolean method532(int i) {
		return i == -1;
	}

	public Frame() {
	}

	public int anInt636;
	FrameBase aClass18_637;
	int anInt638;
	int transformationIndices[];
	int transformX[];
	int transformY[];
	int transformZ[];

}
