package mdl.sinlov.android.log;

/**
 * log level
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
public enum ALogLevel {

    /**
     * None of log will print
     */
    NONE,
    /**
     * full log will print
     */
    FULL,
    /**
     * show in warning and error Level
     */
    ONLY_WARNING_ERROR,
    /**
     * every log change level to Warning except Error
     */
    CHANGE_TO_WARNING_ERROR
}
