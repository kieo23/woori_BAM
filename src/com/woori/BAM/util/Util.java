package com.woori.BAM.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
	 public static String getDateStr() {
		

	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
//	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	String formattedNow = now.format(formatter);
	
	return formattedNow;
	
	}
}
