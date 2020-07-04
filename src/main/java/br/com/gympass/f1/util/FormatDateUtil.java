package br.com.gympass.f1.util;

import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Utility class that define format methods
 * 
 * @author yvesmendes
 */
public final class FormatDateUtil {

	private static DateFormat lapTimeDateFormat = new SimpleDateFormat("mm:ss.SSS");
	private static DateFormat eventHourDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
	private static DateFormat eventSecondsDateFormat = new SimpleDateFormat("ss.SSS");
	private static DecimalFormat decimalFormat;

	private FormatDateUtil() {
	}

	/**
	 * Return a decimal format with the following mask: #.### and rounding mode =
	 * {@link RoundingMode}.HALF_EVEN
	 * 
	 * @return a decimal formart to format numbers
	 */
	public static DecimalFormat getDecimalFormat() {
		if (decimalFormat == null) {
			decimalFormat = new DecimalFormat("#.###");
			decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);
		}
		return decimalFormat;
	}

	/**
	 * Returns a date format with the following pattern: HH:mm:ss.SSS
	 * 
	 * @return a {@link DateFormat} to parse and format date/strings
	 */
	public static DateFormat getEventHourDateFormat() {
		return eventHourDateFormat;
	}

	/**
	 * Returns a date format with the following pattern: mm:ss.SSS
	 * 
	 * @return a {@link DateFormat} to parse and format date/strings
	 */
	public static DateFormat getLapTimeDateFormat() {
		return lapTimeDateFormat;
	}

	/**
	 * Returns a date format with the following pattern: ss.SSS
	 * 
	 * @return a {@link DateFormat} to parse and format date/strings
	 */
	public static DateFormat getCumulativeLapTimeDateFormat() {
		return eventSecondsDateFormat;
	}
}
