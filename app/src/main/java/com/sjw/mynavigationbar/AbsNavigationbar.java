package com.sjw.mynavigationbar;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pc on 2018/7/1.
 */

public abstract class AbsNavigationbar<P extends AbsNavigationbar.Builder.AbsNavigationParams> implements INavigationbar {
    private P mParams;
    private View mNavigationView;


    public AbsNavigationbar(P params) {
        this.mParams = params;
        createAndBindView();
    }

    public P getmParams() {
        return mParams;
    }

    protected void setTitle(int viewId, String text) {

        TextView tv = findViewById(viewId);
        if (!TextUtils.isEmpty(text)) {
            tv.setVisibility(View.VISIBLE);
            tv.setText(text);

        }

    }

    protected void setImageResouce(int viewId, int imgResouce) {
        ImageView iv = findViewById(viewId);
        if (imgResouce != 0) {
            iv.setVisibility(View.VISIBLE);
            iv.setImageResource(imgResouce);
        }


    }


    protected void setOnClickListener(int viewId, View.OnClickListener listener) {
        findViewById(viewId).setOnClickListener(listener);
    }


    public <T extends View> T findViewById(int viewId) {

        return (T) mNavigationView.findViewById(viewId);
    }

    /**
     * 绑定和创建view
     */
    private void createAndBindView() {
        //1.创建view

        mNavigationView = LayoutInflater.from(mParams.mContext).inflate(bindLayoutId(), mParams.mParent, false);

        mParams.mParent.addView(mNavigationView, 0);

        applyView();
    }


    //Builder 仿造系统写的  套路 活 AbsNavigationbar  Builder  参数Params
    public abstract static class Builder {

        public Builder(Context context, ViewGroup parent) {

        }

        public abstract AbsNavigationbar builder();


        public static class AbsNavigationParams {
            public Context mContext;
            public ViewGroup mParent;

            public AbsNavigationParams(Context context, ViewGroup parent) {

                this.mContext = context;
                this.mParent = parent;


            }

        }


    }

}
