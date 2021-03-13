package com.lubaspc.testopenweather.utils

import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

object FragmentUtils{

    fun addFragment(
        transaction: FragmentTransaction,
        fragment: Fragment,
        TAG_FRAGMENT: String,
        frameLayout: FrameLayout
    ) {
        transaction.add(
            frameLayout.id,
            fragment,
            TAG_FRAGMENT
        )
        transaction.addToBackStack(TAG_FRAGMENT)
        transaction.commit()
    }

    fun showFragment(
        transaction: FragmentTransaction,
        fragment: Fragment
    ) {
        transaction.show(fragment)
        transaction.commit()
    }

    fun replaceFragment(
        transaction: FragmentTransaction,
        fragment: Fragment,
        TAG_FRAGMENT: String?,
        frameLayout: FrameLayout
    ) {
        transaction.replace(
            frameLayout.id,
            fragment,
            TAG_FRAGMENT
        )
        transaction.addToBackStack(TAG_FRAGMENT)
        transaction.commit()
    }

    fun getByTag(
        fragmentManager: FragmentManager,
        TAG: String
    ): Fragment? {
        return fragmentManager.findFragmentByTag(TAG)
    }

    fun removeFragment(
        transaction: FragmentTransaction,
        fragment: Fragment
    ) {
        transaction.remove(fragment)
        transaction.commit()
    }

    fun hideFragment(
        transaction: FragmentTransaction,
        fragment: Fragment
    ) {
        transaction.hide(fragment)
        transaction.commit()
    }

    fun reloadFragment(
        transaction: FragmentTransaction,
        fragment: Fragment
    ) {
        transaction.detach(fragment)
        transaction.attach(fragment)
        transaction.commit()
    }


    fun popBackStackImmediate(fragmentManager: FragmentManager) {
        fragmentManager.popBackStackImmediate()
    }

    fun clearStackImmediate(fragmentManager: FragmentManager) {
        for (i in 0 until fragmentManager.backStackEntryCount) {
            fragmentManager.popBackStack()
        }
    }

    fun getBackEntryFragmentName(activity: AppCompatActivity): String? {
        val backStackCount = activity.supportFragmentManager.backStackEntryCount
        return activity.supportFragmentManager
            .getBackStackEntryAt(backStackCount - 1)
            .name
    }
}