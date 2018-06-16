package com.mdd.slide.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.mdd.slide.R;

import static android.app.Activity.RESULT_OK;

// 所有的Context上下环境使用getActivity()替代
public class Pager01Fragment extends Fragment {
	private Button btnTake,btnShare;
	private ImageView scenic;
	private int REQUEST_CODE_CAMERA = 1;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// 步骤1：利用该方法的第一个参数绑定该窗体的布局资源文件，同时返回一个View对象
		View view = inflater.inflate(R.layout.fragment_page01, null);
		// 实例化交互类视图组件
		this.btnTake = (Button) view.findViewById(R.id.btnTake);
		this.btnShare = (Button) view.findViewById(R.id.btnShare);
		this.scenic = (ImageView) view.findViewById(R.id.scenic);
		return view;
	}
	@Override
	public void onResume() {
		super.onResume();
		this.btnTake.setOnClickListener(new ViewOcl());
		this.btnShare.setOnClickListener(new ViewOcl());
	}
	private class ViewOcl implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnTake:
				//Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();
				Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent1, REQUEST_CODE_CAMERA);
				break;
			case R.id.btnShare:
				Toast.makeText(getActivity(), "分享成功", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		}
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == REQUEST_CODE_CAMERA && requestCode == RESULT_OK) {
			Bitmap bmp = (Bitmap) intent.getExtras().get("data");
			scenic.setImageBitmap(bmp);
		} else {
			Toast.makeText(getActivity(), "拍照成功", Toast.LENGTH_SHORT).show();
		}
	}
	
}
