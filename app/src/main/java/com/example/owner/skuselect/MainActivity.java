package com.example.owner.skuselect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.owner.skuselect.Sku.BaseSkuModel;
import com.example.owner.skuselect.Sku.GoodsDetailsModel;
import com.example.owner.skuselect.Sku.ItemClickListener;
import com.example.owner.skuselect.Sku.ProductModel;
import com.example.owner.skuselect.Sku.SkuUtil;
import com.example.owner.skuselect.Sku.UiData;
import com.example.owner.skuselect.adapter.SkuAdapter;
import com.example.owner.skuselect.view.BabyPopWindow;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
,BabyPopWindow.OnItemClickListener{

    private Button showsku_btn;
    private TextView result_tv;
    UiData mUiData;
    private ProductModel product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        String skudata = getFromAssets();
        Gson gson = new Gson();
        Type type = new TypeToken<GoodsDetailsModel>() {
        }.getType();
        GoodsDetailsModel mAddressEntity = gson.fromJson(skudata, type);
        initData(mAddressEntity);
    }
    public String getFromAssets() {
        String json = "";
        try {
            InputStreamReader inputReader = new InputStreamReader(getResources().getAssets().open("sku.json"));
            BufferedReader bufReader = new BufferedReader(inputReader);
            StringBuffer buffer = new StringBuffer("");
            String line = "";

            while ((line = bufReader.readLine()) != null)
                buffer.append(line);
            json = buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 处理数据
     * @param skuModels
     */
    private void initData(GoodsDetailsModel skuModels) {
        mUiData = new UiData();
        product = new ProductModel();
        BaseSkuModel baseSkuModel = new BaseSkuModel();
        GoodsDetailsModel.RowsBean.GoodsBean goodsBean = skuModels.getRows().getGoods();
        baseSkuModel.setPrice(Double.parseDouble(goodsBean.getShowPrice()));
        baseSkuModel.setPicture(goodsBean.getPicture());
        baseSkuModel.setStock(30);
        mUiData.setBaseSkuModel(baseSkuModel);
        for (int i = 0; i < skuModels.getRows().getGoods().getModelAliasSKU().size(); i++) {
            if (checkIsEmpty(skuModels, i)){
                break;
            }
            skuModels.getRows().getGoods().getModelAliasSKU().get(i).setModelAlias(
                    SkuUtil.ifRepeat(skuModels.getRows()
                            .getGoods().
                                    getModelAliasSKU().get(i).getModelAlias()));
            ProductModel.AttributesEntity group01 = new ProductModel.AttributesEntity();
            group01.setName(skuModels.getRows().getGoods().getName());

            for (int j = 0; j < skuModels.getRows().getGoods().getModelAliasSKU().get(i).getModelAlias().size(); j++) {
                group01.getAttributeMembers().add(j, new ProductModel.AttributesEntity.AttributeMembersEntity(i, (j+1+i*10),
                        skuModels.getRows().getGoods().getModelAliasSKU().get(i).getModelAlias().get(j)));
            }
            product.getAttributes().add(i, group01);//第一组
            String projectname = skuModels.getRows().getGoods().getModelAliasSKU().get(i).getName();
            mUiData.getProjecttype().add(i,projectname);
        }
        for (int i = 0; i < skuModels.getRows().getGoodsFormatSKU().size(); i++) {
//            product.getProductStocks().put("1;4", new BaseSkuModel(13, 20));
            List<String> testdata = new ArrayList<>();
            String[] bianli = SkuUtil.convertStrToArray(skuModels.getRows().getGoodsFormatSKU().get(i).getKey());
            for (int j = 0; j < bianli.length; j++) {
                if (!(bianli[j].length() == 0|| TextUtils.equals("-",bianli[j]))){
                    testdata.add(bianli[j]);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int z = 0; z < testdata.size(); z++) {
                for (int d = 0; d < skuModels.getRows().getGoods().getModelAliasSKU().get(z).getModelAlias().size(); d++) {
                    if (TextUtils.equals(testdata.get(z),"{"+skuModels.getRows().getGoods().getModelAliasSKU().get(z).getModelAlias().get(d)+"}")){
                        stringBuilder.append((d+1+z*10)+";");
                    }
                }
            }
            if (stringBuilder.length() != 0) {
                String key = stringBuilder.substring(0, stringBuilder.length() - 1);
                product.getProductStocks().put(key, new BaseSkuModel(skuModels.getRows()
                        .getGoodsFormatSKU().get(i).getSku_Key()));
            }
        }
        Log.e("---testda",product.toString());
    }
    private void initView() {
        showsku_btn = findViewById(R.id.showsku_btn);
        result_tv = findViewById(R.id.result_tv);
        showsku_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showsku_btn:
                  ShowPop(v);
                break;
            default:
               break;
        }
    }
    private void ShowPop(View v) {
        if (mUiData.getmBottomSheetDialog() == null){
            mUiData.getSelectedEntities().clear();
            mUiData.getAdapters().clear();
            //添加list组
            for (int i = 0; i < product.getAttributes().size(); i++) {
                SkuAdapter skuAdapter = new SkuAdapter(product.getAttributes().get(i).getAttributeMembers());
                mUiData.getAdapters().add(skuAdapter);
            }
            // SKU 计算
            mUiData.setResult(SkuUtil.skuCollection(product.getProductStocks()));
            for (String key : mUiData.getResult().keySet()) {
                Log.e("SKU Result", "key = " + key + " value = " + mUiData.getResult().get(key));
            }
            //设置点击监听器
            for (SkuAdapter adapter : mUiData.getAdapters()) {
                ItemClickListener listener = new ItemClickListener(mUiData, adapter);
                adapter.setOnClickListener(listener);
            }
            // 初始化按钮
            initDataTwo();
            BabyPopWindow mPgs = new BabyPopWindow(MainActivity.this,mUiData);
            mUiData.setmBottomSheetDialog(mPgs);
        }
        SkuUtil.setBabyShowData(mUiData);
        mUiData.getmBottomSheetDialog().showAsDropDown(v);
        mUiData.getmBottomSheetDialog().setOnItemClickListener(this);
    }
    /**
     * 初始化按钮的状态（没有该规格或者库存为0的设置为不可点击）
     */
    private void initDataTwo() {
        for (int i = 0; i < mUiData.getAdapters().size(); i++) {
            for (ProductModel.AttributesEntity.AttributeMembersEntity entity : mUiData.getAdapters().get(i).getAttributeMembersEntities()) {
                if (mUiData.getResult().get(entity.getAttributeMemberId() + "") == null
                        || mUiData.getResult().get(entity.getAttributeMemberId() + "").getStock() <= 0) {
                    entity.setStatus(2);
                }
            }
        }
    }
    /**
     * 检查这个数据是否大小为0或者是否为null
     * @param skuModels
     * @param i
     * @return
     */
    private boolean checkIsEmpty(GoodsDetailsModel skuModels, int i) {
        return TextUtils.isEmpty(skuModels.getRows().getGoods().getModelAliasSKU().get(i).getName())
                && (skuModels.getRows().getGoods().getModelAliasSKU().get(i).getModelAlias() == null
                || skuModels.getRows().getGoods().getModelAliasSKU().get(i).getModelAlias().size() == 0);
    }

    @Override
    public void onClickOKPop(String BuyNum) {
        result_tv.setText("选择的商品为："+
                mUiData.getCurrentskumodel().toString()+"\n"
        +"数量为:"+BuyNum);
    }

    @Override
    public void cancel() {

    }
}
