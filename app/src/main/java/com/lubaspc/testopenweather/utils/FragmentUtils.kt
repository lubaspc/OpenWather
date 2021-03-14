package com.lubaspc.testopenweather.utils

import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

    fun FrameLayout.addFragment(
        transaction: FragmentTransaction,
        fragment: Fragment,
        TAG_FRAGMENT: String,
    ) {
        transaction.add(
            this.id,
            fragment,
            TAG_FRAGMENT
        )
        transaction.addToBackStack(TAG_FRAGMENT)
        transaction.commit()
    }

fun FrameLayout.addFragment(
    transaction: FragmentTransaction,
    fragments: Array<Fragment>,
    TAGS_FRAGMENT: Array<String>,
) {
    for(i in fragments.indices){
        transaction.add(
            this.id,
            fragments[i],
            TAGS_FRAGMENT[i]
        )
        transaction.addToBackStack(TAGS_FRAGMENT[i])
    }
    transaction.commit()
}

    fun FrameLayout.replaceFragment(
        transaction: FragmentTransaction,
        fragment: Fragment,
        TAG_FRAGMENT: String?,
    ) {
        transaction.replace(
            this.id,
            fragment,
            TAG_FRAGMENT
        )
        transaction.addToBackStack(TAG_FRAGMENT)
        transaction.commit()
    }

object FragmentUtils {

    fun showFragment(
        transaction: FragmentTransaction,
        fragment: Fragment
    ) {
        transaction.show(fragment)
        transaction.commit()
    }

    fun hideFragment(
        transaction: FragmentTransaction,
        fragment: Fragment
    ) {
        transaction.hide(fragment)
        transaction.commit()
    }

    fun toggleFragment(
        transaction: FragmentTransaction,
        fragmentShow: Fragment,
        fragmentHide: Fragment
    ) {
        transaction.hide(fragmentHide)
        transaction.show(fragmentShow)
        transaction.commit()
    }

    fun removeFragment(
        transaction: FragmentTransaction,
        fragment: Fragment
    ) {
        transaction.remove(fragment)
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

    fun getByTag(
        fragmentManager: FragmentManager,
        TAG: String
    ): Fragment? {
        return fragmentManager.findFragmentByTag(TAG)
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
