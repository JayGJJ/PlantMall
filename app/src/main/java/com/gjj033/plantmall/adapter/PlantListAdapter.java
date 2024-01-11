package com.gjj033.plantmall.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.gjj033.plantmall.PlantDetailsActivity;
import com.gjj033.plantmall.R;
import com.gjj033.plantmall.entity.Plant;

import java.util.List;

public class PlantListAdapter extends RecyclerView.Adapter<PlantListAdapter.MyHolder>{
    private List<Plant> dataList;
    private int currentPosition;
    public PlantListAdapter(List<Plant> dataList,int currentPosition){
        this.dataList = dataList;
        this.currentPosition = currentPosition;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_list_item,parent,false);//将布局文件转化为视图对象
        MyHolder holder = new MyHolder(view);//绑定视图控件并设置数据
        //为每个item设置点击事件
        holder.plantView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlantDetailsActivity.class);
                intent.putExtra("plantId",holder.getAdapterPosition());
                intent.putExtra("currentPosition",currentPosition);
                view.getContext().startActivity(intent);
            }
        });
        return holder;
    }
    //        Glide.with(this).load(R.drawable.anguloax).transform(new RoundedCorners(30)).into(imageView);
    //设置视图数据
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Plant plant = dataList.get(position);
        //holder.plantImg.setImageResource(plant.getPlantImg());
        Glide.with(holder.plantImg.getContext()).load(plant.getPlantImg()).override(200,150).transform(new RoundedCorners(20)).into(holder.plantImg);

        holder.plantName.setText(plant.getPlantName());
        holder.plantNotice.setText(plant.getPlantNotice());
        holder.plantPrice.setText("￥  "+String.valueOf(plant.getPlantPrice()));
    }

    //获取数据列表长度
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    //绑定视图控件
    static class MyHolder extends RecyclerView.ViewHolder{
        View plantView;
        ImageView plantImg;
        TextView plantName,plantNotice,plantPrice;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            plantView = itemView;
            plantImg = itemView.findViewById(R.id.plant_img);
            plantName = itemView.findViewById(R.id.plant_name);
            plantNotice = itemView.findViewById(R.id.plant_notice);
            plantPrice = itemView.findViewById(R.id.plant_price);
        }
    }
}
