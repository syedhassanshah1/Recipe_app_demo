package com.app.recipe.utils

import android.os.Build
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.nostra13.universalimageloader.core.ImageLoader


@BindingAdapter("android:loadImg")
fun loadImage(imageView: ImageView, url: String?) {
    ImageLoader.getInstance().displayImage(url, imageView)
}

@BindingAdapter("android:htmlText")
fun setHTMLText(textView: TextView, message: String?) {
    message?.let {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.text = Html.fromHtml(message, Html.FROM_HTML_MODE_COMPACT);
        } else {
            textView.text = Html.fromHtml(message);
        }
    }

}

object BindingConverters {

    @BindingConversion
    @JvmStatic
    fun booleanToVisibility(isVisible: Boolean): Int {
        return if (isVisible) View.VISIBLE else View.GONE
    }
}

