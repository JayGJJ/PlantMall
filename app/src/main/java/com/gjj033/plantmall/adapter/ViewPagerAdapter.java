package com.gjj033.plantmall.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private List<Fragment> fragmentList;
    /*先定义好Fragment列表变量，然后选择一个FragmentActivity类型参数的构造函数*/
    /*参数1为所要创建适配器的视图，参数2为传入的参数列表*/
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragmentList) {
        super(fragmentActivity);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        //将列表中的数据依次取出来
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        /*返回列表长度*/
        return fragmentList.size();
    }
}
