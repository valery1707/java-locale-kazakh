package name.valery1707.java.kazakh.spi.util;

import java.text.DateFormatSymbols;
import java.util.*;
import java.util.spi.CalendarNameProvider;

import static name.valery1707.java.kazakh.constants.KazakhLocales.LOCALES_ARRAY;
import static name.valery1707.java.kazakh.constants.KazakhLocales.SOURCE_LOCALE;
import static name.valery1707.java.kazakh.constants.KazakhStrings.*;

/**
 * @since JDK1.8
 */
public class KazakhCalendarNameProvider extends CalendarNameProvider {
	public static final DateFormatSymbols DATE_FORMAT_SYMBOLS = new DateFormatSymbols(SOURCE_LOCALE);

	@Override
	public String getDisplayName(String calendarType, int field, int value, int style, Locale locale) {
		switch (field) {
			case Calendar.ERA:
				return DATE_FORMAT_SYMBOLS.getEras()[value];
			case Calendar.MONTH:
				switch (style) {
					case Calendar.SHORT_FORMAT:
						return MONTH_SHORT_FORMAT[value].toLowerCase(locale);
					case Calendar.SHORT_STANDALONE:
						return MONTH_SHORT_STANDALONE[value];
					case Calendar.LONG_FORMAT:
						return MONTH_LONG_FORMAT[value].toLowerCase(locale);
					case Calendar.LONG_STANDALONE:
						return MONTH_LONG_STANDALONE[value];
					case Calendar.NARROW_FORMAT:
						return MONTH_NARROW_FORMAT[value].toLowerCase(locale);
					case Calendar.NARROW_STANDALONE:
						return MONTH_NARROW_STANDALONE[value];
					default:
						return null;
				}
			case Calendar.DAY_OF_WEEK:
				switch (style) {
					case Calendar.SHORT_FORMAT:
						return WEEKDAYS_SHORT_FORMAT[value].toLowerCase(locale);
					case Calendar.SHORT_STANDALONE:
						return WEEKDAYS_SHORT_STANDALONE[value];
					case Calendar.LONG_FORMAT:
						return WEEKDAYS_LONG_FORMAT[value].toLowerCase(locale);
					case Calendar.LONG_STANDALONE:
						return WEEKDAYS_LONG_STANDALONE[value];
					case Calendar.NARROW_FORMAT:
						return WEEKDAYS_NARROW_FORMAT[value].toLowerCase(locale);
					case Calendar.NARROW_STANDALONE:
						return WEEKDAYS_NARROW_STANDALONE[value];
					default:
						return null;
				}
			case Calendar.AM_PM:
				return DATE_FORMAT_SYMBOLS.getAmPmStrings()[value];
			case Calendar.DST_OFFSET:
			case Calendar.ZONE_OFFSET:
			default:
				return null;
		}
	}

	@Override
	public Map<String, Integer> getDisplayNames(String calendarType, int field, int style, Locale locale) {
		switch (field) {
			case Calendar.ERA:
				return buildMap(calendarType, field, style, locale, GregorianCalendar.BC, GregorianCalendar.AD);
			case Calendar.MONTH:
				return buildMap(calendarType, field, style, locale, Calendar.JANUARY, Calendar.DECEMBER);
			case Calendar.DAY_OF_WEEK:
				return buildMap(calendarType, field, style, locale, Calendar.SUNDAY, Calendar.SATURDAY);
			case Calendar.AM_PM:
				return buildMap(calendarType, field, style, locale, Calendar.AM, Calendar.PM);
			case Calendar.DST_OFFSET:
			case Calendar.ZONE_OFFSET:
			default:
				return null;
		}
	}

	private Map<String, Integer> buildMap(String calendarType, int field, int style, Locale locale, int valueMin, int valueMax) {
		int size = valueMax - valueMin + 1;
		HashMap<String, Integer> map;
		if (style == Calendar.ALL_STYLES) {
			map = new HashMap<String, Integer>(size * 6);
			map.putAll(buildMap(calendarType, field, Calendar.SHORT_FORMAT, locale, valueMin, valueMax));
			map.putAll(buildMap(calendarType, field, Calendar.SHORT_STANDALONE, locale, valueMin, valueMax));
			map.putAll(buildMap(calendarType, field, Calendar.LONG_FORMAT, locale, valueMin, valueMax));
			map.putAll(buildMap(calendarType, field, Calendar.LONG_STANDALONE, locale, valueMin, valueMax));
			map.putAll(buildMap(calendarType, field, Calendar.NARROW_FORMAT, locale, valueMin, valueMax));
			map.putAll(buildMap(calendarType, field, Calendar.NARROW_STANDALONE, locale, valueMin, valueMax));
		} else {
			map = new HashMap<String, Integer>(size);
			for (int i = valueMin; i <= valueMax; i++) {
				map.put(getDisplayName(calendarType, field, i, style, locale), i);
			}
		}
		return map;
	}

	@Override
	public Locale[] getAvailableLocales() {
		return LOCALES_ARRAY;
	}
}
