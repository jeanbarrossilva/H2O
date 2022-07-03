package com.jeanbarrossilva.h2o.ui.today.component

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.jeanbarrossilva.h2o.model.intake.Intake
import com.jeanbarrossilva.h2o.ui.environment.ContentAlpha
import com.jeanbarrossilva.h2o.ui.environment.Spacing
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme
import com.jeanbarrossilva.h2o.ui.today.R

@Composable
internal fun IntakeCard(
    intake: Intake,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = MaterialTheme.shapes.medium
    val backgroundColor = MaterialTheme.colorScheme.surface
    val spacing = Spacing.xxxl

    ConstraintLayout(
        modifier
            .fillMaxWidth()
            .clip(shape)
            .border(2.dp, MaterialTheme.colorScheme.surfaceVariant.copy(ContentAlpha.MEDIUM), shape)
            .background(backgroundColor)
            .clickable(role = Role.Button, onClick = onClick)
            .padding(spacing)
    ) {
        val (infoRef, spacerRef, iconRef) = createRefs()

        ProvideTextStyle(LocalTextStyle.current.copy(contentColorFor(backgroundColor))) {
            Column(
                Modifier.constrainAs(infoRef) {
                    width = Dimension.fillToConstraints
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(spacerRef.start)
                    bottom.linkTo(parent.bottom)
                },
                Arrangement.spacedBy(Spacing.s)
            ) {
                Text(
                    stringResource(R.string.today_intake).format("${intake.milliliters}"),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    stringResource(R.string.today_intake_card_info_drink_water),
                    color = LocalTextStyle.current.color.copy(ContentAlpha.MEDIUM)
                )
            }
        }

        Spacer(
            Modifier
                .width(spacing)
                .constrainAs(spacerRef) {
                    height = Dimension.fillToConstraints
                    start.linkTo(infoRef.end)
                    top.linkTo(parent.top)
                    end.linkTo(iconRef.start)
                    bottom.linkTo(parent.bottom)
                }
        )

        Image(
            painterResource(R.drawable.ic_drink_water),
            contentDescription =
            stringResource(R.string.today_intake_card_icon_drink_content_description),
            Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(Spacing.l)
                .constrainAs(iconRef) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun IntakeCardPreview() {
    H2OTheme {
        IntakeCard(
            Intake(2000),
            onClick = { }
        )
    }
}