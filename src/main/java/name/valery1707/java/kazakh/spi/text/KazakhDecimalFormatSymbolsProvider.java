package name.valery1707.java.kazakh.spi.text;

import name.valery1707.java.kazakh.text.KazakhDecimalFormatSymbols;

import java.text.DecimalFormatSymbols;
import java.text.spi.DecimalFormatSymbolsProvider;
import java.util.Locale;

import static name.valery1707.java.kazakh.constants.KazakhLocales.LOCALES_ARRAY;
import static name.valery1707.java.kazakh.constants.KazakhLocales.checkLocale;

public final class KazakhDecimalFormatSymbolsProvider extends DecimalFormatSymbolsProvider {

	public KazakhDecimalFormatSymbolsProvider() {
		super();
	}

	@Override
	public DecimalFormatSymbols getInstance(final Locale locale) {
		checkLocale(locale);
		return new KazakhDecimalFormatSymbols();
	}

	@Override
	public Locale[] getAvailableLocales() {
		return LOCALES_ARRAY;
	}
}
