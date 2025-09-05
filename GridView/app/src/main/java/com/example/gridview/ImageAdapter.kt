package com.example.gridview

import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView

class ImageAdapter(
    val grid: GridView,
    val obrazki: ArrayList<Int>):BaseAdapter() {
    override fun getCount(): Int {
        return obrazki.size
    }

    override fun getItem(p0: Int): Any {
       return obrazki[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val imageView = ImageView(grid.context)
        imageView.apply {
            layoutParams = AbsListView.LayoutParams(500,500)
            scaleType = ImageView.ScaleType.CENTER_INSIDE
            setPadding(10,10,10,10)
            setImageResource(obrazki[p0])
        }
        return imageView
    }
}