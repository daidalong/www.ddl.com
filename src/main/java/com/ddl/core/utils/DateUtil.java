package com.ddl.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

	public static String getDateStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDDHHMMSS);
		return sdf.format(date);
	}
}