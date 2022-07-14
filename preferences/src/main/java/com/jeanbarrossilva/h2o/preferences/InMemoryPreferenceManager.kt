package com.jeanbarrossilva.h2o.preferences

import com.jeanbarrossilva.h2o.preferences.preference.OnPreferenceChangeListener
import com.jeanbarrossilva.h2o.preferences.preference.Preference

class InMemoryPreferenceManager: PreferenceManager {
    private val preferences = mutableMapOf<Preference<*>, Any>()
    private val listeners = mutableListOf<OnPreferenceChangeListener>()

    @Suppress("UNCHECKED_CAST")
    override suspend fun <T: Any> get(preference: Preference<T>): T? {
        return preferences[preference] as T?
    }

    override suspend fun <T: Any> set(preference: Preference<T>, value: T) {
        preferences[preference] = value
        notifyListeners(preference, value)
    }

    override fun doOnChange(listener: OnPreferenceChangeListener) {
        listeners.add(listener)
    }

    override suspend fun reset() {
        preferences.clear()
    }

    private suspend fun <V: Any, P: Preference<V>> notifyListeners(preference: P, value: V) {
        listeners.forEach { listener ->
            listener.onPreferenceChange(preference, value)
        }
    }
}