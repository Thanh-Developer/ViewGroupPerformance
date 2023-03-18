package com.viewgroup.performance

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val list: List<String>) : RecyclerView.Adapter<Adapter.Holder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.test_case1_constraint, p0, false)
        return Holder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = list[position]
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view)
}