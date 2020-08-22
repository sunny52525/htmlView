package com.shaun.htmlViewSample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.shaun.htmlviewsunny.htmlview
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        html_text_view.quoteSpanBackGroundColor = ContextCompat.getColor(this, R.color.Black)
        html_text_view.quoteSpanGap = 30F
        html_text_view.setTextColor(ContextCompat.getColor(this, R.color.white))
        html_text_view.setBackgroundColor(resources.getColor(R.color.Black))
        html_text_view.quoteSpanStripColor = resources.getColor(R.color.blue)
//      html_text_view.setImageDimensions(400,300)  //Default is (sreenwidth-100 , height according to aspect ratio) set according to Screen Width
//      html_text_view.setBounds(0,0)     //Default is 10,20
        html_text_view.setText(htmlString().html)


        html_text_view.setOnViewTouchedListener(object : htmlview.OnViewTouchedListener {
            override fun imageClicked(url: String?) {
                Log.d("TAG", "imageClicked: $url")
            }

        })

    }
}