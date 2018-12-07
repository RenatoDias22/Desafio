package com.renatodias.desafio.Data.Util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageBindingAdapter {

    @BindingAdapter({"bind:avatarUrl"})
    public static void loadImage(ImageView imageView, String url) {
        if (!url.equals("")) {
            Picasso.with(imageView.getContext())
                    .load(url)
                    .into(imageView);
        }
    }
}
