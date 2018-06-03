package service.impl.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String format = sdf.format(new Date());
		Date parse = sdf.parse(format);
		System.out.println(format);
		String[] split = format.split("-");
		int endMonth=Integer.valueOf(split[1])+1;
		String format2 = split[0]+"-"+endMonth;
		Date parse2 = sdf.parse(format2);
		System.out.println(parse);
		System.out.println(parse2);
		
	}
}
