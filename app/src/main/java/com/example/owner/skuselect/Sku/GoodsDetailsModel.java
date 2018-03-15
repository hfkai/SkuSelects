package com.example.owner.skuselect.Sku;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 商品详情
 * @author hfk
 * created at 2017/9/22 0022 16:05
 */
public class GoodsDetailsModel {

    /**
     * rows : {"GoodsFormatSKU":[{"key":"{5.0寸},-,{土豪金},-,{128G}","Sku_Key":{"FormatNum":"6605910a-9766-462e-8b17-c5130a5606db","picture":"","Price":"4000.00","inventory":"30"}},{"key":"{5.0寸},-,{白},-,{64G}","Sku_Key":{"FormatNum":"f917e910-f759-4245-8dbf-fdf29e9adcd7","picture":"","Price":"4000.00","inventory":"40"}},{"key":"{4.7寸},-,{黑},-,{32G}","Sku_Key":{"FormatNum":"7ff59802-289c-428d-9c40-982d61b85d5a","picture":"","Price":"3000.00","inventory":"20"}},{"key":"{5.5寸},-,{土豪金},-,{8G}","Sku_Key":{"FormatNum":"85581eb7-af26-4672-acb1-f460ba1a19f2","picture":"","Price":"1000.00","inventory":"1000"}},{"key":"{5.0寸},-,{土豪金},-,{64G}","Sku_Key":{"FormatNum":"a5b681b6-409a-4254-a58f-dd7ada18bb62","picture":"","Price":"3200.00","inventory":"18"}},{"key":"{5.7寸},-,{红},-,{8G}","Sku_Key":{"FormatNum":"43b52496-8b72-4dc9-b20f-83fbf07f1e17","picture":"","Price":"3200.00","inventory":"0"}}],"Goods":{"GoodsNum":"P0000000004","ModelAliasSKU":[{"Name":"尺寸","ModelAlias":["5.0寸","4.7寸","5.5寸","5.7寸"]},{"Name":"颜色","ModelAlias":["土豪金","白","黑","红"]},{"Name":"内存","ModelAlias":["128G","64G","32G","8G"]},{"Name":"","ModelAlias":[]},{"Name":"","ModelAlias":[]}],"Name":"小米6","picture":"","showPrice":"2450.00","SMAccount":"SP10000006","SMCompanyName":"百货公司","groups":"1","represent":"0","content":"<p>124124<\/p>","SaleNumber":"0","ShowSale":"0"},"GoodsParameter":[{"ParameterName":"颜色","ParameterVal":"白色\r\n                        "},{"ParameterName":"颜色","ParameterVal":"黑色\r\n                        "},{"ParameterName":"颜色","ParameterVal":"红色\r\n                        "},{"ParameterName":"尺码","ParameterVal":"S\r\n                        "}],"firstGoodsGroup":{"GroupNum":"0","GroupPrice":"0"},"GoodsVideo":[{"VideoPath":"uploadmovie/201709/15051307319.mp4","VideoImgPath":""},{"VideoPath":"uploadmovie/201709/20031140601.mp4","VideoImgPath":"VideoImg/201709/20031140601.png"},{"VideoPath":"uploadmovie/201709/21102023754.mp4","VideoImgPath":"VideoImg/201709/21102023754.png"}],"GoodsView":[{"ViewPath":"pro/20170920170915051017146.jpg"},{"ViewPath":"pro/20170920170915051017255.png"},{"ViewPath":"pro/20170920170921111233270.jpg"},{"ViewPath":"pro/20170920170921111234379.png"}]}
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
         * GoodsFormatSKU : [{"key":"{5.0寸},-,{土豪金},-,{128G}","Sku_Key":{"FormatNum":"6605910a-9766-462e-8b17-c5130a5606db","picture":"","Price":"4000.00","inventory":"30"}},{"key":"{5.0寸},-,{白},-,{64G}","Sku_Key":{"FormatNum":"f917e910-f759-4245-8dbf-fdf29e9adcd7","picture":"","Price":"4000.00","inventory":"40"}},{"key":"{4.7寸},-,{黑},-,{32G}","Sku_Key":{"FormatNum":"7ff59802-289c-428d-9c40-982d61b85d5a","picture":"","Price":"3000.00","inventory":"20"}},{"key":"{5.5寸},-,{土豪金},-,{8G}","Sku_Key":{"FormatNum":"85581eb7-af26-4672-acb1-f460ba1a19f2","picture":"","Price":"1000.00","inventory":"1000"}},{"key":"{5.0寸},-,{土豪金},-,{64G}","Sku_Key":{"FormatNum":"a5b681b6-409a-4254-a58f-dd7ada18bb62","picture":"","Price":"3200.00","inventory":"18"}},{"key":"{5.7寸},-,{红},-,{8G}","Sku_Key":{"FormatNum":"43b52496-8b72-4dc9-b20f-83fbf07f1e17","picture":"","Price":"3200.00","inventory":"0"}}]
         * Goods : {"GoodsNum":"P0000000004","ModelAliasSKU":[{"Name":"尺寸","ModelAlias":["5.0寸","4.7寸","5.5寸","5.7寸"]},{"Name":"颜色","ModelAlias":["土豪金","白","黑","红"]},{"Name":"内存","ModelAlias":["128G","64G","32G","8G"]},{"Name":"","ModelAlias":[]},{"Name":"","ModelAlias":[]}],"Name":"小米6","picture":"","showPrice":"2450.00","SMAccount":"SP10000006","SMCompanyName":"百货公司","groups":"1","represent":"0","content":"<p>124124<\/p>","SaleNumber":"0","ShowSale":"0"}
         * GoodsParameter : [{"ParameterName":"颜色","ParameterVal":"白色\r\n                        "},{"ParameterName":"颜色","ParameterVal":"黑色\r\n                        "},{"ParameterName":"颜色","ParameterVal":"红色\r\n                        "},{"ParameterName":"尺码","ParameterVal":"S\r\n                        "}]
         * firstGoodsGroup : {"GroupNum":"0","GroupPrice":"0"}
         * GoodsVideo : [{"VideoPath":"uploadmovie/201709/15051307319.mp4","VideoImgPath":""},{"VideoPath":"uploadmovie/201709/20031140601.mp4","VideoImgPath":"VideoImg/201709/20031140601.png"},{"VideoPath":"uploadmovie/201709/21102023754.mp4","VideoImgPath":"VideoImg/201709/21102023754.png"}]
         * GoodsView : [{"ViewPath":"pro/20170920170915051017146.jpg"},{"ViewPath":"pro/20170920170915051017255.png"},{"ViewPath":"pro/20170920170921111233270.jpg"},{"ViewPath":"pro/20170920170921111234379.png"}]
         */

        private GoodsBean Goods;
        private FirstGoodsGroupBean firstGoodsGroup;
        private List<GoodsFormatSKUBean> GoodsFormatSKU;
        private List<GoodsParameterBean> GoodsParameter;
        private List<GoodsVideoBean> GoodsVideo;
        private List<GoodsViewBean> GoodsView;
        /**
         * GoodsOrderEvaluateCount : 2
         * GoodsOrderEvaluate : {"account":"M10008","Nickname":"你左爸爸啊","HeadPortrait":"/Member/201712/20171219063734794.jpg","anonymous":1,"FormatNum":"6605910a-9766-462e-8b17-c5130a5606db","FirstModelVal":"5.0寸","SecondModelVal":"土豪金","ThirdModelVal":"128G","FourthModelVal":"","FifthModelVal":"","content":"妞呢据统计快乐旅途突突突唐路路通可口可乐了看看健健康康可口可乐了看看","browseNum":"0","Fabulous":"0","impression":"1","addtime":"2017/12/21 19:32:27","Picture":["/EvaluateOrder/201712/20171221073227287.png","/EvaluateOrder/201712/20171221073227396.png","/EvaluateOrder/201712/20171221073227412.png","/EvaluateOrder/201712/20171221073227381.png","/EvaluateOrder/201712/20171221073227052.png","/EvaluateOrder/201712/20171221073227381.png","/EvaluateOrder/201712/20171221073227287.png","/EvaluateOrder/201712/20171221073227365.png","/EvaluateOrder/201712/20171221073227365.png"]}
         */

        private String GoodsOrderEvaluateCount;
        private GoodsOrderEvaluateBean GoodsOrderEvaluate;

        public GoodsBean getGoods() {
            return Goods;
        }

        public void setGoods(GoodsBean Goods) {
            this.Goods = Goods;
        }

        public FirstGoodsGroupBean getFirstGoodsGroup() {
            return firstGoodsGroup;
        }

        public void setFirstGoodsGroup(FirstGoodsGroupBean firstGoodsGroup) {
            this.firstGoodsGroup = firstGoodsGroup;
        }

        public List<GoodsFormatSKUBean> getGoodsFormatSKU() {
            return GoodsFormatSKU;
        }

        public void setGoodsFormatSKU(List<GoodsFormatSKUBean> GoodsFormatSKU) {
            this.GoodsFormatSKU = GoodsFormatSKU;
        }

        public List<GoodsParameterBean> getGoodsParameter() {
            return GoodsParameter;
        }

        public void setGoodsParameter(List<GoodsParameterBean> GoodsParameter) {
            this.GoodsParameter = GoodsParameter;
        }

        public List<GoodsVideoBean> getGoodsVideo() {
            return GoodsVideo;
        }

        public void setGoodsVideo(List<GoodsVideoBean> GoodsVideo) {
            this.GoodsVideo = GoodsVideo;
        }

        public List<GoodsViewBean> getGoodsView() {
            return GoodsView;
        }

        public void setGoodsView(List<GoodsViewBean> GoodsView) {
            this.GoodsView = GoodsView;
        }

        public String getGoodsOrderEvaluateCount() {
            return GoodsOrderEvaluateCount;
        }

        public void setGoodsOrderEvaluateCount(String GoodsOrderEvaluateCount) {
            this.GoodsOrderEvaluateCount = GoodsOrderEvaluateCount;
        }

        public GoodsOrderEvaluateBean getGoodsOrderEvaluate() {
            return GoodsOrderEvaluate;
        }

        public void setGoodsOrderEvaluate(GoodsOrderEvaluateBean GoodsOrderEvaluate) {
            this.GoodsOrderEvaluate = GoodsOrderEvaluate;
        }

        public static class GoodsBean implements Parcelable {
            /**
             * GoodsNum : P0000000004
             * ModelAliasSKU : [{"Name":"尺寸","ModelAlias":["5.0寸","4.7寸","5.5寸","5.7寸"]},{"Name":"颜色","ModelAlias":["土豪金","白","黑","红"]},{"Name":"内存","ModelAlias":["128G","64G","32G","8G"]},{"Name":"","ModelAlias":[]},{"Name":"","ModelAlias":[]}]
             * Name : 小米6
             * picture :
             * showPrice : 2450.00
             * SMAccount : SP10000006
             * SMCompanyName : 百货公司
             * groups : 1
             * represent : 0
             * content : <p>124124</p>
             * SaleNumber : 0
             * ShowSale : 0
             */

            private String GoodsNum;
            private String Name;
            private String picture;
            private String showPrice;
            /**
             * Logo :
             * AllGoodsCount : 54
             * LatelyGoodsCount : 54
             * CollectionCount : 1
             * describe : 5
             * logistics : 5
             * service : 5
             */

            private String Logo;
            private int AllGoodsCount;
            private int LatelyGoodsCount;

            public String getComeFrom() {
                return ComeFrom;
            }

            public void setComeFrom(String comeFrom) {
                ComeFrom = comeFrom;
            }

            private String ComeFrom;
            private int CollectionCount;
            private float describe;
            private float logistics;
            private float service;

            public String getMinPrice() {
                return minPrice;
            }

            public void setMinPrice(String minPrice) {
                this.minPrice = minPrice;
            }

            private String minPrice;
            private String SMAccount;
            private String SMCompanyName;
            private String groups;
            private String represent;
            private String content;
            private String SaleNumber;
            private String ShowSale;
            private List<ModelAliasSKUBean> ModelAliasSKU;




            public String getGoodsNum() {
                return GoodsNum;
            }

            public void setGoodsNum(String GoodsNum) {
                this.GoodsNum = GoodsNum;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getShowPrice() {
                return showPrice;
            }

            public void setShowPrice(String showPrice) {
                this.showPrice = showPrice;
            }

            public String getSMAccount() {
                return SMAccount;
            }

            public void setSMAccount(String SMAccount) {
                this.SMAccount = SMAccount;
            }

            public String getSMCompanyName() {
                return SMCompanyName;
            }

            public void setSMCompanyName(String SMCompanyName) {
                this.SMCompanyName = SMCompanyName;
            }

            public String getGroups() {
                return groups;
            }

            public void setGroups(String groups) {
                this.groups = groups;
            }

            public String getRepresent() {
                return represent;
            }

            public void setRepresent(String represent) {
                this.represent = represent;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getSaleNumber() {
                return SaleNumber;
            }

            public void setSaleNumber(String SaleNumber) {
                this.SaleNumber = SaleNumber;
            }

            public String getShowSale() {
                return ShowSale;
            }

            public void setShowSale(String ShowSale) {
                this.ShowSale = ShowSale;
            }

            public List<ModelAliasSKUBean> getModelAliasSKU() {
                return ModelAliasSKU;
            }

            public void setModelAliasSKU(List<ModelAliasSKUBean> ModelAliasSKU) {
                this.ModelAliasSKU = ModelAliasSKU;
            }

            public String getLogo() {
                return Logo;
            }

            public void setLogo(String Logo) {
                this.Logo = Logo;
            }

            public int getAllGoodsCount() {
                return AllGoodsCount;
            }

            public void setAllGoodsCount(int AllGoodsCount) {
                this.AllGoodsCount = AllGoodsCount;
            }

            public int getLatelyGoodsCount() {
                return LatelyGoodsCount;
            }

            public void setLatelyGoodsCount(int LatelyGoodsCount) {
                this.LatelyGoodsCount = LatelyGoodsCount;
            }

            public int getCollectionCount() {
                return CollectionCount;
            }

            public void setCollectionCount(int CollectionCount) {
                this.CollectionCount = CollectionCount;
            }

            public float getDescribe() {
                return describe;
            }

            public void setDescribe(float describe) {
                this.describe = describe;
            }

            public float getLogistics() {
                return logistics;
            }

            public void setLogistics(float logistics) {
                this.logistics = logistics;
            }

            public float getService() {
                return service;
            }

            public void setService(float service) {
                this.service = service;
            }

            public static class ModelAliasSKUBean implements Parcelable {
                /**
                 * Name : 尺寸
                 * ModelAlias : ["5.0寸","4.7寸","5.5寸","5.7寸"]
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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.Name);
                    dest.writeStringList(this.ModelAlias);
                }

                public ModelAliasSKUBean() {
                }

                protected ModelAliasSKUBean(Parcel in) {
                    this.Name = in.readString();
                    this.ModelAlias = in.createStringArrayList();
                }

                public static final Creator<ModelAliasSKUBean> CREATOR = new Creator<ModelAliasSKUBean>() {
                    @Override
                    public ModelAliasSKUBean createFromParcel(Parcel source) {
                        return new ModelAliasSKUBean(source);
                    }

                    @Override
                    public ModelAliasSKUBean[] newArray(int size) {
                        return new ModelAliasSKUBean[size];
                    }
                };
            }

            public GoodsBean() {
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.GoodsNum);
                dest.writeString(this.Name);
                dest.writeString(this.picture);
                dest.writeString(this.showPrice);
                dest.writeString(this.Logo);
                dest.writeInt(this.AllGoodsCount);
                dest.writeInt(this.LatelyGoodsCount);
                dest.writeString(this.ComeFrom);
                dest.writeInt(this.CollectionCount);
                dest.writeFloat(this.describe);
                dest.writeFloat(this.logistics);
                dest.writeFloat(this.service);
                dest.writeString(this.minPrice);
                dest.writeString(this.SMAccount);
                dest.writeString(this.SMCompanyName);
                dest.writeString(this.groups);
                dest.writeString(this.represent);
                dest.writeString(this.content);
                dest.writeString(this.SaleNumber);
                dest.writeString(this.ShowSale);
                dest.writeTypedList(this.ModelAliasSKU);
            }

            protected GoodsBean(Parcel in) {
                this.GoodsNum = in.readString();
                this.Name = in.readString();
                this.picture = in.readString();
                this.showPrice = in.readString();
                this.Logo = in.readString();
                this.AllGoodsCount = in.readInt();
                this.LatelyGoodsCount = in.readInt();
                this.ComeFrom = in.readString();
                this.CollectionCount = in.readInt();
                this.describe = in.readFloat();
                this.logistics = in.readFloat();
                this.service = in.readFloat();
                this.minPrice = in.readString();
                this.SMAccount = in.readString();
                this.SMCompanyName = in.readString();
                this.groups = in.readString();
                this.represent = in.readString();
                this.content = in.readString();
                this.SaleNumber = in.readString();
                this.ShowSale = in.readString();
                this.ModelAliasSKU = in.createTypedArrayList(ModelAliasSKUBean.CREATOR);
            }

            public static final Creator<GoodsBean> CREATOR = new Creator<GoodsBean>() {
                @Override
                public GoodsBean createFromParcel(Parcel source) {
                    return new GoodsBean(source);
                }

                @Override
                public GoodsBean[] newArray(int size) {
                    return new GoodsBean[size];
                }
            };
        }

        public static class FirstGoodsGroupBean implements Parcelable {
            /**
             * GroupNum : 0
             * GroupPrice : 0
             */

            private String GroupNum;
            private String GroupPrice;

            public String getGroupNum() {
                return GroupNum;
            }

            public void setGroupNum(String GroupNum) {
                this.GroupNum = GroupNum;
            }

            public String getGroupPrice() {
                return GroupPrice;
            }

            public void setGroupPrice(String GroupPrice) {
                this.GroupPrice = GroupPrice;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.GroupNum);
                dest.writeString(this.GroupPrice);
            }

            public FirstGoodsGroupBean() {
            }

            protected FirstGoodsGroupBean(Parcel in) {
                this.GroupNum = in.readString();
                this.GroupPrice = in.readString();
            }

            public static final Creator<FirstGoodsGroupBean> CREATOR = new Creator<FirstGoodsGroupBean>() {
                @Override
                public FirstGoodsGroupBean createFromParcel(Parcel source) {
                    return new FirstGoodsGroupBean(source);
                }

                @Override
                public FirstGoodsGroupBean[] newArray(int size) {
                    return new FirstGoodsGroupBean[size];
                }
            };
        }

        public static class GoodsFormatSKUBean {
            /**
             * key : {5.0寸},-,{土豪金},-,{128G}
             * Sku_Key : {"FormatNum":"6605910a-9766-462e-8b17-c5130a5606db","picture":"","Price":"4000.00","inventory":"30"}
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
                 * picture :
                 * Price : 4000.00
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

        public static class GoodsParameterBean implements Parcelable {
            /**
             * ParameterName : 颜色
             * ParameterVal : 白色

             */

            private String ParameterName;
            private String ParameterVal;

            public String getParameterName() {
                return ParameterName;
            }

            public void setParameterName(String ParameterName) {
                this.ParameterName = ParameterName;
            }

            public String getParameterVal() {
                return ParameterVal;
            }

            public void setParameterVal(String ParameterVal) {
                this.ParameterVal = ParameterVal;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.ParameterName);
                dest.writeString(this.ParameterVal);
            }

            public GoodsParameterBean() {
            }

            protected GoodsParameterBean(Parcel in) {
                this.ParameterName = in.readString();
                this.ParameterVal = in.readString();
            }

            public static final Creator<GoodsParameterBean> CREATOR = new Creator<GoodsParameterBean>() {
                @Override
                public GoodsParameterBean createFromParcel(Parcel source) {
                    return new GoodsParameterBean(source);
                }

                @Override
                public GoodsParameterBean[] newArray(int size) {
                    return new GoodsParameterBean[size];
                }
            };
        }

        public static class GoodsVideoBean implements Parcelable {
            /**
             * VideoPath : uploadmovie/201709/15051307319.mp4
             * VideoImgPath :
             */

            private String VideoPath;
            private String VideoImgPath;

            public String getVideoPath() {
                return VideoPath;
            }

            public void setVideoPath(String VideoPath) {
                this.VideoPath = VideoPath;
            }

            public String getVideoImgPath() {
                return VideoImgPath;
            }

            public void setVideoImgPath(String VideoImgPath) {
                this.VideoImgPath = VideoImgPath;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.VideoPath);
                dest.writeString(this.VideoImgPath);
            }

            public GoodsVideoBean() {
            }

            protected GoodsVideoBean(Parcel in) {
                this.VideoPath = in.readString();
                this.VideoImgPath = in.readString();
            }

            public static final Creator<GoodsVideoBean> CREATOR = new Creator<GoodsVideoBean>() {
                @Override
                public GoodsVideoBean createFromParcel(Parcel source) {
                    return new GoodsVideoBean(source);
                }

                @Override
                public GoodsVideoBean[] newArray(int size) {
                    return new GoodsVideoBean[size];
                }
            };
        }

        public static class GoodsViewBean implements Parcelable {
            /**
             * ViewPath : pro/20170920170915051017146.jpg
             */

            private String ViewPath;

            public String getViewPath() {
                return ViewPath;
            }

            public void setViewPath(String ViewPath) {
                this.ViewPath = ViewPath;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.ViewPath);
            }

            public GoodsViewBean() {
            }

            protected GoodsViewBean(Parcel in) {
                this.ViewPath = in.readString();
            }

            public static final Creator<GoodsViewBean> CREATOR = new Creator<GoodsViewBean>() {
                @Override
                public GoodsViewBean createFromParcel(Parcel source) {
                    return new GoodsViewBean(source);
                }

                @Override
                public GoodsViewBean[] newArray(int size) {
                    return new GoodsViewBean[size];
                }
            };
        }

        public static class GoodsOrderEvaluateBean implements Parcelable {
            /**
             * account : M10008
             * Nickname : 你左爸爸啊
             * HeadPortrait : /Member/201712/20171219063734794.jpg
             * anonymous : 1
             * FormatNum : 6605910a-9766-462e-8b17-c5130a5606db
             * FirstModelVal : 5.0寸
             * SecondModelVal : 土豪金
             * ThirdModelVal : 128G
             * FourthModelVal :
             * FifthModelVal :
             * content : 妞呢据统计快乐旅途突突突唐路路通可口可乐了看看健健康康可口可乐了看看
             * browseNum : 0
             * Fabulous : 0
             * impression : 1
             * addtime : 2017/12/21 19:32:27
             * Picture : ["/EvaluateOrder/201712/20171221073227287.png","/EvaluateOrder/201712/20171221073227396.png","/EvaluateOrder/201712/20171221073227412.png","/EvaluateOrder/201712/20171221073227381.png","/EvaluateOrder/201712/20171221073227052.png","/EvaluateOrder/201712/20171221073227381.png","/EvaluateOrder/201712/20171221073227287.png","/EvaluateOrder/201712/20171221073227365.png","/EvaluateOrder/201712/20171221073227365.png"]
             */

            private String account;
            private String Nickname;
            private String HeadPortrait;
            private int anonymous;
            private String FormatNum;
            private String FirstModelVal;
            private String SecondModelVal;
            private String ThirdModelVal;
            private String FourthModelVal;
            private String FifthModelVal;
            private String content;
            private String browseNum;
            private String Fabulous;
            private String impression;
            private String addtime;
            private java.util.List<String> Picture;

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getNickname() {
                return Nickname;
            }

            public void setNickname(String Nickname) {
                this.Nickname = Nickname;
            }

            public String getHeadPortrait() {
                return HeadPortrait;
            }

            public void setHeadPortrait(String HeadPortrait) {
                this.HeadPortrait = HeadPortrait;
            }

            public int getAnonymous() {
                return anonymous;
            }

            public void setAnonymous(int anonymous) {
                this.anonymous = anonymous;
            }

            public String getFormatNum() {
                return FormatNum;
            }

            public void setFormatNum(String FormatNum) {
                this.FormatNum = FormatNum;
            }

            public String getFirstModelVal() {
                return FirstModelVal;
            }

            public void setFirstModelVal(String FirstModelVal) {
                this.FirstModelVal = FirstModelVal;
            }

            public String getSecondModelVal() {
                return SecondModelVal;
            }

            public void setSecondModelVal(String SecondModelVal) {
                this.SecondModelVal = SecondModelVal;
            }

            public String getThirdModelVal() {
                return ThirdModelVal;
            }

            public void setThirdModelVal(String ThirdModelVal) {
                this.ThirdModelVal = ThirdModelVal;
            }

            public String getFourthModelVal() {
                return FourthModelVal;
            }

            public void setFourthModelVal(String FourthModelVal) {
                this.FourthModelVal = FourthModelVal;
            }

            public String getFifthModelVal() {
                return FifthModelVal;
            }

            public void setFifthModelVal(String FifthModelVal) {
                this.FifthModelVal = FifthModelVal;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getBrowseNum() {
                return browseNum;
            }

            public void setBrowseNum(String browseNum) {
                this.browseNum = browseNum;
            }

            public String getFabulous() {
                return Fabulous;
            }

            public void setFabulous(String Fabulous) {
                this.Fabulous = Fabulous;
            }

            public String getImpression() {
                return impression;
            }

            public void setImpression(String impression) {
                this.impression = impression;
            }

            public String getAddtime() {
                return addtime;
            }

            public void setAddtime(String addtime) {
                this.addtime = addtime;
            }

            public List<String> getPicture() {
                return Picture;
            }

            public void setPicture(List<String> Picture) {
                this.Picture = Picture;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.account);
                dest.writeString(this.Nickname);
                dest.writeString(this.HeadPortrait);
                dest.writeInt(this.anonymous);
                dest.writeString(this.FormatNum);
                dest.writeString(this.FirstModelVal);
                dest.writeString(this.SecondModelVal);
                dest.writeString(this.ThirdModelVal);
                dest.writeString(this.FourthModelVal);
                dest.writeString(this.FifthModelVal);
                dest.writeString(this.content);
                dest.writeString(this.browseNum);
                dest.writeString(this.Fabulous);
                dest.writeString(this.impression);
                dest.writeString(this.addtime);
                dest.writeStringList(this.Picture);
            }

            public GoodsOrderEvaluateBean() {
            }

            protected GoodsOrderEvaluateBean(Parcel in) {
                this.account = in.readString();
                this.Nickname = in.readString();
                this.HeadPortrait = in.readString();
                this.anonymous = in.readInt();
                this.FormatNum = in.readString();
                this.FirstModelVal = in.readString();
                this.SecondModelVal = in.readString();
                this.ThirdModelVal = in.readString();
                this.FourthModelVal = in.readString();
                this.FifthModelVal = in.readString();
                this.content = in.readString();
                this.browseNum = in.readString();
                this.Fabulous = in.readString();
                this.impression = in.readString();
                this.addtime = in.readString();
                this.Picture = in.createStringArrayList();
            }

            public static final Creator<GoodsOrderEvaluateBean> CREATOR = new Creator<GoodsOrderEvaluateBean>() {
                @Override
                public GoodsOrderEvaluateBean createFromParcel(Parcel source) {
                    return new GoodsOrderEvaluateBean(source);
                }

                @Override
                public GoodsOrderEvaluateBean[] newArray(int size) {
                    return new GoodsOrderEvaluateBean[size];
                }
            };
        }
    }
}
