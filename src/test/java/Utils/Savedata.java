package Utils;

import java.util.Map;

public class Savedata {

	private static final ThreadLocal<Map<String, String>> testData = new ThreadLocal<>();

	// private static Map<String, String> testData =new LinkedHashMap<>();

	public static void setData(Map<String, String> data) {

		testData.set(data);

	}

	public static String get(String key) {
		return testData.get().get(key);
	}

	public static Map<String, String> getData() {
		return testData.get();
	}

	public static void clear() {
		testData.remove();

	}

	public static void setbrowserData(Map<String, String> data) {

		testData.set(data);
	}
}