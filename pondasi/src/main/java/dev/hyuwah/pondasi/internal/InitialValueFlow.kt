package dev.hyuwah.pondasi.internal

import androidx.annotation.RestrictTo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*


class InitialValueFlow<T>(private val flow: Flow<T>) : Flow<T> by flow {
    fun dropInitialValue(): Flow<T> = drop(1)
    suspend fun asStateFlow(scope: CoroutineScope): StateFlow<T> = stateIn(scope)
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
fun <T> Flow<T>.asInitialValueFlow(value: T): InitialValueFlow<T> = InitialValueFlow(
    onStart { emit(value) }
)