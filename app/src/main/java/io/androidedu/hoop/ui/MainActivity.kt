package io.androidedu.hoop.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.HoopViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_tab.*

class MainActivity : AppCompatActivity() {
    private val fragmentList = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()

    private val chatsFragment by lazy { ChatsFragment.newInstance() }
    private val statusFragment by lazy { StatusFragment.newInstance() }
    private val cameraFragment by lazy { CameraFragment.newInstance() }
    private val callsFragment by lazy { CallsFragment.newInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentList.add(cameraFragment)
        fragmentList.add(chatsFragment)
        fragmentList.add(statusFragment)
        fragmentList.add(callsFragment)

        fragmentTitleList.add("Camera")
        fragmentTitleList.add("Chats")
        fragmentTitleList.add("Status")
        fragmentTitleList.add("Calls")

        val adapter = HoopViewPagerAdapter(fragmentList,fragmentTitleList,supportFragmentManager)
        viewpager.adapter = adapter
        tableLayout.setupWithViewPager(viewpager)
    }

}