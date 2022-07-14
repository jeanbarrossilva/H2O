package com.jeanbarrossilva.h2o.preferences.preference

import com.jeanbarrossilva.h2o.model.drinker.Drinker as _Drinker
import com.jeanbarrossilva.h2o.model.intake.IntakeStatus as _IntakeStatus

sealed interface Preference<T: Any> {
    object Drinker: Preference<_Drinker>

    object IntakeStatus: Preference<_IntakeStatus>
}