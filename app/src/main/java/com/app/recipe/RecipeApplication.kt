package com.app.recipe

import android.app.Application
import android.graphics.Bitmap
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.assist.ImageScaleType
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RecipeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initImageLoader()

    }

    private fun initImageLoader() {
        val options = DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.image_placeholder)
                .showImageOnFail(R.drawable.image_placeholder)
                .resetViewBeforeLoading(true)
                .cacheInMemory(true)
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                .displayer(FadeInBitmapDisplayer(850))
                .bitmapConfig(Bitmap.Config.RGB_565).build()
        val config = ImageLoaderConfiguration.Builder(
                applicationContext).defaultDisplayImageOptions(options)
                .build()
        ImageLoader.getInstance().init(config)
    }
}