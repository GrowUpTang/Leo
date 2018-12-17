package com.growuptang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.growuptang.view.CircleView;
import com.growuptang.view.RingView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirstActivity extends AppCompatActivity {

    @BindView(R.id.circle_view)
    public CircleView mCircleView;
    @BindView(R.id.message)
    public RingView mRingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ButterKnife.bind(this);

        mCircleView.setPercentage(50);//20
        mCircleView.chartRender();
        mCircleView.invalidate();

        // 添加的是颜色
        List<Integer> colorList = new ArrayList<>();
        colorList.add(R.color.colorAccent);
        colorList.add(R.color.black);
        colorList.add(R.color.green);
        colorList.add(R.color.colorPrimary);

        //  添加的是百分比
        List<Float> rateList = new ArrayList<>();
        rateList.add(10f);
        rateList.add(5f);
        rateList.add(45f);
        rateList.add(40f);
        mRingView.setShow(colorList, rateList,false,true);
    }
}
