package com.example.date7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val productArray = arrayOf(
        ProductModel("김치찌개",7000),
        ProductModel("삼겹살",13000),
        ProductModel("계란찜",3000)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,productArray)
        productOption.adapter = adapter
        productOption.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
               with(productArray[position]){
                   priceText.text="${name}의 가격은 ${price}입니다."
               }
            }

        }
    }
}
