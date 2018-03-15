package com.example.owner.skuselect.Sku;

import java.util.List;


/**
 * 作者：Administrator on 2017/10/11 0011 09:52
 * 邮箱：xjs250@163.com
 */
public class GetFormatModel{

    /**
     * rows : {"GoodsFormatSKU":[{"key":"{5.0寸},-,{土豪金},-,{128G}","Sku_Key":{"FormatNum":"6605910a-9766-462e-8b17-c5130a5606db","picture":"pro/201709/28094840141.jpg","Price":"5667.00","inventory":"30"}},{"key":"{5.0寸},-,{白},-,{64G}","Sku_Key":{"FormatNum":"f917e910-f759-4245-8dbf-fdf29e9adcd7","picture":"pro/201709/28094845376.png","Price":"4000.00","inventory":"40"}},{"key":"{4.7寸},-,{黑},-,{32G}","Sku_Key":{"FormatNum":"7ff59802-289c-428d-9c40-982d61b85d5a","picture":"pro/201709/28094850094.jpg","Price":"3000.00","inventory":"20"}},{"key":"{5.5寸},-,{土豪金},-,{8G}","Sku_Key":{"FormatNum":"85581eb7-af26-4672-acb1-f460ba1a19f2","picture":"pro/201709/28094855954.png","Price":"1000.00","inventory":"1000"}},{"key":"{5.0寸},-,{土豪金},-,{64G}","Sku_Key":{"FormatNum":"a5b681b6-409a-4254-a58f-dd7ada18bb62","picture":"pro/201709/28094902407.jpg","Price":"3200.00","inventory":"18"}},{"key":"{5.0寸},-,{红},-,{8G}","Sku_Key":{"FormatNum":"43b52496-8b72-4dc9-b20f-83fbf07f1e17","picture":"pro/201709/28094910579.jpg","Price":"3200.00","inventory":"966"}}],"Goods":{"GoodsNum":"P0000000004","ModelAliasSKU":[{"Name":"尺寸","ModelAlias":["5.0寸","4.7寸","5.5寸"]},{"Name":"颜色","ModelAlias":["土豪金","白","黑","红"]},{"Name":"内存","ModelAlias":["128G","64G","32G","8G"]},{"Name":"","ModelAlias":[]},{"Name":"","ModelAlias":[]}]}}
     */

    private RowsBean rows;

    public RowsBean getRows() {
        return rows;
    }

    public void setRows(RowsBean rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * GoodsFormatSKU : [{"key":"{5.0寸},-,{土豪金},-,{128G}","Sku_Key":{"FormatNum":"6605910a-9766-462e-8b17-c5130a5606db","picture":"pro/201709/28094840141.jpg","Price":"5667.00","inventory":"30"}},{"key":"{5.0寸},-,{白},-,{64G}","Sku_Key":{"FormatNum":"f917e910-f759-4245-8dbf-fdf29e9adcd7","picture":"pro/201709/28094845376.png","Price":"4000.00","inventory":"40"}},{"key":"{4.7寸},-,{黑},-,{32G}","Sku_Key":{"FormatNum":"7ff59802-289c-428d-9c40-982d61b85d5a","picture":"pro/201709/28094850094.jpg","Price":"3000.00","inventory":"20"}},{"key":"{5.5寸},-,{土豪金},-,{8G}","Sku_Key":{"FormatNum":"85581eb7-af26-4672-acb1-f460ba1a19f2","picture":"pro/201709/28094855954.png","Price":"1000.00","inventory":"1000"}},{"key":"{5.0寸},-,{土豪金},-,{64G}","Sku_Key":{"FormatNum":"a5b681b6-409a-4254-a58f-dd7ada18bb62","picture":"pro/201709/28094902407.jpg","Price":"3200.00","inventory":"18"}},{"key":"{5.0寸},-,{红},-,{8G}","Sku_Key":{"FormatNum":"43b52496-8b72-4dc9-b20f-83fbf07f1e17","picture":"pro/201709/28094910579.jpg","Price":"3200.00","inventory":"966"}}]
         * Goods : {"GoodsNum":"P0000000004","ModelAliasSKU":[{"Name":"尺寸","ModelAlias":["5.0寸","4.7寸","5.5寸"]},{"Name":"颜色","ModelAlias":["土豪金","白","黑","红"]},{"Name":"内存","ModelAlias":["128G","64G","32G","8G"]},{"Name":"","ModelAlias":[]},{"Name":"","ModelAlias":[]}]}
         */

        private GoodsBean Goods;
        private List<GoodsFormatSKUBean> GoodsFormatSKU;

        public GoodsBean getGoods() {
            return Goods;
        }

        public void setGoods(GoodsBean Goods) {
            this.Goods = Goods;
        }

        public List<GoodsFormatSKUBean> getGoodsFormatSKU() {
            return GoodsFormatSKU;
        }

        public void setGoodsFormatSKU(List<GoodsFormatSKUBean> GoodsFormatSKU) {
            this.GoodsFormatSKU = GoodsFormatSKU;
        }

        public static class GoodsBean {
            /**
             * GoodsNum : P0000000004
             * ModelAliasSKU : [{"Name":"尺寸","ModelAlias":["5.0寸","4.7寸","5.5寸"]},{"Name":"颜色","ModelAlias":["土豪金","白","黑","红"]},{"Name":"内存","ModelAlias":["128G","64G","32G","8G"]},{"Name":"","ModelAlias":[]},{"Name":"","ModelAlias":[]}]
             */

            private String GoodsNum;
            private List<ModelAliasSKUBean> ModelAliasSKU;

            public String getGoodsNum() {
                return GoodsNum;
            }

            public void setGoodsNum(String GoodsNum) {
                this.GoodsNum = GoodsNum;
            }

            public List<ModelAliasSKUBean> getModelAliasSKU() {
                return ModelAliasSKU;
            }

            public void setModelAliasSKU(List<ModelAliasSKUBean> ModelAliasSKU) {
                this.ModelAliasSKU = ModelAliasSKU;
            }

            public static class ModelAliasSKUBean {
                /**
                 * Name : 尺寸
                 * ModelAlias : ["5.0寸","4.7寸","5.5寸"]
                 */

                private String Name;
                private List<String> ModelAlias;

                public String getName() {
                    return Name;
                }

                public void setName(String Name) {
                    this.Name = Name;
                }

                public List<String> getModelAlias() {
                    return ModelAlias;
                }

                public void setModelAlias(List<String> ModelAlias) {
                    this.ModelAlias = ModelAlias;
                }
            }
        }

        public static class GoodsFormatSKUBean {
            /**
             * key : {5.0寸},-,{土豪金},-,{128G}
             * Sku_Key : {"FormatNum":"6605910a-9766-462e-8b17-c5130a5606db","picture":"pro/201709/28094840141.jpg","Price":"5667.00","inventory":"30"}
             */

            private String key;
            private SkuKeyBean Sku_Key;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public SkuKeyBean getSku_Key() {
                return Sku_Key;
            }

            public void setSku_Key(SkuKeyBean Sku_Key) {
                this.Sku_Key = Sku_Key;
            }

            public static class SkuKeyBean {
                /**
                 * FormatNum : 6605910a-9766-462e-8b17-c5130a5606db
                 * picture : pro/201709/28094840141.jpg
                 * Price : 5667.00
                 * inventory : 30
                 */

                private String FormatNum;
                private String picture;
                private String Price;
                private String inventory;

                public String getFormatNum() {
                    return FormatNum;
                }

                public void setFormatNum(String FormatNum) {
                    this.FormatNum = FormatNum;
                }

                public String getPicture() {
                    return picture;
                }

                public void setPicture(String picture) {
                    this.picture = picture;
                }

                public String getPrice() {
                    return Price;
                }

                public void setPrice(String Price) {
                    this.Price = Price;
                }

                public String getInventory() {
                    return inventory;
                }

                public void setInventory(String inventory) {
                    this.inventory = inventory;
                }
            }
        }
    }
}
