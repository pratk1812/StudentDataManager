package com.finan.myutil;

import org.apache.commons.lang3.StringUtils;

import com.finan.entity.Student;

public class Format {
	
	private static String formatName(String name) {
        return StringUtils.substringBefore(name, " ");
    }

    private static String formatClass(String classString) {
        return StringUtils.leftPad(classString, 2, '0');
    }

    private static String formatDiv(String div) {
        return StringUtils.rightPad(div, 2, '0');
    }

	private static String formatAddress(String address) {
		String[] splitStrings = StringUtils.split(address.replaceAll("-", ""), ",");
		String str = StringUtils.join(splitStrings, ",");
		return str;
	}
	private static String formatFee(String fee) {
        return StringUtils.leftPad(StringUtils.substring(fee, 0, -3), 4, '0');
	}
	public static String entityString(Student student) {
		
		String[] formattedStrings = {
			formatName(student.getName()),
			formatClass(student.getClassString()),
			formatDiv(student.getDivision()),
			student.getId(),
			formatAddress(student.getAddress()),
			formatFee(student.getFee())
		};
		
		return StringUtils.join(formattedStrings, "|");
	}
}
