package com.example.leidong.fresher.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.leidong.fresher.R;
import com.example.leidong.fresher.dbbean.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/10/1.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    private Context context;
    private List<Product> productList;

    public ProductsAdapter(Context context, List<Product> mProductList) {
        this.context = context;
        this.productList = mProductList;
    }

    @NonNull
    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.product_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.ViewHolder viewHolder, int i) {
        if (productList.size() > 0) {
            Glide.with(context).load(productList.get(i).getImagePath()).into(viewHolder.productImage);
            viewHolder.productName.setText(productList.get(i).getName());
            viewHolder.productPrice.setText("￥ " + productList.get(i).getPrice());

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
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "点击了条目" + (i + 1), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(productList.size() > 0) {
            return productList.size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.product_layout)
        LinearLayout linearLayout;

        @BindView(R.id.product_image)
        ImageView productImage;

        @BindView(R.id.product_name)
        TextView productName;

        @BindView(R.id.product_price)
        TextView productPrice;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
