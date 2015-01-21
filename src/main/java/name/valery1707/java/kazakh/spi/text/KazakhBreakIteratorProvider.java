package name.valery1707.java.kazakh.spi.text;

import java.text.BreakIterator;
import java.text.spi.BreakIteratorProvider;
import java.util.Locale;

import static name.valery1707.java.kazakh.constants.KazakhLocales.*;

public final class KazakhBreakIteratorProvider extends BreakIteratorProvider {

	public KazakhBreakIteratorProvider() {
		super();
	}

	@Override
	public BreakIterator getCharacterInstance(final Locale locale) {
		checkLocale(locale);
		return BreakIterator.getCharacterInstance(SOURCE_LOCALE);
	}

	@Override
	public BreakIterator getLineInstance(final Locale locale) {
		checkLocale(locale);
		return BreakIterator.getLineInstance(SOURCE_LOCALE);
	}

	@Override
	public BreakIterator getSentenceInstance(final Locale locale) {
		checkLocale(locale);
		return BreakIterator.getSentenceInstance(SOURCE_LOCALE);
	}

	@Override
	public BreakIterator getWordInstance(final Locale locale) {
		checkLocale(locale);
		return BreakIterator.getWordInstance(SOURCE_LOCALE);
	}

	@Override
	public Locale[] getAvailableLocales() {
		return LOCALES_ARRAY;
	}
}
