package com.client;

public class Configuration {
	
	public static boolean newFonts = false;

	/**
	 * Attack option priorities 0 -> Depends on combat level 1 -> Always right-click
	 * 2 -> Left-click where available 3 -> Hidden
	 */
	public static int playerAttackOptionPriority = 0;
	public static int npcAttackOptionPriority = 2;
	
	public static boolean debug = true;
	
	public static final boolean DUMP_SPRITES = true;
	
	public static int xpSize = 0;
	public static int xpSpeed = 0;
	public static int xpDuration = 0;
	public static int xpColour = 0;
	public static int xpGroup = 0;
	
	public static boolean enableSmoothShading = true;
	public static boolean enableTileBlending = true;
	public static boolean enableAntiAliasing = false;
	public static boolean enableFogRendering = false;
    public static boolean enableRainbowFog = false;
	public static boolean bountyHunter = true;
	public static boolean playerNames = false;
	
	public static int chatColor = 0;
	
    public static int fogColor = 0xDCDBDF;
	public static long fogDelay = 500;
	
	public static final String CLIENT_TITLE = "Averon";
	public static final int CLIENT_VERSION = 1;
	public static Boolean LIVE_SERVER = true;
	public static final int PORT = 43595;
	
	public static Boolean DUMP_DATA = false;
	public static int dumpID = 149;
	public static Boolean DUMP_OTHER = false;

	/*
	 * Used to repack indexes Index 1 = Models Index 2 = Animations Index 3 =
	 * Sounds/Music Index 4 = Maps You can only do up to 300 files at a time
	 */
	public static final String CACHE_NAME = "Averon";
	public static boolean 
	        repackIndexOne = false, 
			repackIndexTwo = false, 
			repackIndexThree = false,
			repackIndexFour = false;
	public static final String CACHE_LINK = "http://averon-rsps.com/download/Averon.zip"; // Link for every client below client
	public static final String MEDIA_ARCHIVES_LINK = "http://averon-rsps.com/download/media_archives.zip"; // Link for every																								// client below //																						// updates
	public static final String MAIN_FILE_CACHE_URL = "http://averon-rsps.com/download/main_file_cache.zip"; // Link for every																								// client below //																			// updates
	public static final String SPRITE_CACHE_URL = "http://averon-rsps.com/download/sprites.zip"; // Link for every client below																					// client v1.12 - being
	public static final String VERSION_URL = "http://averon-rsps.com/download/version.txt";	
	/*
	 * Seasonal Events
	 */
	public static boolean HALLOWEEN = false;
	public static boolean CHRISTMAS = false;
	public static boolean CHRISTMAS_EVENT = false;
	public static boolean EASTER = false;
	public static boolean osbuddyGameframe = false;
	public static boolean oldGameframe = false;
	public static int gameWorld = 1;
	public static int xpPosition;
	public static boolean escapeCloseInterface = false;
	public static boolean inventoryContextMenu = true;
	public static int statMenuColor = 0xFF00FF;
	public static boolean alwaysLeftClickAttack;
	public static boolean hideCombatOverlay;
	/*
	 * Discord Rich Presence Configurations
	 */                              
    public static String discordAppId = "662061080763301938"; 
    public static String discordLine1 = "Community Driven RSPS";
    public static String discordLine2 = "https://averon-rsps.com/";
    public static String discordImage = "discord_icon";
}