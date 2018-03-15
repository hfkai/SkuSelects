package com.example.owner.skuselect.Sku;

import android.util.Log;

/**
 *
 */
public class LogUtil {
    private static final boolean mEnablePrint = true;

    /**
     * 打印日志时获取当前的程序文件名、行号、方法名 输出格式为：[FileName | LineNumber | MethodName]
     *
     * @return tag
     */
    public static String getTag() {
        if (mEnablePrint){
            StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
            return "[" + traceElement.getFileName() + " | " + traceElement.getLineNumber() + " | " + traceElement.getMethodName() + "]";
        }
        return "";
    }

    public static void v(String tag, String log) {
        if (mEnablePrint) {
            Log.v(tag, log);
        }
    }

    public static void i(String tag, String log) {
        if (mEnablePrint) {
            Log.i(tag, log);
        }
    }

    public static void e(String tag, String log) {
        if (mEnablePrint) {
            Log.e(tag, log);
        }
    }

    public static void d(String tag, String log) {
        if (mEnablePrint) {
            Log.d(tag, log);
        }
    }

    public static void w(String tag, String log) {
        if (mEnablePrint) {
            Log.w(tag, log);
        }

    }

    public static void w(String tag, String log, Exception e) {
        if (mEnablePrint) {
            Log.e(tag, log, e);
        }
    }

}
