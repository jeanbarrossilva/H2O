package com.jeanbarrossilva.h2o.feature.today.delayable

internal sealed interface DelayFrequency {
    object Never: DelayFrequency

    object Once: DelayFrequency

    object Infinite: DelayFrequency
}