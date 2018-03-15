package com.example.owner.skuselect.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.owner.skuselect.R;
import com.example.owner.skuselect.Sku.LogUtil;
import com.example.owner.skuselect.Sku.UiData;
import com.zhy.view.flowlayout.TagFlowLayout;

/**
 * 规格选择adapter（最下面是购物数量）
 * @author hfk
 * created at 2017/8/9 0009 14:37
 */
public class CountChooseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int STATE_HIDE = 1;
    public static final int STATE_Max = 2;//大于当前库存最大数字
    public static final int STATE_Min = 3;//小于当前库存最小数

    public static final int VIEW_TYPE_FOOTER = -1;
    private int mState;
    private Context context;
    private UiData mUiData;

    public boolean isHide() {
        return isHide;
    }

    public void setHide(boolean hide) {
        isHide = hide;
    }

    boolean isHide;//true 则是修改规格 false 显示购买数量
    public StandardFootView getStandardFootView() {
        return standardFootView;
    }

    StandardFootView standardFootView;

    public int getNumber() {
        return number;
    }

    int number;
    public CountChooseAdapter(Context context) {
        this.context = context;
        mState = STATE_HIDE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if (viewType == VIEW_TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.standard_top_item, parent, false);
            viewHolder = new StandardFootView(view);
            standardFootView = (StandardFootView) viewHolder;
        } else {
            View view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.item_standard,parent, false);
            viewHolder = new SkuViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == VIEW_TYPE_FOOTER) {
            ((StandardFootView)holder).initView();
        } else  {
            if (mUiData!=null){
                Log.e("--->>>position",position+"<");
                ((SkuViewHolder)holder).initView(mUiData.getAdapters().get(position)
                        ,mUiData.getProjecttype().get(position));
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (!isHide) {
            if (position + 1 == getItemCount()) {
                return VIEW_TYPE_FOOTER;
            }
        }
        return super.getItemViewType(position);
    }

    public void setState(int state) {
        this.mState = state;
        updateItem(getItemCount() - 1);
    }

    public void updateItem(int position) {
        if (getItemCount() > position) {
            notifyItemChanged(position);
        }
    }
    public void add(UiData mList) {
        mUiData = mList;
    }

    public boolean checkStock() {
        LogUtil.e(LogUtil.getTag(),number+"<<<");
        return mUiData == null ||
                mUiData.getCurrentskumodel() == null
                ?false:(mUiData.getCurrentskumodel().getStock()<=number);
    }
    @Override
    public int getItemCount() {
        return mUiData == null?0:(isHide?mUiData.getAdapters().size():mUiData.getAdapters().size()+1);
    }

    public class SkuViewHolder extends RecyclerView.ViewHolder {

        public View rootView;
        private TagFlowLayout tagFlowLayout;
        private TextView standard_tv;
        public SkuViewHolder(View itemView) {
            super(itemView);
            this.rootView = itemView;
            tagFlowLayout = (TagFlowLayout) itemView.findViewById(R.id.standard_fl);
            standard_tv = (TextView) itemView.findViewById(R.id.standard_tv);

        }
        private void initView(SkuAdapter skuAdapter, String title) {
            if (skuAdapter!=null) {
                tagFlowLayout.setOnTagClickListener(skuAdapter.getOnClickListener());
                tagFlowLayout.setAdapter(skuAdapter);
            }
            standard_tv.setText(title);
        }
    }
    public class StandardFootView extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView pop_add, pop_reduce;
        public TextView pop_num;
        public StandardFootView(View view){
            super(view);
            pop_add = (ImageView) view.findViewById(R.id.pop_add);
            pop_reduce = (ImageView)view.findViewById(R.id.pop_reduce);
            pop_num = (TextView)view.findViewById(R.id.pop_num);
            pop_num.setText("1");
            number = 1;
            pop_reduce.setImageResource(R.drawable.subunselect_number);
            pop_reduce.setEnabled(false);
            pop_reduce.setOnClickListener(this);
            pop_add.setOnClickListener(this);
            if (mUiData.getCurrentskumodel().getStock() == 0){
                pop_reduce.setImageResource(R.drawable.subunselect_number);
                pop_reduce.setEnabled(false);
                pop_num.setText("0");
                number = 0;
                pop_add.setImageResource(R.drawable.addunselect_number);
                pop_add.setEnabled(false);
            }
            Log.e("--->>>","jinlai");
        }
        private void initView() {
            number = Integer.parseInt(pop_num.getText().toString());
            if (mState == STATE_Max){
                if (checkStock()) {
                    number = Integer.parseInt(mUiData.getBaseSkuModel().getStock() + "");
                    pop_num.setText(number+"");
                    pop_add.setImageResource(R.drawable.addunselect_number);
                    pop_add.setEnabled(false);
                    pop_reduce.setImageResource(R.drawable.sub_number);
                    pop_reduce.setEnabled(true);
                }
                LogUtil.e(LogUtil.getTag(), ">>>>111>>>"+pop_num.getText()
                        .toString());
                if (mUiData.getCurrentskumodel().getStock()!=0&& number == 0) {
                    number = 1;
                    pop_num.setText("1");
                    pop_reduce.setImageResource(R.drawable.subunselect_number);
                    pop_reduce.setEnabled(false);
                    pop_add.setImageResource(R.drawable.add_number);
                    pop_add.setEnabled(true);
                }
            }
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.pop_add:
                    addNum();
                    break;
                case R.id.pop_reduce:
                    subNum();
                    break;
            }
        }

        /**
         * 增加数量
         */
        private void addNum() {
            String strNum = pop_num.getText().toString();
            int num = Integer.parseInt(strNum);
            if (mUiData.getCurrentskumodel().getStock() - num > 0) {
                int num_add = Integer.parseInt(strNum) + 1;
                pop_num.setText(String.valueOf(num_add));
                number = num_add;
            } else {
                pop_add.setImageResource(R.drawable.addunselect_number);
                pop_add.setEnabled(false);
            }
            pop_reduce.setImageResource(R.drawable.sub_number);
            pop_reduce.setEnabled(true);
        }

        /**
         * 减小数量
         */
        private void subNum() {
            String strNum = pop_num.getText().toString();
            if (Integer.parseInt(strNum) > 1) {
                int num_reduce = Integer.parseInt(strNum) - 1;
                pop_num.setText(String.valueOf(num_reduce));
                number = num_reduce;
            } else {
                pop_reduce.setImageResource(R.drawable.subunselect_number);
                pop_reduce.setEnabled(false);
            }
            pop_add.setImageResource(R.drawable.add_number);
            pop_add.setEnabled(true);
        }
    }
}
