package com.mdd.slide.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.mdd.slide.R;

public class TestActivity extends AppCompatActivity {
    private RadioGroup grpGender;
    private EditText edtHeight, edtWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        this.grpGender = (RadioGroup) findViewById(R.id.grpGender);
        this.edtHeight = (EditText) findViewById(R.id.edtHeight);
        this.edtWeight = (EditText) findViewById(R.id.edtWeight);
    }

    public void test(View v){

        RadioButton rdoGender = (RadioButton) findViewById(this.grpGender.getCheckedRadioButtonId());
        //获取性别
        String gender = rdoGender.getText().toString();
        //获取身高
        int height = Integer.parseInt(edtHeight.getText().toString());
        //获取体重
        int weight = Integer.parseInt(edtWeight.getText().toString());
        //跳转到结果界面
        Intent intent = new Intent(TestActivity.this, ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("gender", gender);
        bundle.putInt("height", height);
        bundle.putInt("weight", weight);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void exit(View v){
        System.exit(0);
    }
}

