package com.example.meditationui.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationui.data.Constants
import com.example.meditationui.data.Feature
import com.example.meditationui.ui.theme.ButtonBlue
import com.example.meditationui.ui.theme.TextWhite


@Composable
fun featureItem(
    feature: Feature,
    ratio: Float = 1f,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = Modifier
            .aspectRatio(ratio)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val height = constraints.maxHeight
        val width = constraints.maxWidth

        val mediumColoredPath = Constants.getMediumColorPath(width, height)
        val lightColoredPath = Constants.getLightColorPath(width, height)

        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {

            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h1,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                feature.icon,
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue).clickable {
                        // Handle the click
                    }
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}