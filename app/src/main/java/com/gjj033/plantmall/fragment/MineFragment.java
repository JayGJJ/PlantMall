package com.gjj033.plantmall.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gjj033.plantmall.LoginActivity;
import com.gjj033.plantmall.R;
import com.gjj033.plantmall.entity.UserInfo;

public class MineFragment extends Fragment {
    private View rootView;
    private TextView tv_username,tv_nickname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_mine, container, false);

        //初始化控件
        tv_username = rootView.findViewById(R.id.tv_username);
        tv_nickname = rootView.findViewById(R.id.tv_nickname);

        //退出登录
        rootView.findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(getContext())
                        .setTitle("温馨提示")
                        .setMessage("确定退出登录吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //退出登录的逻辑
                                getActivity().finish();
                                //打开登录页面
                                Intent intent = new Intent(getActivity(), LoginActivity.class);
                                startActivity(intent);
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

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //设置用户数据
        UserInfo userInfo = UserInfo.getsUserInfo();
        if(userInfo != null){
            tv_username.setText(userInfo.getUsername());
            tv_nickname.setText(userInfo.getNickname());
        }
    }
}