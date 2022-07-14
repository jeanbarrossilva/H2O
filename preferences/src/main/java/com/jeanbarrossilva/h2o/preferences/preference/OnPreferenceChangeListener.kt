package com.jeanbarrossilva.h2o.preferences.preference

interface OnPreferenceChangeListener {
    suspend fun <V: Any, P: Preference<V>> onPreferenceChange(preference: P, value: V)

    companion object {
        @Suppress("UNCHECKED_CAST")
        inline operator fun <reified V2: Any, reified P2: Preference<V2>> invoke(
            crossinline onPreferenceChange: suspend (P2, value: V2) -> Unit
        ): OnPreferenceChangeListener {
            return object: OnPreferenceChangeListener {
                override suspend fun <V : Any, P : Preference<V>> onPreferenceChange(
                    preference: P,
                    value: V
                ) {
                    if (preference is P2 && value is V2) {
                        onPreferenceChange(preference, value)
                    }
                }
            }
        }
    }
}