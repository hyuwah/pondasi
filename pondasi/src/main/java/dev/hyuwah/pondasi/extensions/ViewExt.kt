package dev.hyuwah.pondasi.extensions

import android.os.SystemClock
import android.view.View
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.isActive

/**
 * Method to add debounce to click listener.
 * Has exactly similar behavior with `throttleFirst` from RxJava.
 * Best used for button click because the first click will be handled immediately.
 *
 * @param debounceTime How long should the listener wait until dispatching another event
 * @param action the method that will be executed on valid click event
 */
fun View.setOnClickListenerDebounced(debounceTime: Long = 600L, action: (v: View) -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {

        // timestamp variable to remember each time the click is valid
        private var lastClickTime: Long = 0

        override fun onClick(v: View) {
            // if the difference between last click time and current time is lesser than applied debounceTime, do nothing
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return

            // else, do the actual action and save the timestamp
            else {
                action(v)
                lastClickTime = SystemClock.elapsedRealtime()
            }
        }
    })
}

/**
 * Method to convert click into Flow.
 * Can be chained with other Flow operator such as debounce() etc to create a desirable result.
 *
 * Example usage to make the click behaves exactly like `throttleWithTimeout` from RxJava:
 *
 * button.clicks().debounce(1000L).onEach {
 *     // actions
 * }.launchIn(lifecycle.coroutineScope)
 *
 * Example above best used for delayed / toggled actions such as liking a comment / replies.
 */
fun View.clicks(): Flow<Unit> = callbackFlow {
    setOnClickListener {
        if(isActive) trySend(Unit)
    }
    awaitClose { setOnClickListener(null) }
}
