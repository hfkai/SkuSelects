package com.example.owner.skuselect.Sku;

/**
 * 更新视图接口类
 * Created by owner on 2017/9/23.
 */
public interface onViewChange {
    /**
     * 更新价格和库存
     * @param baseSkuModel
     * @param sku
     */
    void showPriceAndSku(BaseSkuModel baseSkuModel, String sku);
}
