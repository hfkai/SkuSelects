package com.example.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 项目名称：Sku算法
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：2016/11/3 下午2:32
 * 修改人：N.Sun
 * 修改时间：2016/11/3 下午2:32
 * 修改备注：
 */

public class Sku {

    /**
     * 算法入口
     *
     * @param initData 所有库存的hashMap组合
     * @return 拆分所有组合产生的所有情况（生成客户端自己的字典）
     */
    public static Map<String, BaseSkuModel> skuCollection(Map<String, BaseSkuModel> initData) {
        //用户返回数据
        HashMap<String, BaseSkuModel> result = new HashMap<String, BaseSkuModel>();
        // 遍历所有库存
        for (String subKey : initData.keySet()) {
            BaseSkuModel skuModel = initData.get(subKey);
            System.out.println(">>>>subKey"+subKey);
            //根据；拆分key的组合
            String[] skuKeyAttrs = subKey.split(";");

            //获取所有的组合
            ArrayList<ArrayList<String>> combArr = combInArray(skuKeyAttrs);
            System.out.println("combArr+>>>"+combArr.toString());
            // 对应所有组合添加到结果集里面
            for (int i = 0; i < combArr.size(); i++) {
                add2SKUResult(result, combArr.get(i), skuModel);
            }
            // 将原始的库存组合也添加进入结果集里面
            String key = join(";", skuKeyAttrs);
//            System.out.println("key2--<>>"+key);
            result.put(key, skuModel);
        }
        return result;
    }
    public static String join(CharSequence delimiter, Object[] tokens) {
        StringBuilder sb = new StringBuilder();
        boolean firstTime = true;
        for (Object token: tokens) {
            if (firstTime) {
                firstTime = false;
            } else {
                sb.append(delimiter);
            }
            sb.append(token);
        }
        return sb.toString();
    }

    /**
     * 获取所有的组合放到ArrayList里面
     *
     * @param skuKeyAttrs 单个key被； 拆分的数组
     * @return ArrayList
     */
    public static ArrayList<ArrayList<String>> combInArray(String[] skuKeyAttrs) {
        if (skuKeyAttrs == null || skuKeyAttrs.length <= 0)
            return null;
        int len = skuKeyAttrs.length;
        ArrayList<ArrayList<String>> aResult = new ArrayList<ArrayList<String>>();
        for (int n = 1; n < len; n++) {
            ArrayList<Integer[]> aaFlags = getCombFlags(len, n);
//            for (int i = 0; i < aaFlags.size(); i++) {
//            	for (int j = 0; j < aaFlags.get(i).length; j++) {
//            		System.out.println(aaFlags.get(i)[j].toString()+">>>>aaFlage");
//				}
//			}

            for (int i = 0; i < aaFlags.size(); i++) {
                Integer[] aFlag = aaFlags.get(i);
                ArrayList<String> aComb = new ArrayList<String>();
                for (int j = 0; j < aFlag.length; j++) {
                    if (aFlag[j] == 1) {
                        aComb.add(skuKeyAttrs[j]);
                    }
                }
                aResult.add(aComb);
            }
        }
        return aResult;
    }
    public static String join(CharSequence delimiter, Iterable tokens) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = tokens.iterator();
        if (it.hasNext()) {
            sb.append(it.next());
            while (it.hasNext()) {
                sb.append(delimiter);
                sb.append(it.next());
            }
        }
        return sb.toString();
    }
    /**
     * 算法拆分组合 用1和0 的移位去做控制
     * （这块需要你打印才能看的出来）
     *
     * @param len
     * @param n
     * @return
     */
    private static ArrayList<Integer[]> getCombFlags(int len, int n) {
        if (n <= 0) {
            return new ArrayList<Integer[]>();
        }
        ArrayList<Integer[]> aResult = new ArrayList<Integer[]>();
        Integer[] aFlag = new Integer[len];
        boolean bNext = true;
        int iCnt1 = 0;
        //初始化
        for (int i = 0; i < len; i++) {
            aFlag[i] = i < n ? 1 : 0;
        }
        aResult.add(aFlag.clone());
        while (bNext) {
            iCnt1 = 0;
            for (int i = 0; i < len - 1; i++) {
                if (aFlag[i] == 1 && aFlag[i + 1] == 0) {
                    for (int j = 0; j < i; j++) {
                        aFlag[j] = j < iCnt1 ? 1 : 0;
                    }
                    aFlag[i] = 0;
                    aFlag[i + 1] = 1;
                    Integer[] aTmp = aFlag.clone();
                    aResult.add(aTmp);
                    if (!join("", aTmp).substring(len - n).contains("0")) {
                        bNext = false;
                    }
                    break;
                }
                if (aFlag[i] == 1) {
                    iCnt1++;
                }
            }
        }
        return aResult;
    }

    /**
     * 添加到数据集合
     *
     * @param result
     * @param newKeyList
     * @param skuModel
     */
    private static void add2SKUResult(HashMap<String, BaseSkuModel> result, ArrayList<String> newKeyList, BaseSkuModel skuModel) {
        System.out.println("--->>>>newKeyList"+newKeyList.toString());
        String key = join(";", newKeyList);
        System.out.println("key: "+key);
        if (result.keySet().contains(key)) {
            result.get(key).setStock(result.get(key).getStock() + skuModel.getStock());
            result.get(key).setPrice(skuModel.getPrice());
        } else {
            result.put(key, new BaseSkuModel(skuModel.getPrice(), skuModel.getStock()));
        }
        System.out.println("result:>>"+result.toString());
    }

}
