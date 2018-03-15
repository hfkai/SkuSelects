package com.example.leetcode;

public class BaseSkuModel {

    @Override
	public String toString() {
		return "[price=" + price + ", stock=" + stock + "]";
	}

	private double price;// 
    private long stock;// 

    public BaseSkuModel(double price, long stock) {
        this.price = price;
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }
}
