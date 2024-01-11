package com.gjj033.plantmall.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.gjj033.plantmall.R;
import com.gjj033.plantmall.adapter.ViewPagerAdapter;
import com.gjj033.plantmall.entity.BannerData;
import com.gjj033.plantmall.fragment.homefragment_item.HomeFragment_1;
import com.gjj033.plantmall.fragment.homefragment_item.HomeFragment_2;
import com.gjj033.plantmall.fragment.homefragment_item.HomeFragment_3;
import com.gjj033.plantmall.fragment.homefragment_item.HomeFragment_4;
import com.gjj033.plantmall.fragment.homefragment_item.HomeFragment_5;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private TabLayout Top_tab;
    private ViewPager2 view_pager2;
    private List<String> titles;
    private List<Fragment> fragmentList;
    private View rootView;
    private ViewPagerAdapter adapter;
    private Banner banner;
    //准备轮播图数据
    private List<BannerData> bannerDataList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home,container,false);
        banner = rootView.findViewById(R.id.banner_home);
        return rootView;//将布局文件转换为视图对象返回
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化选项卡和ViewPager2
        Top_tab = getActivity().findViewById(R.id.top_tab);
        view_pager2 = getActivity().findViewById(R.id.viewpager2);
        //准备轮播图数据
        bannerDataList.add(new BannerData(R.drawable.brassocattleya,"brassocattleya"));
        bannerDataList.add(new BannerData(R.drawable.charlesworthii,"charlesworthii"));
        bannerDataList.add(new BannerData(R.drawable.caularthron,"caularthron"));
        bannerDataList.add(new BannerData(R.drawable.forgetmenot,"forgetmenot"));

        //设置adapter
        banner.setAdapter(new BannerImageAdapter<BannerData>(bannerDataList) {

                    @Override
                    public void onBindView(BannerImageHolder holder, BannerData data, int position, int size) {//设置图片和文字
                        holder.imageView.setImageResource(data.getBannerImg());
                    }
                }).addBannerLifecycleObserver(this)
                .setIndicator(new CircleIndicator(getActivity()));

        //设置画廊效果
        banner.setBannerGalleryEffect(18,10);
        initHome();
    }

    public void initHome(){
        titles = new ArrayList<>();//设置选项卡标题
        titles.add("高雅幽兰");
        titles.add("空气净化");
        titles.add("室内绿化");
        titles.add("视觉艺术");
        titles.add("国际名花");

        fragmentList = new ArrayList<>();//设置选项卡内容
        fragmentList.add(new HomeFragment_1());
        fragmentList.add(new HomeFragment_2());
        fragmentList.add(new HomeFragment_3());
        fragmentList.add(new HomeFragment_4());
        fragmentList.add(new HomeFragment_5());

        adapter = new ViewPagerAdapter(getActivity(),fragmentList);
        view_pager2.setAdapter(adapter);

        //将选项卡和ViewPager2进行绑定
        new TabLayoutMediator(Top_tab, view_pager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {//设置选项卡标题
                tab.setText(titles.get(position));
            }
        }).attach();
    }
}