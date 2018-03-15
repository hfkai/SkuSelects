package com.example.owner.skuselect.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.owner.skuselect.R;
import com.example.owner.skuselect.Sku.BaseSkuModel;
import com.example.owner.skuselect.Sku.FloatUtils;
import com.example.owner.skuselect.Sku.GlideUtils;
import com.example.owner.skuselect.Sku.UiData;
import com.example.owner.skuselect.Sku.onViewChange;
import com.example.owner.skuselect.adapter.CountChooseAdapter;


/**
 * 商品详情sku popwindow
 * @author hfk
 * created at 2017/9/22 0022 16:40
 */
public class BabyPopWindow implements OnDismissListener, OnClickListener,onViewChange {

    private StateButton pop_ok;
    private PopupWindow popupWindow;
    private OnItemClickListener listener;
    private Context context;
    private ImageView popDel;
    private RecyclerView recyclerView;
    CountChooseAdapter mAdapter;
    UiData mUiData;//select_iv select_price_tv Stock_tv choose_title
    private ImageViewPlus select_iv;
//    private RoundImageView select_iv2;

    private TextView select_price_tv;
    private TextView Stock_tv;
    private TextView choose_title;
    private LinearLayout sps;

    public BabyPopWindow(Context context, UiData mUIdata) {
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.shop_tab_dialog, null);
        mUiData = mUIdata;
        configView(view);
        configPopWindow(view);
    }
    private void darkenBackgroud(Float bgcolor) {
        WindowManager.LayoutParams lp = ((Activity)context).getWindow().getAttributes();
        lp.alpha = bgcolor;
        ((Activity)context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        ((Activity)context).getWindow().setAttributes(lp);
    }
    /**
     * 获取view实例及设置监听
     * @param view
     */
    public void configView(View view){
        pop_ok = (StateButton) view.findViewById(R.id.pop_ok);
        popDel = (ImageView) view.findViewById(R.id.close);
        select_iv = (ImageViewPlus) view.findViewById(R.id.select_iv);
        sps = (LinearLayout) view.findViewById(R.id.sps);
//        select_iv2 = (RoundImageView) view.findViewById(select_iv2);

        select_price_tv = (TextView) view.findViewById(R.id.select_price_tv);
        Stock_tv = (TextView) view.findViewById(R.id.Stock_tv);
        choose_title = (TextView) view.findViewById(R.id.choose_title);
        recyclerView = (RecyclerView) view.findViewById(R.id.sku_rv);
        pop_ok.setOnClickListener(this);
        popDel.setOnClickListener(this);
        sps.setOnClickListener(this);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        mAdapter = new CountChooseAdapter(context);
        mAdapter.setHide(mUiData.isHide());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(mAdapter);
        initData();
    }

    private void initData() {
        mAdapter.add(mUiData);
        mAdapter.notifyDataSetChanged();
    }


    /**
     * 启动popWindow
     * @param view
     */
    public void configPopWindow(View view){
        if (popupWindow == null)
         popupWindow = new PopupWindow(view, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        // 设置popwindow的动画效果
        popupWindow.setAnimationStyle(R.style.customAnimStyle);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setOnDismissListener(this);// 当popWindow消失时的监听
    }

    /**
     * 设置监听
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    // 当popWindow消失时响应
    @Override
    public void onDismiss() {
        darkenBackgroud(1f);
        if (listener != null)listener.cancel();
    }
    /**
     * 弹窗显示的位置
     */
    public void showAsDropDown(View parent) {
        popupWindow.showAtLocation(parent, Gravity.BOTTOM,0,0);
//        popupWindow.showAsDropDown(parent);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.update();
        darkenBackgroud(0.4f);
    }
    public boolean isShowing(){
        return popupWindow != null && popupWindow.isShowing();
    }
    /**
     * 退出弹窗
     */
    public void popdissmiss() {
        if (isShowing())
        popupWindow.dismiss();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pop_ok:
                if (mAdapter.isHide()){
                    if (isAllChoose && listener != null && mAdapter != null) {
                        popdissmiss();
                        listener.onClickOKPop("1");
                    }else{
                        Toast.makeText(context, "请选择商品属性！",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    if (isAllChoose && listener != null && mAdapter != null && mAdapter.getStandardFootView() != null) {
                        popdissmiss();
                        listener.onClickOKPop(mAdapter.getNumber() + "");//.getStandardFootView()).pop_num.getText().toString()
                    } else {
                        Toast.makeText(context, "请选择商品属性！",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.sps:
            case R.id.close:
                popdissmiss();
                break;
        }
    }
    boolean isAllChoose;
    /**
     * 展示库存和图片还有已选规格
     * @param baseSkuModel
     * @param sku
     */
    @Override
    public void showPriceAndSku(BaseSkuModel baseSkuModel, String sku) {
        //展示价格和sku
        GlideUtils.showasPhoto(context,baseSkuModel.getPicture(),select_iv);
//        GlideUtils.showasPhoto(context, GlideUtils.getUrl(baseSkuModel.getPicture()),select_iv2);
        select_price_tv.setText("¥"+ FloatUtils.decimalPlace(baseSkuModel.getPrice(),2));
        choose_title.setText(sku);
        Stock_tv.setText("库存"+baseSkuModel.getStock()+"件");
        mAdapter.setState(CountChooseAdapter.STATE_Max);
        isAllChoose = sku.contains("已选： ");
    }


    public interface OnItemClickListener {
        /**
         * 设置点击确认按钮时监听接口
         */
        void onClickOKPop(String BuyNum);

        void cancel();
    }
}