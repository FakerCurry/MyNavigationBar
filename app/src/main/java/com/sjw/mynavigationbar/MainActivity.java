package com.sjw.mynavigationbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DefaultNavigationbar navigationbar =
                new DefaultNavigationbar.Builder(this, (ViewGroup) findViewById(R.id.view_group))
                        .setTitle("我的标题")
                        .setLeftIcon(R.mipmap.back)
//                        .setLeftText("返回")
                        .setLeftOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "点击返回", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setRightText("发布")
//                        .setRightIcon(R.mipmap.ic_launcher)
                        .setRightOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "点击右边", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .builder();
    }
}
