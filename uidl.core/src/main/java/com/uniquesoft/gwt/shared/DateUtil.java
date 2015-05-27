package com.uniquesoft.gwt.shared;

import java.text.DateFormat;
import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.datepicker.client.CalendarUtil;

/**
 * To manager the Data type, so that w can operate it easily. Provide some
 * common methods about the data type.
 * 
 */
public class DateUtil {

	/**
	 * @return the day information, not including time
	 */
	public static Date today() {
		Date date = new Date();
		return trimDate(date);
	}

	/**
	 * @return today's date information, including time
	 */
	public static Date now() {
		return new Date();
	}

	/**
	 * @param date
	 * @return Format the Date value, remove the hour, minutes and seconds
	 *         information
	 * 
	 */
	public static Date trimDate(Date date) {
		if (date == null)
			return null;
		return new Date(date.getYear(), date.getMonth(), date.getDate());
		// date.setHours(0);
		// date.setMinutes(0);
		// date.setSeconds(0);
		// return date;
	}

	/**
	 * @param date
	 * @param i
	 * @return get the date that several days before or after the provided date
	 */
	public static Date addDays(Date date, int i) {
		Date newDate = new Date(date.getTime());
		CalendarUtil.addDaysToDate(newDate, i);
		return newDate;
	}

	public static Date addHoursToDate(Date date, int hours) {
		Date newDate = new Date(date.getTime());
		newDate.setHours(newDate.getHours() + hours);
		return newDate;
	}
	public static Date addHoursToDate(Date date, Double hours) {
		return new Date(date.getTime()+(int)(hours*60*60*1000));
	}

	public static boolean equalsDate(Date d1, Date d2) {
		return d1.getYear() == d2.getYear() && d1.getMonth() == d2.getMonth()
				&& d1.getDate() == d2.getDate();
	}

	/**
	 * @param date
	 * @param i
	 * @return get the date that several months before or after the provided
	 *         date
	 */
	public static Date addMonths(Date date, int i) {
		Date result = new Date(date.getTime());
		CalendarUtil.addMonthsToDate(result, i);
		return result;
	}
	
	public static Double betweenMonth(Date date1, Date date2){
		return (date2.getTime() - date1.getTime())/1000.0/60/60/24/30;
		
	}

	public static Date Day(int year, int month) {
		Date day = new Date();
		day = trimDate(day);
		day.setYear(year - 1900);
		day.setMonth(month - 1);
		day.setDate(1);
		return day;
	}

	public static Date firstMonthDay(Date date) {
		return Day(date.getYear() + 1900, date.getMonth() + 1);
	}

	public static Date appendTime(Date day, Date time) {
		if(day==null || time==null) return null;
		Date result = new Date(day.getTime());
		result.setHours(time.getHours());
		result.setMinutes(time.getMinutes());
		return result;
	}

	public static String getFormatDateTime(Date dateTime) {
		return DateTimeFormat.getFormat(
				DateTimeFormat.PredefinedFormat.DATE_TIME_SHORT).format(
				dateTime);
	}
}
