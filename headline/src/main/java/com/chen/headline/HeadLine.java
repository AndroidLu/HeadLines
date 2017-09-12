package com.chen.headline;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import java.util.List;

/**
 * Created by cyz on 2017/9/12.
 * chenyz@yizhekeji.com
 */

public class HeadLine extends ViewFlipper {

    private int Intervals = 2000;

    public HeadLine(Context context) {
        super(context);
    }

    public HeadLine(Context context, AttributeSet attrs) {                               //ps:如果写在第一个构造函数里面没有动画
        super(context, attrs);
        setFlipInterval(Intervals);                                                      //设置切换间隔
        Animation animIn = AnimationUtils.loadAnimation(context, R.anim.bottom_in);      //获得animation
        setInAnimation(animIn);                                                          //设置控件进入屏幕时的动画
        Animation animOut = AnimationUtils.loadAnimation(context, R.anim.top_out);
        setOutAnimation(animOut);
    }

    public void setViews(@NonNull List<View> views) {
        if (views.isEmpty()) return;
        removeAllViews();                                                                //移除所有子视图
        for (int i = 0; i < views.size(); i++) {
            final int position = i;
            final View view = views.get(i);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClicks.onItemClick(position, view);
                }
            });
            if (null != views.get(i).getParent()) {
                ViewGroup parent = (ViewGroup) views.get(i).getParent();
                parent.removeAllViews();
            }
            addView(view);
        }
        startFlipping();
    }

    private ItemClick mItemClicks;
    public void setItemClick(ItemClick ItemClick) {
        this.mItemClicks = ItemClick;
    }
    public interface ItemClick {
        void onItemClick(int position, View view);
    }
}
