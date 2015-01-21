package name.valery1707.java.kazakh.spi.util;

import java.util.Currency;
import java.util.Locale;
import java.util.spi.CurrencyNameProvider;

import static name.valery1707.java.kazakh.constants.KazakhLocales.*;

public final class KazakhCurrencyNameProvider extends CurrencyNameProvider {

	public KazakhCurrencyNameProvider() {
		super();
	}

	@Override
	public String getSymbol(final String currencyCode, final Locale locale) {
		checkLocale(locale);
		return Currency.getInstance(currencyCode).getSymbol(SOURCE_LOCALE);
	}

	@Override
	public Locale[] getAvailableLocales() {
		return LOCALES_ARRAY;
	}
}
