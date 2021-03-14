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
