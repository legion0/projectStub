package tools;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Hashtable;

public class Tools {
	
	public static final Charset ASCII = Charset.forName("US-ASCII"); 

	public static String bytes2Hex(byte[] bytes) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.ensureCapacity(bytes.length * 3);
		for (byte b : bytes)
			stringBuilder.append(byte2Hex(b) + " ");
		if (stringBuilder.length() > 0)
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		return stringBuilder.toString();
	}

	public static String byte2Hex(byte b) {
		return String.format("%02x", b & 0xff);
	}

	public static String char2Printable(char c) {
		String str;
		if ('0' <= c && c <= '9' || 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || c == ' ' || c == '_') {
			str = String.valueOf(c);
		} else {
			str = byte2Hex((byte) c); // TODO: BAD
		}
		return str;
	}

	public static Hashtable<Byte, Integer> distribution(byte[] bytes) {
		Hashtable<Byte, Integer> distribution = new Hashtable<Byte, Integer>();
		for (byte b : bytes) {
			if (distribution.containsKey(b)) {
				distribution.put(b, distribution.get(b) + 1);
			} else
				distribution.put(b, 1);
		}
		return distribution;
	}

	public static int linearSearch(byte[] largeArray, byte[] subArray) {
		return linearSearch(largeArray, subArray, 0);
	}
	
	public static int linearSearch(byte[] largeArray, byte[] subArray, int startIndex) {
		if (subArray.length == 0) {
			return 0;
		}
		if (largeArray.length < startIndex + subArray.length) {
			return -1;
		}
		
		int limit = largeArray.length - subArray.length + 1;
		for (int i = startIndex; i < limit; i++) {
			if (largeArray[i] == subArray[0]) {
				boolean subArrayFound = true;
				for (int j = 0; j < subArray.length; j++) {
					if (subArray[j] != largeArray[i + j]) {
						subArrayFound = false;
						break;
					}
				}
				if (subArrayFound) {
					return i;
				}
			}
		}
		return -1;
	}

}
