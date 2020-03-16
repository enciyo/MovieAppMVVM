package com.enciyo.movieapp.presentation.moviedetail

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter


interface MovieDetailBindingComponent {
    @BindingAdapter("deneme")
    fun AppCompatTextView.ssss(string: String)

}