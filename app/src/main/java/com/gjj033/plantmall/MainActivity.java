package com.gjj033.plantmall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.gjj033.plantmall.fragment.CartFragment;
import com.gjj033.plantmall.fragment.HomeFragment;
import com.gjj033.plantmall.fragment.MineFragment;
import com.gjj033.plantmall.fragment.OrderFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFragment;
    private CartFragment cartFragment;
    private OrderFragment orderFragment;
    private MineFragment mineFragment;

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*初始化控件*/
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        /*设置底部导航栏点击事件*/
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.home){//跳转到对应界面
                    selectedFragment(0);
                } else if (item.getItemId()==R.id.cart){
                    selectedFragment(1);
                } else if (item.getItemId()==R.id.order){
                    selectedFragment(2);
                } else{
                    selectedFragment(3);
                }
                return true;
            }
        });
        /*默认首页选中*/
        selectedFragment(0);
    }

    //显示选中的Fragment
    private void selectedFragment(int position){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);
        if (position==0){
            if (homeFragment==null){
                homeFragment = new HomeFragment();
                fragmentTransaction.add(R.id.content,homeFragment);
            } else {
                fragmentTransaction.show(homeFragment);
            }
        }else if (position==1){
            if (cartFragment==null){
                cartFragment = new CartFragment();
                fragmentTransaction.add(R.id.content,cartFragment);
            } else {
                fragmentTransaction.show(cartFragment);
                cartFragment.loadData();
            }
        } else if (position==2){
            if (orderFragment==null){
                orderFragment = new OrderFragment();
                fragmentTransaction.add(R.id.content,orderFragment);
            } else {
                fragmentTransaction.show(orderFragment);
                orderFragment.loadData();
            }
        } else {
            if (mineFragment==null){
                mineFragment = new MineFragment();
                fragmentTransaction.add(R.id.content,mineFragment);
            } else {
                fragmentTransaction.show(mineFragment);
            }
        }
        fragmentTransaction.commit();//提交事务
    }

    //隐藏已有Fragment
    private void hideFragment(FragmentTransaction fragmentTransaction){
        if (homeFragment!=null){
            fragmentTransaction.hide(homeFragment);
        }
        if (cartFragment!=null){
            fragmentTransaction.hide(cartFragment);
        }
        if (orderFragment!=null){
            fragmentTransaction.hide(orderFragment);
        }
        if (mineFragment!=null){
            fragmentTransaction.hide(mineFragment);
        }
    }
}