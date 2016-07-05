package mdl.sinlov.android.log;

/**
 * Setting of printer
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
public final class ALogSettings {
    private int methodCount = 2;
    private boolean showThreadInfo = true;
    private int methodOffset = 0;
    private IALog logTool;

    /**
     * Determines how logs will printed
     */
    private ALogLevel aLogLevel = ALogLevel.FULL;

    public ALogSettings hideThreadInfo() {
        showThreadInfo = false;
        return this;
    }

    public ALogSettings methodCount(int methodCount) {
        if (methodCount < 0) {
            methodCount = 0;
        }
        this.methodCount = methodCount;
        return this;
    }

    public ALogSettings logLevel(ALogLevel aLogLevel) {
        this.aLogLevel = aLogLevel;
        return this;
    }


    public ALogSettings methodOffset(int offset) {
        this.methodOffset = offset;
        return this;
    }

    public ALogSettings logTool(IALog logTool) {
        this.logTool = logTool;
        return this;
    }

    public int getMethodCount() {
        return methodCount;
    }

    public boolean isShowThreadInfo() {
        return showThreadInfo;
    }

    public ALogLevel getALogLevel() {
        return aLogLevel;
    }

    public int getMethodOffset() {
        return methodOffset;
    }

    public IALog getLogTool() {
        if (logTool == null) {
            logTool = new AndroidLog();
        }
        return logTool;
    }
}
