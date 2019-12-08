package com.example.date5

import android.graphics.Color
import android.graphics.Typeface.BOLD
import android.graphics.Typeface.ITALIC
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener{
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        var option = 0

        if(boldOption.isChecked) option += BOLD
        if(italicOption.isChecked) option+= ITALIC

        textViewt.setTypeface(null,option)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        boldOption.setOnCheckedChangeListener(this)
        italicOption.setOnCheckedChangeListener(this)
        
        colorOptionGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
               when(checkedId){
                   R.id.redOption -> textViewt.setTextColor(Color.RED)
                   R.id.blueOption -> textViewt.setTextColor(Color.BLUE)
                   R.id.blackOption -> textViewt.setTextColor(Color.BLACK)
               }
            }

        })
    }
}
