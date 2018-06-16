package com.mdd.slide.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdd.slide.R;

public class Pager03Fragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// 步骤1：利用该方法的第一个参数绑定该窗体的布局资源文件，同时返回一个View对象
		View view = inflater.inflate(R.layout.fragment_page03, null);
		return view;
	}

	
}
