package com.jeanbarrossilva.h2o.preferences

import com.jeanbarrossilva.h2o.preferences.preference.OnPreferenceChangeListener
import com.jeanbarrossilva.h2o.preferences.preference.Preference

interface PreferenceManager {
    suspend fun <V: Any> get(preference: Preference<V>): V?

    suspend fun <T: Any> set(preference: Preference<T>, value: T)

    fun doOnChange(listener: OnPreferenceChangeListener)

    suspend fun reset()
}