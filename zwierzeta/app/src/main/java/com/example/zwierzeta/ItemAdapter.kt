package com.example.zwierzeta

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ItemAdapter (
    private val context: Context,
    private val images: List<Int>,
    private val titles: List<String>,
    private val descriptions: List<String>,
): BaseAdapter(){
    override fun getCount(): Int {
        return images.size
    }

    override fun getItem(p0: Int): Any? {
        return images[p0]
    }

    override fun getItemId(p0: Int): Long {
       return p0.toLong()
    }

    override fun getView(
        p0: Int,
        p1: View?,
        p2: ViewGroup?
    ): View? {
        val itemLayer = View.inflate(context,R.layout.item_list,null)
        val imageView: ImageView = itemLayer.findViewById(R.id.imageView)
        val title: TextView = itemLayer.findViewById(R.id.textView)
        val description: TextView = itemLayer.findViewById(R.id.textView2)

        imageView.setImageResource(images[p0])
        title.text = titles[p0]
        description.text = descriptions[p0]

        return itemLayer
    }

}