package com.enciyo.movieapp.presentation.trending

import android.util.Log
import com.enciyo.movieapp.R
import com.enciyo.movieapp.common.base.BaseAdapter
import com.enciyo.movieapp.data.model.TrendingEntitiy
import com.enciyo.movieapp.databinding.ItemTrendingBinding


class TrendingAdapter : BaseAdapter<TrendingEntitiy, ItemTrendingBinding>(
    R.layout.item_trending,
    { t1, t2 -> t1.mId==t2.mId },
    { t1, t2 -> t1==t2 }
) {

    var listener: ((TrendingEntitiy) -> Unit)? = null


    override fun onViewHolder(mView: ItemTrendingBinding, item: TrendingEntitiy?) {
        mView.model = item
        mView.executePendingBindings()
        mView.root.setOnClickListener {
            item?.let {
                listener?.invoke(it)
            }
        }
    }

}