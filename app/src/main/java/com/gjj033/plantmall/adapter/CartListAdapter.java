package com.gjj033.plantmall.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gjj033.plantmall.R;
import com.gjj033.plantmall.entity.CartInfo;

import java.util.ArrayList;
import java.util.List;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.MyHolder>{

    private List<CartInfo> mCartInfoList = new ArrayList<>();

    public void setCarInfoList(List<CartInfo> list){
        this.mCartInfoList = list;
//        刷新适配器
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_item, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        /*绑定数据*/
        CartInfo cartInfo = mCartInfoList.get(position);
        holder.plantImg.setImageResource(cartInfo.getPlantImg());
        holder.plantName.setText(cartInfo.getPlantName());
        holder.plantPrice.setText(cartInfo.getPlantPrice()+"");
        holder.plantCount.setText(cartInfo.getPlantCount()+"");

        //设置点击事件
        holder.btn_plus.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null){
                    mOnItemClickListener.onPlusOnClick(cartInfo,position);
                }
            }
        });
        holder.btn_subtract.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null){
                    mOnItemClickListener.onSubtractOnClick(cartInfo,position);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                if (mOnItemClickListener != null){
                    mOnItemClickListener.delOnClick(cartInfo,position);
                }

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCartInfoList.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        ImageView plantImg;
        TextView plantName,plantPrice,plantCount,btn_plus,btn_subtract;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            plantImg = itemView.findViewById(R.id.plant_img);
            plantName = itemView.findViewById(R.id.plant_name);
            plantPrice = itemView.findViewById(R.id.plant_price);
            plantCount = itemView.findViewById(R.id.plant_count);
            btn_plus = itemView.findViewById(R.id.btn_plus);
            btn_subtract = itemView.findViewById(R.id.btn_subtract);
        }
    }

    private onItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(onItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface onItemClickListener{
        void onPlusOnClick(CartInfo cartInfo, int position);
        void onSubtractOnClick(CartInfo cartInfo, int position);
        void delOnClick(CartInfo cartInfo, int position);
    }

}
