package name.valery1707.java.kazakh.text;

import name.valery1707.java.kazakh.constants.KazakhLocales;

import java.text.DecimalFormatSymbols;

public final class KazakhDecimalFormatSymbols extends DecimalFormatSymbols {

	public KazakhDecimalFormatSymbols() {
		super(KazakhLocales.SOURCE_LOCALE);
	}
}
