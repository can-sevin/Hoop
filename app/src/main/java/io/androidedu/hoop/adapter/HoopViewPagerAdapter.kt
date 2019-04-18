package io.androidedu.hoop.adapter

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter


class HoopViewPagerAdapter(val fragmentList : ArrayList<Fragment>,
                           val titleList: ArrayList<String>,
                           fm : FragmentManager) : FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
            return fragmentList[position]
    }
    override fun getCount(): Int = fragmentList.size //ister returnlu fonksiyon ister böyle!Kotlin spec.

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }

}