package com.example.leidong.fresher.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.leidong.fresher.R;
import com.example.leidong.fresher.bean.ShoppingCartItemBean;
import com.example.leidong.fresher.ui.ProductActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/11/10.
 */
public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder> {
    private Context mContext;

    private ArrayList<ShoppingCartItemBean> mShoppingCartItemList = new ArrayList<>();

    public ShoppingCartAdapter(Context mContext, ArrayList<ShoppingCartItemBean> mShoppingCartItemList) {
        this.mContext = mContext;
        this.mShoppingCartItemList = mShoppingCartItemList;
    }

    @NonNull
    @Override
    public ShoppingCartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.shoppingcart_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ShoppingCartAdapter.ViewHolder viewHolder, int i) {
        if (mShoppingCartItemList.size() > 0) {
            ShoppingCartItemBean shoppingCartItemBean = mShoppingCartItemList.get(i);
            Glide.with(mContext).load(shoppingCartItemBean.getImagePath()).into(viewHolder.shoppingcartItemIcon);
            viewHolder.shoppingcartItemName.setText(shoppingCartItemBean.getName());
            viewHolder.shoppingcartItemPrice.setText(shoppingCartItemBean.getPrice() + " 元");
            viewHolder.shoppingcartItemNumber.setText(shoppingCartItemBean.getNumber() + " 件");

            clickItem(viewHolder, i);
        }
    }

    /**
     * 点击条目
     *
     * @param viewHolder
     * @param i
     */
    private void clickItem(ViewHolder viewHolder, final int i) {
        viewHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProductActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("shoppingcartItem", mShoppingCartItemList.get(i));
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mShoppingCartItemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.container)
        ConstraintLayout constraintLayout;

        @BindView(R.id.icon)
        ImageView shoppingcartItemIcon;

        @BindView(R.id.name)
        TextView shoppingcartItemName;

        @BindView(R.id.price)
        TextView shoppingcartItemPrice;

        @BindView(R.id.number)
        TextView shoppingcartItemNumber;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
