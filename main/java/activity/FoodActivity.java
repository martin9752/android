package com.mdd.slide.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.mdd.slide.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodActivity extends AppCompatActivity {
    private ListView lvwFood;
    private List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
    SimpleAdapter adapter;
    private Dialog dlgExit, dlgDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        lvwFood = (ListView) findViewById(R.id.lvwFood);
        fillDataList();

        adapter = new SimpleAdapter(getApplicationContext(), dataList, R.layout.item_food,
                new String[]{"food", "title", "content"},
                new int[]{R.id.imgFood, R.id.txtTitle, R.id.txtContent});
        lvwFood.setAdapter(adapter);
    }


    private void fillDataList(){
        Map<String, Object> item1 = new HashMap<String, Object>();
        item1.put("food", R.drawable.food1);
        item1.put("title", "土豆丝");
        item1.put("content", "真的是太好吃了");
        dataList.add(item1);

        Map<String, Object> item2 = new HashMap<String, Object>();
        item2.put("food", R.drawable.food2);
        item2.put("title", "大饼鸡蛋");
        item2.put("content", "令人怀念的味道");
        dataList.add(item2);

        Map<String, Object> item3 = new HashMap<String, Object>();
        item3.put("food", R.drawable.food3);
        item3.put("title", "水饺");
        item3.put("content", "中国特色饺子");
        dataList.add(item3);

        Map<String, Object> item4 = new HashMap<String, Object>();
        item4.put("food", R.drawable.food4);
        item4.put("title", "鸡蛋汤");
        item4.put("content", "真是好喝啊");
        dataList.add(item4);

        Map<String, Object> item5 = new HashMap<String, Object>();
        item5.put("food", R.drawable.food5);
        item5.put("title", "糕点");
        item5.put("content", "甜点，酥内可口");
        dataList.add(item5);
    }
}
