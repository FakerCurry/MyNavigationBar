package com.sjw.mynavigationbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by pc on 2018/7/1.
 */

public class DefaultNavigationbar extends AbsNavigationbar<DefaultNavigationbar.Builder.DefaultNavigationbarParams> {


    public DefaultNavigationbar(DefaultNavigationbar.Builder.DefaultNavigationbarParams params) {
        super(params);
    }

    @Override
    public int bindLayoutId() {
        return R.layout.titlebar;
    }

    @Override
    public void applyView() {
        //绑定效果
        setTitle(R.id.tv_actionbar_title, getmParams().mTitle);
        setTitle(R.id.tv_actionbar_left, getmParams().mLeftText);
        setTitle(R.id.tv_actionbar_right, getmParams().mRightText);
        setImageResouce(R.id.iv_actionbar_left, getmParams().mLeftIcon);
        setImageResouce(R.id.iv_actionbar_right, getmParams().mRightIcon);

        //这两个是点击文字
        setOnClickListener(R.id.tv_actionbar_right, getmParams().mRightListener);
        setOnClickListener(R.id.tv_actionbar_left, getmParams().mLeftListener);
        //这两个是点击图片
        setOnClickListener(R.id.iv_actionbar_right, getmParams().mRightListener);
        setOnClickListener(R.id.iv_actionbar_left, getmParams().mLeftListener);

    }


    public static class Builder extends AbsNavigationbar.Builder {
        DefaultNavigationbarParams p;

        public Builder(Context context, ViewGroup parent) {
            super(context, parent);
            p = new DefaultNavigationbarParams(context, parent);
        }

        @Override
        public DefaultNavigationbar builder() {
            DefaultNavigationbar navigationbar = new DefaultNavigationbar(p);
            return navigationbar;
        }


        //设置所有效果
//设置标题
        public DefaultNavigationbar.Builder setTitle(String title) {
            p.mTitle = title;
            return this;
        }

        //设置左边的文字
        public DefaultNavigationbar.Builder setLeftText(String leftText) {
            p.mLeftText = leftText;
            return this;
        }

        //设置左边的图片
        public DefaultNavigationbar.Builder setLeftIcon(int leftIcon) {
            p.mLeftIcon = leftIcon;
            return this;
        }

        //设置左边的点击
        public DefaultNavigationbar.Builder setLeftOnClickListener(View.OnClickListener leftListener) {
            p.mLeftListener = leftListener;
            return this;
        }

        //设置右边的文字
        public DefaultNavigationbar.Builder setRightText(String rightText) {
            p.mRightText = rightText;
            return this;
        }

        //设置右边的图片
        public DefaultNavigationbar.Builder setRightIcon(int rightIcon) {
            p.mRightIcon = rightIcon;
            return this;
        }

        //设置右边的点击
        public DefaultNavigationbar.Builder setRightOnClickListener(View.OnClickListener rightListener) {
            p.mRightListener = rightListener;
            return this;
        }


        public static class DefaultNavigationbarParams extends AbsNavigationbar.Builder.AbsNavigationParams {

            //所有效果
            public String mTitle;
            public String mLeftText;
            public String mRightText;
            public int mLeftIcon;
            public int mRightIcon;
            public View.OnClickListener mRightListener;
            public View.OnClickListener mLeftListener;


            public DefaultNavigationbarParams(Context context, ViewGroup parent) {
                super(context, parent);
            }
        }


    }
}
