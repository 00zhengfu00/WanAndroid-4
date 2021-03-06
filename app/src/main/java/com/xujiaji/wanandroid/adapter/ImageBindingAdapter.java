/*
 *    Copyright 2018 XuJiaji
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.xujiaji.wanandroid.adapter;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.xujiaji.wanandroid.config.PicConfig;

import jp.wasabeef.blurry.Blurry;

/**
 * author: xujiaji
 * created on: 2018/6/13 16:21
 * description:
 */
public class ImageBindingAdapter {

    @BindingAdapter("itemUrl")
    public static void setImage(ImageView imageView, String url) {
        if (TextUtils.isEmpty(url)) {
            imageView.setVisibility(View.GONE);
            return;
        } else {
            imageView.setVisibility(View.VISIBLE);
        }

        Glide.with(imageView)
                .applyDefaultRequestOptions(PicConfig.itemOptions)
                .load(url)
                .into(imageView);
    }

    @BindingAdapter("itemUrlNoOptions")
    public static void setImage2(ImageView imageView, String url) {
        if (TextUtils.isEmpty(url)) {
            imageView.setVisibility(View.INVISIBLE);
            return;
        } else {
            imageView.setVisibility(View.VISIBLE);
        }

        Glide.with(imageView)
                .load(url)
                .into(imageView);
    }

    @BindingAdapter("itemHeadUrl")
    public static void setImage3(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .applyDefaultRequestOptions(PicConfig.headOptions)
                .load(url)
                .into(imageView);

    }

    @BindingAdapter("blurImage")
    public static void setBlurImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .applyDefaultRequestOptions(PicConfig.itemOptions)
                .asBitmap()
                .load(url)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        Blurry.with(imageView.getContext()).from(resource).into(imageView);
                    }
                });

    }
}

