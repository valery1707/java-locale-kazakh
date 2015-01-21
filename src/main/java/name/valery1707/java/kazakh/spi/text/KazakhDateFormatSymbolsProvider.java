package name.valery1707.java.kazakh.spi.text;

import name.valery1707.java.kazakh.text.KazakhDateFormatSymbols;

import java.text.DateFormatSymbols;
import java.text.spi.DateFormatSymbolsProvider;
import java.util.Locale;

import static name.valery1707.java.kazakh.constants.KazakhLocales.LOCALES_ARRAY;
import static name.valery1707.java.kazakh.constants.KazakhLocales.checkLocale;

public final class KazakhDateFormatSymbolsProvider extends DateFormatSymbolsProvider {

	public KazakhDateFormatSymbolsProvider() {
		super();
	}

	@Override
	public DateFormatSymbols getInstance(final Locale locale) {
		checkLocale(locale);
		return new KazakhDateFormatSymbols();
	}

	@Override
	public Locale[] getAvailableLocales() {
		return LOCALES_ARRAY;
	}
}
