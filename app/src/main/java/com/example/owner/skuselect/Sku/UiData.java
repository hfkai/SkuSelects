package com.example.owner.skuselect.Sku;

import com.example.owner.skuselect.adapter.SkuAdapter;
import com.example.owner.skuselect.view.BabyPopWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * sku数据管理类
 * 用于存放几个adapter
 *  @author hfk
 */
public class UiData {

    public BabyPopWindow getmBottomSheetDialog() {
        return mBottomSheetDialog;
    }

    public void setmBottomSheetDialog(BabyPopWindow mBottomSheetDialog) {
        this.mBottomSheetDialog = mBottomSheetDialog;
    }

    BabyPopWindow mBottomSheetDialog;

    // 保存多组adapter
    List<SkuAdapter> adapters = new ArrayList<>();

    public BaseSkuModel getBaseSkuModel() {
        return baseSkuModel;
    }

    public void setBaseSkuModel(BaseSkuModel baseSkuModel) {
        this.baseSkuModel = baseSkuModel;
    }

    private BaseSkuModel baseSkuModel;

    public BaseSkuModel getCurrentskumodel() {
        return currentskumodel;
    }

    public void setCurrentskumodel(BaseSkuModel currentskumodel) {
        this.currentskumodel = currentskumodel;
    }

    private BaseSkuModel currentskumodel;//当前选中的模型（PS：不用再去重新寻找）
    //存放被选中的按钮对应的数据
    List<ProductModel.AttributesEntity.AttributeMembersEntity> selectedEntities = new ArrayList<>();

    //存放计算结果
    Map<String, BaseSkuModel> result;

    public boolean isHide() {
        return isHide;
    }

    public void setHide(boolean hide) {
        isHide = hide;
    }

    private boolean isHide;


    public List<String> getProjecttype() {
        return projecttype;
    }

    public void setProjecttype(ArrayList<String> projecttype) {
        this.projecttype = projecttype;
    }

    private List<String> projecttype = new ArrayList<>();
    public List<SkuAdapter> getAdapters() {
        return adapters;
    }

    public void setAdapters(List<SkuAdapter> adapters) {
        this.adapters = adapters;
    }

    public Map<String, BaseSkuModel> getResult() {
        return result;
    }

    public void setResult(Map<String, BaseSkuModel> result) {
        this.result = result;
    }


    public List<ProductModel.AttributesEntity.AttributeMembersEntity> getSelectedEntities() {
        return selectedEntities;
    }

    public void setSelectedEntities(List<ProductModel.AttributesEntity.AttributeMembersEntity> selectedEntities) {
        this.selectedEntities = selectedEntities;
    }
}
