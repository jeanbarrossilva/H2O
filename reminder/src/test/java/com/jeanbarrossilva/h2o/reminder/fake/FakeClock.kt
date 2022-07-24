package com.jeanbarrossilva.h2o.reminder.fake

import com.jeanbarrossilva.h2o.reminder.clock.Clock
import com.jeanbarrossilva.h2o.reminder.extensions.localtime.dec
import com.jeanbarrossilva.h2o.reminder.extensions.localtime.minus
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceTimeBy
import java.time.LocalTime

@OptIn(ExperimentalCoroutinesApi::class)
class FakeClock(override val coroutineScope: TestScope): Clock() {
    private var currentTime = defaultTime

    override fun getCurrentTime(): LocalTime {
        return currentTime
    }

    override fun onTick() {
        --currentTime
    }

    fun jumpTo(time: LocalTime) {
        val diff = time.minus(currentTime)
        coroutineScope.advanceTimeBy(diff.inWholeMilliseconds)
        currentTime = time
    }

    companion object {
        internal val defaultTime = LocalTime.MIDNIGHT
    }
}