package com.mdd.slide.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mdd.slide.R;

public class ResultActivity extends AppCompatActivity {
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        this.txtResult = (TextView) findViewById(R.id.txtResult);

        //接收数据
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String gender = bundle.getString("gender");
        int height = bundle.getInt("height");
        int weight = bundle.getInt("weight");
        //计算标准体重
        int standardWeight = 0;
        if("我是男生".equals(gender)){
            standardWeight = (int)((height - 80) * 0.7);
        }else {
            standardWeight = (int)((height - 70) * 0.6);
        }

        String result = "";
        if (weight < standardWeight) {
            result = "您的标准体重为：" + standardWeight + "公斤" + "，您偏瘦" +(standardWeight - weight) + "公斤"
                    + "\n\r请注意加强营养，多吃多喝!!!!";
        } else if (weight == standardWeight) {
            result = "您的标准体重为：" + standardWeight + "公斤" + "\n\r您的体重非常标准，继续保持下去吧!!!!";
        } else {
            result = "您的标准体重为：" + standardWeight + "公斤" + "，您偏胖" + (weight - standardWeight) + "公斤"
                    + "\n\r请注意锻炼身体，减掉赘肉!!!!";
        }
        txtResult.setText(result);
    }

    public void food(View v) {
        Intent intent = new Intent(ResultActivity.this, FoodActivity.class);
        startActivityForResult(intent, 1);
    }

    public void fitness(View v) {
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivityForResult(intent, 1);
    }

    public void close(View v){
        finish();
    }
}
