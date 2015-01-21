package name.valery1707.java.kazakh.spi.util;

import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.TimeZone;
import java.util.spi.TimeZoneNameProvider;

import static name.valery1707.java.kazakh.constants.KazakhLocales.*;

public final class KazakhTimeZoneNameProvider extends TimeZoneNameProvider {

	public KazakhTimeZoneNameProvider() {
		super();
	}

	private static boolean isStyleValid(final int style) {
		return (style == TimeZone.SHORT || style == TimeZone.LONG);
	}

	private static void checkStyle(final int style) {
		if (!isStyleValid(style)) {
			throw new IllegalArgumentException("Style \"" + style + "\" is not valid");
		}
	}

	@Override
	public String getDisplayName(final String ID, final boolean daylight, final int style, final Locale locale) {
		if (ID == null) {
			throw new NullPointerException();
		}
		checkLocale(locale);
		checkStyle(style);

		final DateFormatSymbols symbols = DateFormatSymbols.getInstance(KAZAKH_KZ);
		final String[][] zoneStrings = symbols.getZoneStrings();

		/*
		 * First, try to retrieve a name using the specified ID as the main timezone ID
		 */
		for (String[] zoneString : zoneStrings) {
			if (ID.equalsIgnoreCase(zoneString[0])) {
				return getDisplayName(zoneString, daylight, style);
			}
		}

		/*
		 * Then try to retrieve a name using the specified ID as a short name
		 * (first, non-daylight saving - then, daylight-saving).
		 */
		for (String[] zoneString : zoneStrings) {
			String name = daylight ? zoneString[4] : zoneString[2];
			if (ID.equalsIgnoreCase(name)) {
				return getDisplayName(zoneString, daylight, style);
			}
		}

		/*
		 * If we don't have a name yet, default to source locale
		 */
		final TimeZone timeZone = TimeZone.getTimeZone(ID);
		return timeZone.getDisplayName(SOURCE_LOCALE);
	}

	private static String getDisplayName(final String[] zoneStrings, final boolean daylight, final int style) {
		switch (style) {
			case TimeZone.LONG:
				return (daylight ? zoneStrings[3] : zoneStrings[1]);
			case TimeZone.SHORT:
				return (daylight ? zoneStrings[4] : zoneStrings[2]);
		}
		return null;
	}

	@Override
	public Locale[] getAvailableLocales() {
		return LOCALES_ARRAY;
	}
}
