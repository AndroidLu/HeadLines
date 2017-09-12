package com.chen.headlines;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chen.headline.HeadLine;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<View> mViews =new ArrayList<>();
    private HeadLine mHeadLines;
    private View one;
    private View two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHeadLines= (HeadLine) findViewById(R.id.my_head_line);
        inithead();
    }

    private void inithead() {
        one=View.inflate(MainActivity.this,R.layout.item_one,null);
        two=View.inflate(MainActivity.this,R.layout.item_two,null);
        mViews.add(one);
        mViews.add(two);
        mHeadLines.setViews(mViews);
        mHeadLines.setItemClick(new HeadLine.ItemClick() {
            @Override
            public void onItemClick(int position, View view) {
                Log.e("CCC","chen"+position);
                Toast.makeText(MainActivity.this,"cc"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
