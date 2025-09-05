package com.example.listview_z_obrazkiem

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class adapter(
    val ctx:Context,
    val dataList: List<myDataList>
):BaseAdapter() {
    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(position: Int): myDataList {
        return dataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?,
                         parent: ViewGroup?): View {
        var currentView = convertView
        if (currentView == null){
            currentView = LayoutInflater.from(ctx).
                    inflate(R.layout.my_listview,
                        parent,false)
        }
        val currentItem = getItem(position)
        val imgItem:ImageView? = currentView?.findViewById(R.id.img)
        val titleItem:TextView? = currentView?.findViewById(R.id.title)
        val descItem:TextView? = currentView?.findViewById(R.id.descrip)

        imgItem?.setImageResource(currentItem.img)
        titleItem?.text = currentItem.title
        descItem?.text = currentItem.desc

        return currentView!!
    }

}