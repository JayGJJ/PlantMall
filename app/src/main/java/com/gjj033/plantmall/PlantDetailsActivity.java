package com.gjj033.plantmall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.gjj033.plantmall.db.CartDbHelper;
import com.gjj033.plantmall.entity.BannerData;
import com.gjj033.plantmall.entity.Plant;
import com.gjj033.plantmall.entity.UserInfo;
import com.gjj033.plantmall.plantdata.PlantsListData;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class PlantDetailsActivity extends AppCompatActivity {
    private Banner banner;
    private List<Plant> dataList;
    private TextView plantName,plantNotice,temperature,illumination,season,color;
    private ImageButton backButton;
    private Button addCart,addFavorite;
    //准备轮播图数据
    private List<BannerData> bannerDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_details);
        initView();

        //接收植物id
        int plantId = getIntent().getIntExtra("plantId",0);
        //接收当前fragment下标
        int currentPosition = getIntent().getIntExtra("currentPosition",0);
        dataList = new PlantsListData(this).getPlantsList(currentPosition);
        Plant plant = dataList.get(plantId);
        //设置植物信息
        plantName.setText(plant.getPlantName());
        plantNotice.setText(plant.getPlantNotice());
        temperature.setText(plant.getTemperature());
        illumination.setText(plant.getIllumination());
        season.setText(plant.getSeason());
        color.setText(plant.getColor());
        //设置返回按钮
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //准备轮播图数据
        bannerDataList.add(new BannerData(plant.getPlantImg(),plant.getPlantName()));
        Plant plant1 = dataList.get(plantId);
        bannerDataList.add(new BannerData(plant1.getPlantImg(),plant1.getPlantName()));
        Plant plant2 = dataList.get(plantId);
        bannerDataList.add(new BannerData(plant2.getPlantImg(),plant2.getPlantName()));
        Plant plant3 = dataList.get(plantId);
        bannerDataList.add(new BannerData(plant3.getPlantImg(),plant3.getPlantName()));

        //设置adapter
        banner.setAdapter(new BannerImageAdapter<BannerData>(bannerDataList) {

            @Override
            public void onBindView(BannerImageHolder holder, BannerData data, int position, int size) {//设置图片和文字
                holder.imageView.setImageResource(data.getBannerImg());
            }
        }).addBannerLifecycleObserver(this)
                .setIndicator(new CircleIndicator(this));

        //设置画廊效果
        banner.setBannerGalleryEffect(18,10);
        banner.setBannerRound(20);

        //设置点击事件
        banner.setOnBannerListener(new OnBannerListener<BannerData>() {

            @Override
            public void OnBannerClick(BannerData data, int position) {
                Toast.makeText(PlantDetailsActivity.this,"你点击了第"+(position+1)+"张图片",Toast.LENGTH_SHORT).show();
            };
        });

        //添加到购物车
        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfo userInfo = UserInfo.getsUserInfo();
                if (userInfo != null) {
                    //添加到购物车
                    int row = CartDbHelper.getInstance(PlantDetailsActivity.this).addCart(userInfo.getUsername(), plant.getPlantId(), plant.getPlantName(), plant.getPlantNotice(), plant.getPlantPrice(), plant.getPlantImg());
                    if (row > 0) {
                        Toast.makeText(PlantDetailsActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(PlantDetailsActivity.this, "添加失败", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //初始化控件
    private void initView(){
        banner = findViewById(R.id.banner_plantdetails);
        plantName = findViewById(R.id.plant_name);
        plantNotice = findViewById(R.id.plant_notice);
        temperature = findViewById(R.id.temperature);
        illumination = findViewById(R.id.illumination);
        season = findViewById(R.id.phase);
        color = findViewById(R.id.color);
        backButton = findViewById(R.id.back_button);
        addFavorite = findViewById(R.id.add_to_favorites_button);
        addCart = findViewById(R.id.add_to_cart_button);
    }
}