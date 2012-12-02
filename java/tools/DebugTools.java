package tools;

public class DebugTools {

	public static enum DEBUG_LEVEL {
		QUIET(0), FATAL(1), ERROR(2), INFO(3), VERBOSE(4), DEBUG(5), DEBUG2(6), DEBUG3(7);
		
		private int level;
		
		private DEBUG_LEVEL(int level) {
			this.level = level;
		}
		
		int level() {
			return level;
		}
	};

	public static DEBUG_LEVEL debugLevel = DEBUG_LEVEL.QUIET;

	public static void println(String arg) {
		println(arg, DEBUG_LEVEL.DEBUG);
	}
	
	public static void println(long arg) {
		println(arg, DEBUG_LEVEL.DEBUG);
	}
	
	public static void println(boolean arg) {
		println(arg, DEBUG_LEVEL.DEBUG);
	}
	
	public static void println() {
		println(DEBUG_LEVEL.DEBUG);
	}
	
	public static void printHex(byte[] bytes) {
		println(Tools.bytes2Hex(bytes));
	}
	
	public static void println(String arg, DEBUG_LEVEL level) {
		if (levelOk(level)) {
			System.out.println(arg);
		}
	}
	
	public static void println(long arg, DEBUG_LEVEL level) {
		if (levelOk(level)) {
			System.out.println(arg);
		}
	}
	
	public static void println(boolean arg, DEBUG_LEVEL level) {
		if (levelOk(level)) {
			System.out.println(arg);
		}
	}
	
	public static void println(DEBUG_LEVEL level) {
		if (levelOk(level)) {
			System.out.println();
		}
	}
	
	public static void printHex(byte[] bytes, DEBUG_LEVEL level) {
		if (levelOk(level)) {
			println(Tools.bytes2Hex(bytes), level);
		}
	}
	
	
	private static boolean levelOk(DEBUG_LEVEL level) {
		return level.level() <= debugLevel.level();
	}

}
