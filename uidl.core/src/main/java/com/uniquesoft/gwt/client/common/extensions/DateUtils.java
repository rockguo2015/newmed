package com.uniquesoft.gwt.client.common.extensions;

import java.util.Date;
import java.util.Iterator;

import com.google.gwt.user.datepicker.client.CalendarUtil;

/**
 * encapsulate some common operations for data type 
 *
 */
@SuppressWarnings("all")
public class DateUtils {

	/**
	 * @return the current date and remove the time information
	 */
	public static Date today() {
		Date date = new Date();
		return trimDate(date);
	}

	/**
	 * Remove the time detail
	 * @param date
	 * @return
	 */
	public static Date trimDate(Date date) {
		if (date == null)
			return null;
		date.setHours(12);
		date.setMinutes(0);
		date.setSeconds(0);
		return date;
	}

	/**
	 * @param date
	 * @return Change the date displaying style, format it as yyyy/mm/dd
	 */
	public static String format(Date date) {
		String result = "";
		result += date.getYear() + 1900;
		result += "/" + (date.getMonth() + 1);
		result += "/" + date.getDate();
		return result;
	}

	/**
	 * Change the date to the next day and set the time to the start of the day
	 * @param date
	 * @return Get the start time of next day
	 */
	public static Date nextStart(Date date) {
		Date result = CalendarUtil.copyDate(date);
		CalendarUtil.addDaysToDate(result, 1);
		result.setHours(0);
		date.setMinutes(0);
		date.setSeconds(1);
		return result;
	}

	/**
	 * Change the date to the day before and set the time to the end of that day 
	 * @param date
	 * @return the last date time of yesterday
	 */
	public static Date lastEnd(Date date) {
		Date result = CalendarUtil.copyDate(date);
		CalendarUtil.addDaysToDate(result, -1);
		result.setHours(23);
		date.setMinutes(59);
		date.setSeconds(59);
		return result;
	}


	/**
	 * Calculate the date several days before or after the established date
	 * @param date
	 * @param i days interval
	 * @return the date that has several days difference to the established date.
	 */
	public static Date addDays(Date date, int i) {
		CalendarUtil.addDaysToDate(date, i);
		return date;
	}

	/**
	 * Calculate the date that several months before or after the established date
	 * @param date the established date
	 * @param i months interval
	 * @return the date that has several months difference to the established date.
	 */
	public static Date addMonths(Date date, int i) {
		CalendarUtil.addMonthsToDate(date, i);
		return date;
	}
}
