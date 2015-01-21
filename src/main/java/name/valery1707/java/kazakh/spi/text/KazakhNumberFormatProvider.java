package name.valery1707.java.kazakh.spi.text;

import name.valery1707.java.kazakh.text.KazakhDecimalFormatSymbols;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;
import java.util.Locale;

import static name.valery1707.java.kazakh.constants.KazakhLocales.*;

public final class KazakhNumberFormatProvider extends NumberFormatProvider {

	public KazakhNumberFormatProvider() {
		super();
	}

	@Override
	public NumberFormat getCurrencyInstance(final Locale locale) {
		checkLocale(locale);
		final NumberFormat format = NumberFormat.getCurrencyInstance(SOURCE_LOCALE);
		if (format instanceof DecimalFormat) {
			((DecimalFormat) format).setDecimalFormatSymbols(new KazakhDecimalFormatSymbols());
		}
		return format;
	}

	@Override
	public NumberFormat getIntegerInstance(final Locale locale) {
		checkLocale(locale);
		final NumberFormat format = NumberFormat.getIntegerInstance(SOURCE_LOCALE);
		if (format instanceof DecimalFormat) {
			((DecimalFormat) format).setDecimalFormatSymbols(new KazakhDecimalFormatSymbols());
		}
		return format;
	}

	@Override
	public NumberFormat getNumberInstance(final Locale locale) {
		checkLocale(locale);
		final NumberFormat format = NumberFormat.getNumberInstance(SOURCE_LOCALE);
		if (format instanceof DecimalFormat) {
			((DecimalFormat) format).setDecimalFormatSymbols(new KazakhDecimalFormatSymbols());
		}
		return format;
	}

	@Override
	public NumberFormat getPercentInstance(final Locale locale) {
		checkLocale(locale);
		final NumberFormat format = NumberFormat.getPercentInstance(SOURCE_LOCALE);
		if (format instanceof DecimalFormat) {
			((DecimalFormat) format).setDecimalFormatSymbols(new KazakhDecimalFormatSymbols());
		}
		return format;
	}

	@Override
	public Locale[] getAvailableLocales() {
		return LOCALES_ARRAY;
	}
}
