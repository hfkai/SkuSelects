package com.example.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Testsku {
	public static void main(String[] args) {
		Map<String, BaseSkuModel> productStocks = new LinkedHashMap<String, BaseSkuModel>();
		productStocks.put("4.5寸;红;64G", new BaseSkuModel(13, 20));//1;11 1;22  11;22 1; 11; 22;
		productStocks.put("5.0寸;土豪金;128G", new BaseSkuModel(14, 10));//addResult stock+stock2
		productStocks.put("5.0寸;黑;128G", new BaseSkuModel(14, 10));
		//		productStocks.put("2;13;23", new BaseSkuModel(13, 40));
//		productStocks.put("3;11;24", new BaseSkuModel(16, 70));
//		productStocks.put("4;14;24", new BaseSkuModel(17, 30));
//		productStocks.put("1;11;21", new BaseSkuModel(12, 22));
		//		System.out.println(Sku.skuCollection(productStocks));
		Map<String,BaseSkuModel> test;// = new LinkedHashMap<String, BaseSkuModel>()
		test = Sku.skuCollection(productStocks);
		System.out.println("通过Map.entrySet遍历key和value");
		List<Double> prices = new ArrayList<Double>();
		for (Map.Entry<String, BaseSkuModel> entry : test.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}
	}
	public static String minandmax(List<Double> prices){
		double min,max;
		min=max=prices.get(0);
		for(int i=0;i<prices.size();i++)
		{
//			System.out.print(prices.get(i)+" ");
			if(prices.get(i)>max)   // 判断最大值
				max=prices.get(i);
			if(prices.get(i)<min)   // 判断最小值
				min=prices.get(i);
		}
		return (max > min ? min + "-" + max : max+"");
	}
}
