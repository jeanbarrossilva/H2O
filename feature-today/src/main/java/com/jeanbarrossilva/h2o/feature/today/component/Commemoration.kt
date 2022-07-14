package com.jeanbarrossilva.h2o.feature.today.component

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.AnimationConstants.DefaultDurationMillis
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.h2o.feature.today.R
import com.jeanbarrossilva.h2o.feature.today.component.Commemoration.Delayable
import com.jeanbarrossilva.h2o.feature.today.component.Commemoration.animationSpec
import com.jeanbarrossilva.h2o.feature.today.delayable.DelayMode
import com.jeanbarrossilva.h2o.feature.today.delayable.Delayable
import com.jeanbarrossilva.h2o.feature.today.extensions.delayable.getActivenessState
import com.jeanbarrossilva.h2o.feature.today.extensions.delayable.previewDelayable
import com.jeanbarrossilva.h2o.ui.component.Background
import com.jeanbarrossilva.h2o.ui.environment.ContentAlpha
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme
import kotlin.time.Duration.Companion.seconds

private const val EMOJI_DELAY = 1000
private const val EMOJI_FADE_IN_DURATION = 50
private const val EMOJI_SCALE_IN_DURATION = 300

internal object Commemoration {
    val Delayable = Delayable(DelayMode.Limited(3.seconds))

    fun <T> animationSpec(duration: Int = DefaultDurationMillis, delay: Int = 0):
        FiniteAnimationSpec<T> {
        return tween(duration, delay)
    }
}

@Composable
internal fun Commemoration(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Commemoration(
        Delayable,
        modifier,
        content
    )
}

@Composable
@OptIn(ExperimentalAnimationApi::class)
private fun Commemoration(
    delayable: Delayable,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val isActive by delayable.getActivenessState()
    val emojiScaleIn = scaleIn(animationSpec(EMOJI_SCALE_IN_DURATION, EMOJI_DELAY))
    val emojiScaleOut = scaleOut(animationSpec())

    Box(modifier) {
        content()

        AnimatedVisibility(
            visible = isActive,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Surface(
                Modifier
                    .fillMaxSize()
                    .blur(24.dp),
                color = MaterialTheme.colorScheme.surface.copy(ContentAlpha.SCRIM)
            ) {
            }
        }

        AnimatedVisibility(
            visible = isActive,
            Modifier.align(Alignment.Center),
            enter = fadeIn(animationSpec(EMOJI_FADE_IN_DURATION, EMOJI_DELAY)) + emojiScaleIn,
            exit = fadeOut(animationSpec()) + emojiScaleOut
        ) {
            Text(
                stringResource(R.string.today_commemoration_emoji),
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun CommemorationPreview() {
    H2OTheme {
        Commemoration(previewDelayable()) {
            Background {
            }
        }
    }
}