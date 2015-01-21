package name.valery1707.java.kazakh.spi.text;

import java.text.Collator;
import java.text.spi.CollatorProvider;
import java.util.Locale;

import static name.valery1707.java.kazakh.constants.KazakhLocales.*;

public final class KazakhCollatorProvider extends CollatorProvider {

	public KazakhCollatorProvider() {
		super();
	}

	@Override
	public Collator getInstance(final Locale locale) {
		checkLocale(locale);
		return Collator.getInstance(SOURCE_LOCALE);
	}

	@Override
	public Locale[] getAvailableLocales() {
		return LOCALES_ARRAY;
	}
}
