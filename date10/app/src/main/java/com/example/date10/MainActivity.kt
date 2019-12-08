package com.example.date10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList= listOf(
            SampleModel(R.drawable.image_1, "은재1"),
            SampleModel(R.drawable.image_2, "은재2"),
            SampleModel(R.drawable.image_3, "은재3"),
            SampleModel(R.drawable.image_4, "은재4"),
            SampleModel(R.drawable.image_5, "은재5"),
            SampleModel(R.drawable.image_6, "은재6")
        )

        val adapter = SampleDataAdapter(imageList, R.layout.item_box_3)

        sampleListview.adapter = adapter
        //sampleListview.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        //sampleListview.layoutManager = GridLayoutManager(this,2)
        sampleListview.layoutManager = StaggeredGridLayoutManager(2,RecyclerView.VERTICAL)
    }
}
