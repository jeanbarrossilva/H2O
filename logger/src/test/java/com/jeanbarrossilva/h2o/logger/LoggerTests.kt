package com.jeanbarrossilva.h2o.logger

import com.jeanbarrossilva.h2o.model.intake.Intake
import com.jeanbarrossilva.h2o.logger.time.MomentProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import java.time.LocalDateTime
import java.time.Month
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

@OptIn(ExperimentalCoroutinesApi::class)
class LoggerTests {
    private val momentProvider = MomentProvider { LocalDateTime.of(2003, Month.OCTOBER, 8, 8, 0) }
    private val logger = InMemoryLogger(momentProvider)

    @Test
    fun `GIVEN added intakes and removed ones WHEN getting all THEN the remaining are returned`() {
        runTest {
            repeat(256) { logger.log(Intake.sample) }
            logger.getLogs().slice(8..31).forEach { logger.remove(it) }
            assertEquals(232, logger.getLogs().size)
        }
    }

    @Test
    fun `GIVEN an intake WHEN logging it THEN it's logged`() {
        runTest {
            val log = logger.log(Intake.sample)
            assertEquals(log, logger.getLogById(log.id))
        }
    }

    @Test
    fun `GIVEN an intake WHEN logging it THEN its log has been created now`() {
        runTest {
            val log = logger.log(Intake.sample)
            assertEquals(momentProvider.provide(), log.creationMoment)
        }
    }

    @Test
    fun `GIVEN an intake WHEN removing it THEN it's removed`() {
        runTest {
            val log = logger.log(Intake.sample)
            logger.remove(log)
            assertNull(logger.getLogById(log.id))
        }
    }
}