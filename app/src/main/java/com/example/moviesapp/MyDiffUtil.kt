package com.example.moviesapp

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil(
    private val oldList: List<MoviesAdapter.MoviesDataClass>,
    private val newList: List<MoviesAdapter.MoviesDataClass>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]==newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]==newList[newItemPosition]
    }

}
