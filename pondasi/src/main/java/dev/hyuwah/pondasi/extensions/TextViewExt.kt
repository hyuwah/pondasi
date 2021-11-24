package dev.hyuwah.pondasi.extensions

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import dev.hyuwah.pondasi.internal.InitialValueFlow
import dev.hyuwah.pondasi.internal.asInitialValueFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.isActive

/**
 * Create a flow of character sequences for text changes on [TextView].
 *
 * *Note:* A value will be emitted immediately.
 *
 * Examples:
 *
 * ```
 * // handle initial value
 * textView.textChanges()
 *      .onEach { /* handle text changes */ }
 *      .launchIn(lifecycleScope) // lifecycle-runtime-ktx
 *
 * // drop initial value
 * textView.textChanges()
 *      .dropInitialValue()
 *      .onEach { /* handle text changes */ }
 *      .launchIn(lifecycleScope)
 * ```
 */
fun TextView.textChanges(): InitialValueFlow<CharSequence> = channelFlow {
    val listener = listener(this, ::trySend)
    addTextChangedListener(listener)
    awaitClose { removeTextChangedListener(listener) }
}.asInitialValueFlow(text)

private fun listener(
    scope: CoroutineScope,
    emitter: (CharSequence) -> Unit
) = object : TextWatcher {

    override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {}

    override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
        if(scope.isActive) emitter(p0)
    }

    override fun afterTextChanged(p0: Editable) {}

}