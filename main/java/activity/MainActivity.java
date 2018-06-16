package com.mdd.slide.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.mdd.slide.R;
import com.mdd.slide.adapter.AppsViewPagerAdapter;

public class MainActivity extends FragmentActivity {
	private ViewPager appsViewPager;
	private List<Fragment> lstFragments;  // 用于存放Fragment窗体的集合
	private List<String> lstTitles;  // 用于存放选项标题的集合
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);

		this.appsViewPager = (ViewPager) findViewById(R.id.AppsViewPager);
	}

	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		super.onPostResume();
		// 步骤1：创建Fragment窗体对象
		Pager01Fragment pager01 = new Pager01Fragment();
		Pager02Fragment pager02 = new Pager02Fragment();
		Pager03Fragment pager03 = new Pager03Fragment();		
		
		// 步骤2：将窗体对象添加到集合lstFragments
		this.lstFragments = new ArrayList<Fragment>();
		this.lstFragments.add(pager01);
		this.lstFragments.add(pager02);
		this.lstFragments.add(pager03);
		
		// 步骤3：实例化lstTitles集合
		this.lstTitles = new ArrayList<String>();
		this.lstTitles.add("跑步");
		this.lstTitles.add("瑜伽");
		this.lstTitles.add("行走");
		
		// 步骤4：创建适配器将Fragment窗体集合和选项标题集合绑定装载（自定义）
		AppsViewPagerAdapter adapter = new AppsViewPagerAdapter(getSupportFragmentManager(), lstFragments, lstTitles);
		
		// 步骤5：viewPager对象绑定适配器
		this.appsViewPager.setAdapter(adapter);
	}
	
	

	
}
