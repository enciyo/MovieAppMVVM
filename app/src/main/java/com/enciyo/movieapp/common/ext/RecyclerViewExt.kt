package com.enciyo.movieapp.common.ext

import androidx.recyclerview.widget.*


fun <T> RecyclerView.setupVertical(listAdapter: ListAdapter<T,*>){
    this.layoutManager = LinearLayoutManager(this.context.applicationContext,RecyclerView.VERTICAL,false)
    this.adapter = listAdapter
}


fun <T> RecyclerView.setupGrid(listAdapter: ListAdapter<T,*>){
    this.layoutManager = GridLayoutManager(context,
        3)
    this.adapter = listAdapter
}