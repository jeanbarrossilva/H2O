package com.jeanbarrossilva.h2o.feature.reminder.extensions.default

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.graphics.drawable.toBitmap
import io.karn.notify.entities.Payload

fun Payload.Content.Default.title(context: Context?, @StringRes titleRes: Int) {
    title = context?.getString(titleRes)
}