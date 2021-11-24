package dev.hyuwah.pondasi.extensions

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

fun Activity.hideSoftKeyboard() {
    currentFocus?.let {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

fun EditText.focusAndShowSoftKeyboard() {
    post { 
        requestFocus()
        val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }
}