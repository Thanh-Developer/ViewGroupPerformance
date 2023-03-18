package com.viewgroup.performance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = Adapter(initData())
        }
    }

    private fun initData(): List<String> {
        val random = Random()
        val list = mutableListOf<String>()
        for (i in 1..100) {
            list.add(random.nextLong().toString())
        }
        return list
    }
}