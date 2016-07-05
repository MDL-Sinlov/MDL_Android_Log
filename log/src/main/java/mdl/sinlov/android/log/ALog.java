package mdl.sinlov.android.log;

/**
 * Android Logger
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by "sinlov" on 16/6/16.
 */
public final class ALog {
    private static final String DEFAULT_TAG = "ALog";

    private static IALogPrinter iALogPrinter = new ALogPrinter();

    //no instance
    private ALog() {
    }

    /**
     * It is used to get the settings object in order to change settings
     *
     * @return the settings object
     */
    public static ALogSettings initTag() {
        return initTag(DEFAULT_TAG);
    }

    /**
     * It is used to change the tag
     *
     * @param tag is the given string which will be used in Logger as TAG
     * @return {@link ALogSettings}
     */
    public static ALogSettings initTag(String tag) {
        iALogPrinter = new ALogPrinter();
        return iALogPrinter.initTag(tag);
    }

    public static void clear() {
        iALogPrinter.clear();
        iALogPrinter = null;
    }

    public static IALogPrinter t(String tag) {
        return iALogPrinter.t(tag, iALogPrinter.getALogSettings().getMethodCount());
    }

    public static IALogPrinter t(int methodCount) {
        return iALogPrinter.t(null, methodCount);
    }

    public static IALogPrinter t(String tag, int methodCount) {
        return iALogPrinter.t(tag, methodCount);
    }

    public static void d(String message, Object... args) {
        iALogPrinter.d(message, args);
    }

    public static void e(String message, Object... args) {
        iALogPrinter.e(null, message, args);
    }

    public static void e(Throwable throwable, String message, Object... args) {
        iALogPrinter.e(throwable, message, args);
    }

    public static void i(String message, Object... args) {
        iALogPrinter.i(message, args);
    }

    public static void v(String message, Object... args) {
        iALogPrinter.v(message, args);
    }

    public static void w(String message, Object... args) {
        iALogPrinter.w(message, args);
    }

    public static void wtf(String message, Object... args) {
        iALogPrinter.wtf(message, args);
    }

    /**
     * Formats the json content and print it
     *
     * @param json the json content
     */
    public static void json(String json) {
        iALogPrinter.json(json);
    }

    /**
     * Formats the json content and print it
     *
     * @param xml the xml content
     */
    public static void xml(String xml) {
        iALogPrinter.xml(xml);
    }
}
