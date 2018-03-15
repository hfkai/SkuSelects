package com.example.owner.skuselect.Sku;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/6/3.
 * 浮点数的相关操作，eg:浮点数精确值运算，浮点数的精度问题
 */
public class FloatUtils {
    /**
     * f1 + f2
     * @param f1
     * @param f2
     * @return f1 + f2的浮点数结果
     */
    public static float add(float f1,float f2){
        BigDecimal f11 = new BigDecimal(String.valueOf(f1));
        BigDecimal f22 = new BigDecimal(String.valueOf(f2));
        return f11.add(f22).floatValue();
    }

    /**
     * f1 - f2
     * @param f1
     * @param f2
     * @return f1 - f2浮点数结果
     */
    public static float subtract(float f1,float f2){
        BigDecimal f11 = new BigDecimal(String.valueOf(f1));
        BigDecimal f22 = new BigDecimal(String.valueOf(f2));
        return f11.subtract(f22).floatValue();
    }

    /**
     * f1 * f2
     * @param f1
     * @param f2
     * @return f1 * f2 的浮点数结果
     */
    public static float multiply(float f1, float f2){
        BigDecimal f11 = new BigDecimal(String.valueOf(f1));
        BigDecimal f22 = new BigDecimal(String.valueOf(f2));
        return f11.multiply(f22).floatValue();
    }
    /**
     * 对double数据进行取精度.
     * @param value  double数据.
     * @param scale  精度位数(保留的小数位数).
     * @param roundingMode  精度取值方式.
     * @return 精度计算后的数据.
     */
    public static double round(double value, int scale,
                               int roundingMode) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(scale, roundingMode);
        double d = bd.doubleValue();
        bd = null;
        return d;
    }
    /**
     * f1 / f2
     * @param f1
     * @param f2
     * @return f1 / f2 的浮点数结果
     */
    public static float divide(float f1,float f2){
        BigDecimal f11 = new BigDecimal(String.valueOf(f1));
        BigDecimal f22 = new BigDecimal(String.valueOf(f2));
        return f11.divide(f22).floatValue();
    }

    /**
     * num保留digit位小数
     * @return
     */
    public static String decimalPlace(float num, int digit){
        return String.format("%."+digit+"f", num).toString();
    }
    public static String change(String a) {
        float weight= Float.parseFloat(a);
        String all = decimalPlace(weight, 2);
        return all;
    }
    public static String decimalPlace(double num, int digit){
        return String.format("%."+digit+"f", num).toString();
    }
    public static double sub(BigDecimal d1, BigDecimal d2)
    {        // 进行减法运算
//        BigDecimal b1 = new BigDecimal(d1);
//        BigDecimal b2 = new BigDecimal(d2);
        return d1.subtract(d2).doubleValue();
    }
    public static String results(String d1, String d2){
        BigDecimal weal = null;
        BigDecimal all = null;
        try {
            double mywealth = Double.valueOf(d1).doubleValue();
            double allprice = Double.valueOf(d2).doubleValue();
            weal = new BigDecimal(mywealth);
            all = new BigDecimal(allprice);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return String.format("%."+2+"f", sub(weal,all)).toString();
    }
    public static boolean comdeng(String d1, String d2){
        double mywealth = Double.valueOf(d1).doubleValue();
        double allprice = Double.valueOf(d2).doubleValue();
        return mywealth == allprice;
    }
    public static boolean compareToThis(String d1, String d2){
        BigDecimal weal = null;
        BigDecimal all = null;
        try {
            double mywealth = Double.valueOf(d1).doubleValue();
            double allprice = Double.valueOf(d2).doubleValue();
            weal = new BigDecimal(mywealth);
            all = new BigDecimal(allprice);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return weal.compareTo(all)>=0;
    }
}
