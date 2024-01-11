package com.gjj033.plantmall.fragment.homefragment_item;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gjj033.plantmall.R;
import com.gjj033.plantmall.adapter.PlantListAdapter;
import com.gjj033.plantmall.entity.Plant;
import com.gjj033.plantmall.plantdata.PlantsListData;

import java.util.List;

public class HomeFragment_5 extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;
    private PlantListAdapter plantListAdapter;
    private List<Plant> plantList;
    private ViewPager2 view_pager2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home_5, container, false);//将布局文件转换为视图返回
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = rootView.findViewById(R.id.recycler_view5);
        //初始化数据列表
        plantList = new PlantsListData(getContext()).getPlantsList(4);
        //设置瀑布流布局管理器
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        //传入当前fragment下标
        view_pager2 = getActivity().findViewById(R.id.viewpager2);
        //设置适配器
        plantListAdapter = new PlantListAdapter(plantList,view_pager2.getCurrentItem());
        recyclerView.setAdapter(plantListAdapter);
    }
}