package com.shaun.htmlviewsunny

import android.content.Context
import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.style.ImageSpan
import android.text.style.QuoteSpan
import android.text.style.URLSpan
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat

class HtmlView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0

) : androidx.appcompat.widget.AppCompatTextView(context!!, attrs, defStyleAttr) {
    var quoteSpanBackGroundColor =ContextCompat.getColor(context!!,R.color.white)
    var quoteSpanStripColor = ContextCompat.getColor(context!!,R.color.blue)
    var quoteSpanStripWidth = 10F
    var quoteSpanGap = 50F
    private var imageWidth=-1
    private var imageHeight=-1
    private var imageDrawableBoundLeft=-1
    private var imageDrawableBoundTop=-1



    fun setText(html: String) {
        val imageGetter = HtmlImageGetter(resources, this,imageWidth,imageHeight,imageDrawableBoundLeft,imageDrawableBoundTop)
        val styledText = HtmlCompat.fromHtml(html, paintFlags, imageGetter, null)
        ImageClick(styledText as Spannable)
        replaceQuoteSpans(styledText)
        this.movementMethod = LinkMovementMethod.getInstance()
        super.setText(styledText)
    }

    fun setImageDimensions(width:Int,Height:Int){
        imageHeight=Height
        imageWidth=width
    }
    fun setBounds(top:Int,left:Int){
        imageDrawableBoundLeft=left
        imageDrawableBoundTop=top
    }



    private fun ImageClick(html: Spannable) {
        for (span in html.getSpans(0, html.length, ImageSpan::class.java)) {
            val flags = html.getSpanFlags(span)
            val start = html.getSpanStart(span)
            val end = html.getSpanEnd(span)
            html.setSpan(object : URLSpan(span.source) {
                override fun onClick(v: View) {
                    onViewTouchedListener?.imageClicked(span.source)
//                    Log.d(TAG, "onClick: ${span.source}")
                }
            }, start, end, flags)
        }
    }


    private fun replaceQuoteSpans(spannable: Spannable) {
        val quoteSpans: Array<QuoteSpan> =
            spannable.getSpans(0, spannable.length - 1, QuoteSpan::class.java)
        for (quoteSpan in quoteSpans) {
            val start: Int = spannable.getSpanStart(quoteSpan)
            val end: Int = spannable.getSpanEnd(quoteSpan)
            val flags: Int = spannable.getSpanFlags(quoteSpan)
            spannable.removeSpan(quoteSpan)
            spannable.setSpan(
                CustomQuoteSpanClass(
                    quoteSpanBackGroundColor,
                    quoteSpanStripColor,
                    quoteSpanStripWidth,
                    quoteSpanGap
                ),
                start,
                end,
                flags
            )
        }
    }


    private var onViewTouchedListener: OnViewTouchedListener? = null

    interface OnViewTouchedListener {
        fun imageClicked(url: String?)
    }

    fun setOnViewTouchedListener(listener: OnViewTouchedListener?) {
        onViewTouchedListener = listener
    }


}