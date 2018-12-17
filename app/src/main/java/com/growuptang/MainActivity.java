package com.growuptang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author GrowUpTang
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_circle)
    public  Button mButton;
    @BindView(R.id.btn_circle_1)
    public  Button mButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.btn_circle, R.id.btn_circle_1})
    public void onViewClicked(View view) {
        Intent mIntent = new Intent();
        switch (view.getId()) {
            case R.id.btn_circle:
                mIntent.setClass(MainActivity.this, FirstActivity.class);
                MainActivity.this.startActivity(mIntent);
                break;
            case R.id.btn_circle_1:
                mIntent.setClass(MainActivity.this, SecondActivity.class);
                MainActivity.this.startActivity(mIntent);
                break;
            default:
                break;
        }
    }
}
