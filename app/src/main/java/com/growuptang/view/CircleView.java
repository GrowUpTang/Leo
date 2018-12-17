package com.growuptang.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;

import org.xclcharts.chart.CircleChart;
import org.xclcharts.chart.PieData;
import org.xclcharts.renderer.XEnum;
import org.xclcharts.view.GraphicalView;

import java.util.LinkedList;

/**
 * Company:GrowUpTang
 *
 * @author GrowUpTang
 *
 * @Description:    自定义圆
 *
 * @date 2018年12月17日16:26:01
 */
public class CircleView extends GraphicalView {

    private String TAG = "CircleChart02View";
    private CircleChart chart = new CircleChart();

    //设置图表数据源
    private LinkedList<PieData> mlPieData = new LinkedList<PieData>();
    private String mDataInfo = "";

    public CircleView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        setPercentage(0);
        chartRender();
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPercentage(0);
        chartRender();
    }

    public CircleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setPercentage(0);
        chartRender();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //图所占范围大小
        chart.setChartRange(w, h);
    }


    public void chartRender() {
        try {
            //设置信息
            chart.setAttributeInfo(mDataInfo);
            chart.getDataInfoPaint().setTextSize(30f);
            //数据源
            chart.setDataSource(mlPieData);

            chart.getLabelPaint().setColor(Color.rgb(72, 201, 176));//百分比颜色

            chart.setIRadius(0.8f);//轨迹内圆半径
//            chart.hideInnerFill();//是否满圆

            //半圆方式显示，不用则是圆方式显示
            chart.setCircleType(XEnum.CircleType.HALF);

            chart.getFillCirclePaint().setColor(Color.BLUE);//内圆色

            //背景色
            chart.getBgCirclePaint().setColor(Color.YELLOW);
            //深色
//            chart.getFillCirclePaint().setColor(Color.YELLOW);
            chart.setInitialAngle(90);
            //信息颜色
            chart.getDataInfoPaint().setColor(Color.RED);
            //显示边框
            chart.showRoundBorder();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.e(TAG, e.toString());
        }
    }

    //百分比
    public void setPercentage(int per) {
        //PieData(标签，百分比，在饼图中对应的颜色)
        mlPieData.clear();
        int color = Color.rgb(72, 201, 176);
        if (per < 40) {
            mDataInfo = "容易容易";
        } else if (per < 60) {
            mDataInfo = "严肃认真";
            color = Color.rgb(246, 202, 13);
        } else {
            mDataInfo = "压力山大";
            color = Color.rgb(243, 75, 125);
        }
        mlPieData.add(new PieData(Integer.toString(per) + "%", per, color));

    }

    @Override
    public void render(Canvas canvas) {
        try {
            chart.render(canvas);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
}