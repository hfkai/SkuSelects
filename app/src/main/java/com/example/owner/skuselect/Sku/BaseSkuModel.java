package com.example.owner.skuselect.Sku;


/**
 * 商品基本数据存储类
 * @author hfk
 */
public class BaseSkuModel {

    //base 属性
    private double price;//价格
    private long stock;//库存

    public String getFormatNum() {
        return FormatNum;
    }

    public void setFormatNum(String formatNum) {
        FormatNum = formatNum;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    private String FormatNum;
    private String picture;
    public BaseSkuModel(){

    }
    public BaseSkuModel(GoodsDetailsModel.RowsBean.GoodsFormatSKUBean.SkuKeyBean
                        skuKeyBean) {
        this.price = Double.parseDouble(skuKeyBean.getPrice());
        this.stock =  Integer.parseInt(skuKeyBean.getInventory());
        this.FormatNum = skuKeyBean.getFormatNum();
        this.picture = skuKeyBean.getPicture();
    }
    public BaseSkuModel(GetFormatModel.RowsBean.GoodsFormatSKUBean.SkuKeyBean
                                skuKeyBean) {
        this.price = Double.parseDouble(skuKeyBean.getPrice());
        this.stock =  Integer.parseInt(skuKeyBean.getInventory());
        this.FormatNum = skuKeyBean.getFormatNum();
        this.picture = skuKeyBean.getPicture();
    }
    public BaseSkuModel(BaseSkuModel
                                skuKeyBean) {
        this.price = skuKeyBean.getPrice();
        this.stock =  skuKeyBean.getStock();
        this.FormatNum = skuKeyBean.getFormatNum();
        this.picture = skuKeyBean.getPicture();
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

    @Override
    public String toString() {
        return "BaseSkuModel{" +
                "price=" + price +
                ", stock=" + stock +
                ", FormatNum='" + FormatNum + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
