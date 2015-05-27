package com.uniquesoft.gwt.client.common;

import java.util.Date;
import java.util.Iterator;

import javax.annotation.Nonnull;

import com.google.gwt.user.datepicker.client.CalendarUtil;

/**
 *  This class contains static utility methods that operate on or return object
 *  of type {@link Date}
 *
 */
@SuppressWarnings("all")
public class DateUtilsOld {

	/**
     * Allocates a Date object and initializes it to 
     * represent the specified number of milliseconds since the 
     * standard base time known as "the epoch", namely January 1, 
     * 1970, 00:00:00 GMT, and set the time to 12:00:00.
     */
	public static Date today() {
		Date date = new Date();
		return trimDate(date);
	}

	/**
	 * Sets the date to 12:00:00
	 * 
	 * @param date the date object to be classify
	 */
	public static Date trimDate(Date date) {
		if (date == null)
			return null;
		date.setHours(12);
		date.setMinutes(0);
		date.setSeconds(0);
		return date;
	}
	
	public static Date appendTime(Date date, Date time){
		if(date==null || time ==null) return null;
		Date dateTime = new Date();
		dateTime.setYear(date.getYear());
		dateTime.setMonth(date.getMonth());
		dateTime.setDate(date.getDate());
		dateTime.setHours(date.getHours());
		dateTime.setMinutes(date.getMinutes());
		return dateTime;
	}

	/**
	 * Returns the date that formated the form "yyyy/mm/dd".
	 * 
	 * @param date the date object to be formated
	 * @return
	 */
	public static String format(Date date) {
		String result = "";
		result += date.getYear() + 1900;
		result += "/" + (date.getMonth() + 1);
		result += "/" + date.getDate();
		return result;
	}
	/**
	 * Returns the date that move to the first second of next day
	 * 
	 * @param date the original date
	 * @return
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
	 * Returns the date that move to the last second of present day
	 * 
	 * @param date the original date
	 * @return
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
	 * Returns the date that forward {@code i} days 
	 * 
	 * @param date the original date
	 * @param i the number of day shall be add
	 * @return
	 */
	public static Date addDays(Date date, int i) {
		CalendarUtil.addDaysToDate(date, i);
		return date;
	}
	
	/**
	 * Returns the date that forward {@code i} months 
	 * 
	 * @param date the original date
	 * @param i the number of months shall be add
	 * @return
	 */
	public static Date addMonths(Date date, int i) {
		CalendarUtil.addMonthsToDate(date, i);
		return date;
	}
}
