package parzival.com.androidkotlin.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import parzival.com.androidkotlin.fragments.FirstFragment
import parzival.com.androidkotlin.fragments.SecondFragment

class MyPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "First Tab"
            else -> "Second Tab"
        }
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            }
            else -> {
                return SecondFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }
}