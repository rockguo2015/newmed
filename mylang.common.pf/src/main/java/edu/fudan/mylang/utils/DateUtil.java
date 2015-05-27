package edu.fudan.mylang.utils;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.time.DateUtils;

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

	public static String formatDate(Date date) {
		return DateFormat.getDateInstance().format(date);
	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); // minus number would decrement the days
		return cal.getTime();
	}

	public static Date addMonths(Date date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}
	
	public static Date lastDayOfYear(Date date){
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return addDays(new Date(date.getYear()+1, 0, 1),-1);
		
	}
	public static Date firstDayOfYear(Date date){
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return new Date(date.getYear(), 0, 1);
		
	}

	public static Long between(Date date1, Date date2) {
		return (date2.getTime() - date1.getTime()) / 1000 / 60 / 60 / 24;
	}

	public static Double betweenMonth(Date date1, Date date2) {
		return (date2.getTime() - date1.getTime()) / 1000.0 / 60 / 60 / 24 / 30;
	}

	public static Date trim2Month(Date date) {
		if (date == null)
			return null;
		return new Date(date.getYear(), date.getMonth(), 1);
	}

	public static Month getMonth(Date date) {
		return new Month(date.getYear() + 1900, date.getMonth() + 1);
	}
	
	public static String getYearString(Date date){
		return Integer.toString((date.getYear()+1900));
	}
	public static String getMonthString(Date date){
		return getMonth(date).serialize();
	}
	
	public static Date min(Date d1, Date d2){
		if(d1.getTime()>d2.getTime()) return d2;
		else return d1;
	}
	public static Date max(Date d1, Date d2){
		if(d1.getTime()>d2.getTime()) return d1;
		else return d2;
	
	}

	public static class Month {
		int year;
		int month;

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public Month(int year, int month) {
			super();
			this.year = year;
			this.month = month;
		}

		public String serialize() {
			return Integer.toString(year * 100 + month);
		}

		public static Iterator<Month> getIterator(final Date from, final Date to) {
			return new Iterator<Month>() {
				final Month _currentMonth = DateUtil.getMonth(from);
				final Month _to = DateUtil.getMonth(to);

				@Override
				public boolean hasNext() {
					return Long.parseLong(_currentMonth.serialize()) <= Long
							.parseLong(_to.serialize());
				}

				@Override
				public Month next() {
					Month result = new Month(_currentMonth.getYear(),
							_currentMonth.getMonth());
					if (_currentMonth.getMonth() == 12) {
						_currentMonth.setYear(_currentMonth.getYear() + 1);
						_currentMonth.setMonth(1);
					} else {
						_currentMonth.setMonth(_currentMonth.getMonth() + 1);
					}
					return result;
				}

				@Override
				public void remove() {
					// TODO Auto-generated method stub
				}
			};
		}
	}
	// /**
	// * @param date
	// * @param i
	// * @return get the date that several days before or after the provided
	// date
	// */
	// public static Date addDays(Date date, int i) {
	// Date newDate = new Date(date.getTime());
	// CalendarUtil.addDaysToDate(newDate, i);
	// return newDate;
	// }
	//
	// public static boolean equalsDate(Date d1, Date d2){
	// return d1.getYear() == d2.getYear() && d1.getMonth() == d2.getMonth() &&
	// d1.getDate() == d2.getDate();
	// }
	//
	// /**
	// * @param date
	// * @param i
	// * @return get the date that several months before or after the provided
	// * date
	// */
	// public static Date addMonths(Date date, int i) {
	// Date result = new Date(date.getTime());
	// CalendarUtil.addMonthsToDate(result, i);
	// return result;
	// }
	//
	// public static Date Day(int year, int month) {
	// Date day = new Date();
	// day = trimDate(day);
	// day.setYear(year - 1900);
	// day.setMonth(month - 1);
	// day.setDate(1);
	// return day;
	// }
	//
	// public static Date firstMonthDay(Date date) {
	// return Day(date.getYear() + 1900, date.getMonth() + 1 );
	// }
}
