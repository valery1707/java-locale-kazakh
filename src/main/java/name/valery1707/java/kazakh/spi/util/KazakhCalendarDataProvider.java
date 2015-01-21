package name.valery1707.java.kazakh.spi.util;

import java.util.Calendar;
import java.util.Locale;
import java.util.spi.CalendarDataProvider;

import static name.valery1707.java.kazakh.constants.KazakhLocales.LOCALES_ARRAY;

/**
 * @since JDK1.8
 */
public class KazakhCalendarDataProvider extends CalendarDataProvider {

	public KazakhCalendarDataProvider() {
		super();
	}

	@Override
	public int getFirstDayOfWeek(Locale locale) {
		return Calendar.MONDAY;
	}

	@Override
	public int getMinimalDaysInFirstWeek(Locale locale) {
		return 3;
	}

	@Override
	public Locale[] getAvailableLocales() {
		return LOCALES_ARRAY;
	}
}
