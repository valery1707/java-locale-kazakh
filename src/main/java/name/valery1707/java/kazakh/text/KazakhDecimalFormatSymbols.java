package name.valery1707.java.kazakh.text;

import name.valery1707.java.kazakh.constants.KazakhLocales;

import java.text.DecimalFormatSymbols;
import java.util.Currency;

import static name.valery1707.java.kazakh.constants.KazakhStrings.CURRENCY_ID;
import static name.valery1707.java.kazakh.constants.KazakhStrings.CURRENCY_SYMBOL;

public final class KazakhDecimalFormatSymbols extends DecimalFormatSymbols {

	public KazakhDecimalFormatSymbols() {
		super(KazakhLocales.SOURCE_LOCALE);
		setCurrency(Currency.getInstance(CURRENCY_ID));
		setCurrencySymbol(CURRENCY_SYMBOL);
	}
}
