package com.gjj033.plantmall.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gjj033.plantmall.R;
import com.gjj033.plantmall.entity.OrderInfo;

import java.util.ArrayList;
import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyHolder>{
    private List<OrderInfo> mOrderInfoList = new ArrayList<>();

    public void setListData(List<OrderInfo> list){
        this.mOrderInfoList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_item,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        /*绑定数据*/
        OrderInfo orderInfo = mOrderInfoList.get(position);
        //设置数据
        holder.plantImg.setImageResource(orderInfo.getPlantImg());
        holder.plantName.setText(orderInfo.getPlantName());
        holder.plantPrice.setText(orderInfo.getPlantPrice()+"");
        holder.plantCount.setText("×"+orderInfo.getPlantCount());

        //长按删除
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (null!= mOnItemClickListener){
                    mOnItemClickListener.onItemClick(orderInfo,position);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mOrderInfoList.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        ImageView plantImg;
        TextView plantName,plantPrice,plantCount;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            plantImg = itemView.findViewById(R.id.plant_img);
            plantName = itemView.findViewById(R.id.plant_name);
            plantPrice = itemView.findViewById(R.id.plant_price);
            plantCount = itemView.findViewById(R.id.plant_count);

        }
    }

    private onItemClickListener mOnItemClickListener;

    public void setmOnItemClickListener(onItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface onItemClickListener{
        void onItemClick(OrderInfo orderInfo,int position);
    }
}
