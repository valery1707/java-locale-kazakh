package name.valery1707.java.kazakh.spi.text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.util.Locale;

import static name.valery1707.java.kazakh.constants.KazakhLocales.LOCALES_ARRAY;
import static name.valery1707.java.kazakh.constants.KazakhLocales.checkLocale;

public final class KazakhDateFormatProvider extends DateFormatProvider {

	//todo Fix
	public static final String PATTERN_DATE_SHORT = "d'/'MM'/'yy";
	public static final String PATTERN_DATE_MEDIUM = "dd'-'MMM'-'yyyy";
	public static final String PATTERN_DATE_LONG = "d 'de' MMMM 'de' yyyy";
	public static final String PATTERN_DATE_FULL = "EEEE d 'de' MMMM 'de' yyyy";

	public static final String PATTERN_TIME_SHORT = "H':'mm";
	public static final String PATTERN_TIME_MEDIUM = "H':'mm':'ss";
	public static final String PATTERN_TIME_LONG = "H':'mm':'ss z";
	public static final String PATTERN_TIME_FULL = "HH'H'mm'' z";

	public KazakhDateFormatProvider() {
		super();
	}

	private static boolean isStyleValid(final int style) {
		return (style == DateFormat.SHORT || style == DateFormat.MEDIUM ||
				style == DateFormat.LONG || style == DateFormat.FULL);
	}

	private static void checkStyle(final int style) {
		if (!isStyleValid(style)) {
			throw new IllegalArgumentException("Style \"" + style + "\" is not valid");
		}
	}

	@Override
	public DateFormat getDateInstance(final int style, final Locale locale) {
		checkLocale(locale);
		checkStyle(style);
		switch (style) {
			case DateFormat.FULL:
				return new SimpleDateFormat(PATTERN_DATE_FULL, locale);
			case DateFormat.LONG:
				return new SimpleDateFormat(PATTERN_DATE_LONG, locale);
			case DateFormat.MEDIUM:
				return new SimpleDateFormat(PATTERN_DATE_MEDIUM, locale);
			case DateFormat.SHORT:
			default:
				return new SimpleDateFormat(PATTERN_DATE_SHORT, locale);
		}
	}

	@Override
	public DateFormat getDateTimeInstance(final int dateStyle, final int timeStyle, final Locale locale) {
		checkLocale(locale);
		checkStyle(dateStyle);
		checkStyle(timeStyle);
		final StringBuilder pattern = new StringBuilder();
		switch (dateStyle) {
			case DateFormat.FULL:
				pattern.append(PATTERN_DATE_FULL);
				break;
			case DateFormat.LONG:
				pattern.append(PATTERN_DATE_LONG);
				break;
			case DateFormat.MEDIUM:
				pattern.append(PATTERN_DATE_MEDIUM);
				break;
			case DateFormat.SHORT:
			default:
				pattern.append(PATTERN_DATE_SHORT);
				break;
		}
		pattern.append(" ");
		switch (timeStyle) {
			case DateFormat.FULL:
				pattern.append(PATTERN_TIME_FULL);
				break;
			case DateFormat.LONG:
				pattern.append(PATTERN_TIME_LONG);
				break;
			case DateFormat.MEDIUM:
				pattern.append(PATTERN_TIME_MEDIUM);
				break;
			case DateFormat.SHORT:
			default:
				pattern.append(PATTERN_TIME_SHORT);
				break;
		}
		return new SimpleDateFormat(pattern.toString(), locale);
	}

	@Override
	public DateFormat getTimeInstance(final int style, final Locale locale) {
		checkLocale(locale);
		checkStyle(style);
		switch (style) {
			case DateFormat.FULL:
				return new SimpleDateFormat(PATTERN_TIME_FULL, locale);
			case DateFormat.LONG:
				return new SimpleDateFormat(PATTERN_TIME_LONG, locale);
			case DateFormat.MEDIUM:
				return new SimpleDateFormat(PATTERN_TIME_MEDIUM, locale);
			case DateFormat.SHORT:
			default:
				return new SimpleDateFormat(PATTERN_TIME_SHORT, locale);
		}
	}

	@Override
	public Locale[] getAvailableLocales() {
		return LOCALES_ARRAY;
	}
}
