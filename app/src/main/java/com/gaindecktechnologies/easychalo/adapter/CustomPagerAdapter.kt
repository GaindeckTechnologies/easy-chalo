package com.gaindecktechnologies.easychalo.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gaindecktechnologies.easychalo.model.AppIntroModel

class CustomPagerAdapter(private val mContext: Context) : PagerAdapter() {


    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val modelObject = AppIntroModel.values()[position]
        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(modelObject.layoutResId, collection, false) as ViewGroup
        collection.addView(layout)
        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }


    override fun isViewFromObject(view: View, obj: Any): Boolean {

        return view === obj

    }

    override fun getCount(): Int {

        return AppIntroModel.values().size

    }

    override fun getPageTitle(position: Int): CharSequence {
        val customPagerEnum = AppIntroModel.values()[position]
        return mContext.getString(customPagerEnum.titleResId)
    }

}