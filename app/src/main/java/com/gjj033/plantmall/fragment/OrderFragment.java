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
import android.widget.Toast;

import com.gjj033.plantmall.R;
import com.gjj033.plantmall.adapter.OrderListAdapter;
import com.gjj033.plantmall.db.OrderDbHelper;
import com.gjj033.plantmall.entity.OrderInfo;
import com.gjj033.plantmall.entity.UserInfo;

import java.util.List;

public class OrderFragment extends Fragment {
    private View rootView;
    private RecyclerView mRecyclerView;
    private OrderListAdapter mOrderListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_order, container, false);
        //初始化控件
        mRecyclerView = rootView.findViewById(R.id.recyclerView);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //初始化mOrderListAdapter
        mOrderListAdapter = new OrderListAdapter();

        //设置OrderListAdapter
        mRecyclerView.setAdapter(mOrderListAdapter);

        //设置点击事件
        mOrderListAdapter.setmOnItemClickListener(new OrderListAdapter.onItemClickListener() {
            @Override
            public void onItemClick(OrderInfo orderInfo, int position) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("提示")
                        .setMessage("是否删除该订单？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int row = OrderDbHelper.getInstance(getActivity()).delete(orderInfo.getOrder_id() + "");
                                if (row > 0) {
                                    loadData();
                                    Toast.makeText(getActivity(), "删除成功", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getActivity(), "删除失败", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();
            }
        });

        //获取数据
        loadData();
    }

    public void loadData() {
        //获取数据
        UserInfo userInfo = UserInfo.getsUserInfo();
        if (userInfo != null) {
            List<OrderInfo> orderInfos = OrderDbHelper.getInstance(getActivity()).queryOrderListData(userInfo.getUsername());
            mOrderListAdapter.setListData(orderInfos);
        }
    }
}