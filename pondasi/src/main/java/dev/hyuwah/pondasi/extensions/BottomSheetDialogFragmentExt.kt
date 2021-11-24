package dev.hyuwah.pondasi.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

fun BottomSheetDialogFragment.show(fragment: Fragment, tag: String = javaClass.name) {
    show(fragment.requireActivity(), tag)
}

fun BottomSheetDialogFragment.show(activity: FragmentActivity, tag: String = javaClass.name) {
    show(activity.supportFragmentManager, tag)
}