package com.enciyo.movieapp.common

import android.graphics.drawable.TransitionDrawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.TransitionOptions
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory


@BindingAdapter("imageUrl")
fun AppCompatImageView.loadImage(url: String?) {
    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.start()
    Glide.with(this)
        .load("https://image.tmdb.org/t/p/original$url")
        .transition(DrawableTransitionOptions.withCrossFade())
        .fitCenter()
        .placeholder(circularProgressDrawable)
        .into(this)
}
