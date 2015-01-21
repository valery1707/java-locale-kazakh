package name.valery1707.java.kazakh.text;

import name.valery1707.java.kazakh.constants.KazakhLocales;

import java.text.DateFormatSymbols;

import static name.valery1707.java.kazakh.constants.KazakhStrings.*;

public final class KazakhDateFormatSymbols extends DateFormatSymbols {

	public KazakhDateFormatSymbols() {
		super(KazakhLocales.SOURCE_LOCALE);
		this.setMonths(MONTH_LONG_STANDALONE);
		this.setShortMonths(MONTH_SHORT_STANDALONE);
		this.setWeekdays(WEEKDAYS_LONG_STANDALONE);
		this.setShortWeekdays(WEEKDAYS_SHORT_STANDALONE);
	}
}
