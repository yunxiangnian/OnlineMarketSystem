package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String toDate(Date data){
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(data);
	}
}
