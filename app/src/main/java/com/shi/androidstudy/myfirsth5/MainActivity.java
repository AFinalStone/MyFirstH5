package com.shi.androidstudy.myfirsth5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.FrameLayout;

import io.dcloud.EntryProxy;
import io.dcloud.WebviewModeListener;
import io.dcloud.feature.internal.sdk.SDK;


public class MainActivity extends AppCompatActivity {

    EntryProxy mEntryProxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        if(mEntryProxy == null){

            FrameLayout rootView = new FrameLayout(this);

            // 创建5+内核运行事件监听

            WebviewModeListener wm = new WebviewModeListener(this,rootView);

            // 初始化5+内核

            mEntryProxy = EntryProxy.init(this,wm);

            // 启动5+内核，并指定内核启动类型

            mEntryProxy.onCreate(savedInstanceState, SDK.IntegratedMode.WEBVIEW,null);

            setContentView(rootView);

        }

    }
}
