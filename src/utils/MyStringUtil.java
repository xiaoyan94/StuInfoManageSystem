package utils;

import org.springframework.util.StringUtils;

public class MyStringUtil {
	public static boolean isNotEmpty(Object str) {
		return !isEmpty(str);
	}
	
	public static boolean isEmpty(Object str) {
		return StringUtils.isEmpty(str);
	}
}
