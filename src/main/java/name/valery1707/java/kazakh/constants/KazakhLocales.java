package name.valery1707.java.kazakh.constants;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class KazakhLocales {

	public static final Locale KAZAKH = new Locale("kk");
	public static final Locale KAZAKH_KZ = new Locale("kk", "KZ");
	public static final Locale[] LOCALES_ARRAY = new Locale[]{KAZAKH, KAZAKH_KZ};
	public static final List<Locale> LOCALES_LIST = Arrays.asList(LOCALES_ARRAY);

	public static final Locale SOURCE_LOCALE = new Locale("ru", "RU");

	private KazakhLocales() {
	}

	public static void checkLocale(Locale locale) {
		if (locale == null) {
			throw new NullPointerException();
		}
		if (!LOCALES_LIST.contains(locale)) {
			throw notSupportedLocale(locale);
		}
	}

	public static IllegalArgumentException notSupportedLocale(Locale locale) {
		return new IllegalArgumentException("Locale \"" + locale + "\" " + "is not one of the supported locales (" + LOCALES_LIST + ")");
	}
}
