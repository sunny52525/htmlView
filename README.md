
[![Build Status](https://img.shields.io/static/v1?label=Version&message=0.1&color=<>)](https://github.com/sunny52525/htmlView/releases/tag/0.1)


# Html/Rich text viewer for android
    Htmltext view is simple view which extends Textview to display Html/rich text .
    It uses picasso library to load images from internet
    
## Import in your project
    	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
			}
		}
	
	dependencies {
	        implementation 'com.github.sunny52525:htmlView:0.1'
		}
## Example
    XML
    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">
            <com.shaun.htmlviewsunny.htmlview
            android:id="@+id/html_text_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent">
            </com.shaun.htmlviewsunny.htmlview>
    </ScrollView>
    
    
    -MainActivity

        Kotlin

     	  val html_text_view=findViewById(R.id.html_text_view)
          html_text_view.quoteSpanBackGroundColor = ContextCompat.getColor(this, R.color.Black)
          html_text_view.quoteSpanGap = 30F
       	  html_text_view.setTextColor(ContextCompat.getColor(this,R.color.white))
          html_text_view.setBackgroundColor(ContextCompat.getColor(this,R.color.Black))
          html_text_view.quoteSpanStripColor = ContextCompat.getColor(this,R.color.Blue)
          html_text_view.setText("<h1>Hello World</h1>")

        Java
            htmlview html_text_view=findViewById(R.id.html);
            html_text_view.setQuoteSpanBackGroundColor(ContextCompat.getColor(this,R.color.Black));
            html_text_view.setQuoteSpanStripColor(ContextCompat.getColor(this,R.color.blue));
            html_text_view.setQuoteSpanStripWidth(10F);
            html_text_view.setQuoteSpanGap(30F);
            html_text_view.setText("<h1>Hello World</h1>");


    -Image Click Listener

        Kotlin

     	    html_text_view.setOnViewTouchedListener(object : htmlview.OnViewTouchedListener {
            override fun imageClicked(url: String?) {
                Log.d("TAG", "imageClicked: $url")
                }
            })

         Java

            html_text_view.setOnViewTouchedListener(new htmlview.OnViewTouchedListener() {
                        @Override
                        public void imageClicked(String s) {
                            Log.d("TAG", "imageClicked: Url is " +s);
                        }
                    });


## Sample App
[Sample App](https://github.com/sunny52525/htmlView/tree/master/app)


## Contribution
    Want to contribute? Great!
    Contribution is welcomed,fork add features and make PR's.

### Authors
> - [Sunny](https://www.github.com/sunny52525)


## [![Twitter](https://img.shields.io/twitter/url/https/twitter.com/sunny52525.svg?style=social&label=Follow%20%40sunny52525)](https://twitter.com/sunny52525)
