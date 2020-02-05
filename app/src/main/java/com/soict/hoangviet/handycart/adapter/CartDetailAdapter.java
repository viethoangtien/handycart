package com.soict.hoangviet.handycart.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.soict.hoangviet.handycart.R;
import com.soict.hoangviet.handycart.base.EndlessLoadingRecyclerViewAdapter;
import com.soict.hoangviet.handycart.databinding.ItemCartBinding;
import com.soict.hoangviet.handycart.entity.response.ProductListItem;
import com.soict.hoangviet.handycart.ui.cart.CartTransactionListener;

public class CartDetailAdapter extends EndlessLoadingRecyclerViewAdapter<ItemCartBinding> {
    private CartTransactionListener listener;

    public CartDetailAdapter(Context context, CartTransactionListener listener, boolean enableSelectedMode) {
        super(context, enableSelectedMode);
        this.listener = listener;
    }

    @Override
    protected RecyclerView.ViewHolder initNormalViewHolder(ItemCartBinding binding, ViewGroup parent) {
        return new CartViewHolder(binding);
    }

    @Override
    protected void bindNormalViewHolder(NormalViewHolder holder, int position) {
        holder.bind(getItem(position, ProductListItem.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_cart;
    }

    class CartViewHolder extends NormalViewHolder<ItemCartBinding, ProductListItem> {

        public CartViewHolder(ItemCartBinding binding) {
            super(binding);
        }

        @Override
        public void bind(ProductListItem data) {
            binding.setProductListItem(data);
            binding.qscCart.setListener(item -> {
                listener.onChangeQuantity(Integer.valueOf(binding.qscCart.getQuantity()), getAdapterPosition());
            });
            binding.tvDelete.setOnClickListener(view -> {
                listener.onDelete(getAdapterPosition());
            });
        }
    }
}
