package com.gjj033.plantmall.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gjj033.plantmall.R;
import com.gjj033.plantmall.adapter.CartListAdapter;
import com.gjj033.plantmall.db.CartDbHelper;
import com.gjj033.plantmall.db.OrderDbHelper;
import com.gjj033.plantmall.entity.CartInfo;
import com.gjj033.plantmall.entity.UserInfo;

import java.util.List;

public class CartFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;
    private CartListAdapter mCarListAdapter;
    private TextView total;
    private Button btn_total;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_cart, container, false);

//        初始化控件
        recyclerView = rootView.findViewById(R.id.recyclerView);
        total = rootView.findViewById(R.id.total);
        btn_total = rootView.findViewById(R.id.btn_total);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        初始化mCarListAdapter
        mCarListAdapter = new CartListAdapter();
        //设置适配器
        recyclerView.setAdapter(mCarListAdapter);

        //recyclerView点击事件
        mCarListAdapter.setOnItemClickListener(new CartListAdapter.onItemClickListener() {
            @Override
            public void onPlusOnClick(CartInfo cartInfo, int position) {
                //加
                CartDbHelper.getInstance(getActivity()).updatePlant(cartInfo.getCartId(),cartInfo);
                //刷新数据
                loadData();
            }

            @Override
            public void onSubtractOnClick(CartInfo cartInfo, int position) {
                //减
                CartDbHelper.getInstance(getActivity()).subtractUpdatePlant(cartInfo.getCartId(),cartInfo);
                //刷新数据
                loadData();
            }

            @Override
            public void delOnClick(CartInfo cartInfo, int position) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("温馨提示")
                        .setMessage("确定要删除吗？")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                CartDbHelper.getInstance(getActivity()).delete(cartInfo.getCartId()+"");
                                //刷新数据
                                loadData();
                            }
                        })
                        .setNegativeButton("取消",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();
            }
        });

        //结算的点击事件
        btn_total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                批量将购物车里面的数据生成订单
                UserInfo userInfo = UserInfo.getsUserInfo();
                if (userInfo != null){
                    List<CartInfo> cartList = CartDbHelper.getInstance(getActivity()).queryCartList(userInfo.getUsername());
                    if(cartList.size()==0){
                        //给出提示
                        Toast.makeText(getActivity(),"您还没有选择商品!",Toast.LENGTH_SHORT).show();
                    }else {
                        //生成订单
                        OrderDbHelper.getInstance(getActivity()).insertByAll(cartList,"成都市双流区","123456789");

                        //清空购物车
                        for (int i = 0; i < cartList.size(); i++) {
                            CartDbHelper.getInstance(getActivity()).delete(cartList.get(i).getCartId()+"");
                        }
                        /*重新加载数据*/
                        loadData();
                    }
                }
            }
        });

        //加载数据
        loadData();
    }

    private void setTotalData(List<CartInfo> list){
        int totalCount = 0;
        for (int i = 0; i < list.size(); i++) {
            int price = list.get(i).getPlantPrice()*list.get(i).getPlantCount();
            totalCount += price;
        }

        //设置数据
        total.setText(totalCount+".00");
    }

    public void loadData(){
        UserInfo userInfo = UserInfo.getsUserInfo();
        if (userInfo != null){
            //获取数据
            List<CartInfo> cartList = CartDbHelper.getInstance(getActivity()).queryCartList(userInfo.getUsername());
            //设置数据
            mCarListAdapter.setCarInfoList(cartList);
            //设置总价
            setTotalData(cartList);
        }
    }
}