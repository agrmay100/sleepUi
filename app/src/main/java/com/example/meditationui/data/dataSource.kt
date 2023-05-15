package com.example.meditationui.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import com.example.meditationui.ui.theme.*
import com.example.meditationui.util.standardQuadCurrentFromTo
import com.example.meditationui.util.standardQuadFromTo


object Constants {

    val chipsList = listOf<String>("Sweet sleep", "Insomnia", "Depression", "Sweet sleep")

    val features = listOf(
        Feature(
            title = "Sleep meditation",
            Icons.Outlined.Headphones,
            BlueViolet1,
            BlueViolet2,
            BlueViolet3
        ),
        Feature(
            title = "Tips for sleeping",
            Icons.Outlined.Headphones,
            LightGreen1,
            LightGreen2,
            LightGreen3
        ),
        Feature(
            title = "Night island",
            Icons.Outlined.Headphones,
            OrangeYellow3,
            OrangeYellow2,
            OrangeYellow1,
        ),
        Feature(
            title = "Calming sounds",
            Icons.Outlined.Headphones,
            Beige1,
            Beige2,
            Beige3
        ),
        Feature(
            title = "Calming sounds",
            Icons.Outlined.Headphones,
            Beige1,
            Beige2,
            Beige3
        ),
        Feature(
            title = "Calming sounds",
            Icons.Outlined.Headphones,
            Beige1,
            Beige2,
            Beige3
        )
    )

    val bottomItems = listOf(
        BottomMenuContent("Home", Icons.Outlined.Home),
        BottomMenuContent("Meditate", Icons.Outlined.ChatBubbleOutline),
        BottomMenuContent("Sleep", Icons.Outlined.ShieldMoon),
        BottomMenuContent("Music", Icons.Outlined.LibraryMusic),
        BottomMenuContent("Profile", Icons.Outlined.PermIdentity),
    )

    fun getMediumColorPath(width: Int, height: Int): Path {

        // Medium colored path
        val point1 = Offset(0f, height * 0.3f)
        val point2 = Offset(width * 0.1f, height * 0.35f)
        val point3 = Offset(width * 0.4f, height * 0.05f)
        val point4 = Offset(width * 0.75f, height * 0.7f)
        val point5 = Offset(width * 1.4f, -height.toFloat())


        return Path().apply {
            moveTo(point1.x, point1.y)
            standardQuadFromTo(point1, point2)
            standardQuadFromTo(point2, point3)
            standardQuadFromTo(point3, point4)
            standardQuadFromTo(point4, point5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
    }

    fun getLightColorPath(width: Int, height: Int): Path {

        // Medium colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)


        return Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
    }

    fun getCurrentColorPath(width: Int, height: Int): Path {

        // Medium colored path
        val point1 = Offset(width * 0.24f, height * 0.25f)
        val point01 = Offset(width * 0.40f, -height * 0.3f)
        val point2 = Offset(width * 0.7f, -height * 3f)
        val point3 = Offset(width * 0.62f, height * 0.25f)
        val point4 = Offset(width * 0.75f, height * 0.45f)
        val point5 = Offset(width * 0.9f, height * 0.04f)
        val point51 = Offset(width * 1f, height * 0.5f)
        val point52 = Offset(width * 3f, height * 0.5f)
        val point6 = Offset(width * 1.2f, height * 4f)
        val point7 = Offset(width * 0.90f, height * 0.8f)
        val point8 = Offset(width *0.75f, height * 1f)
        val point9 = Offset(width * 0.60f, height * 0.8f)
        val point10 = Offset(width * 0.55f, height * 5f)
        val point11 = Offset(width * 0.25f, height * 0.9f)
        val point12 = Offset(width * 0.2f, height * 0.75f)
        val point13 = Offset(width * 0.2f, height * 0.2f)



        return Path().apply {
            moveTo(point1.x, point1.y)
            standardQuadCurrentFromTo(point1, point01)
            standardQuadCurrentFromTo(point01, point2)
            standardQuadCurrentFromTo(point2, point3)
            standardQuadCurrentFromTo(point3, point4)
            standardQuadCurrentFromTo(point4, point5)
            standardQuadCurrentFromTo(point5, point51)
            standardQuadCurrentFromTo(point51, point52)
            standardQuadCurrentFromTo(point5, point6)
            standardQuadCurrentFromTo(point6, point7)
            standardQuadCurrentFromTo(point7, point8)
            standardQuadCurrentFromTo(point8, point9)
            standardQuadCurrentFromTo(point9, point10)
            standardQuadCurrentFromTo(point10, point11)
            standardQuadCurrentFromTo(point11, point12)
            standardQuadCurrentFromTo(point12, point13)
//            standardQuadFromTo(point9, point10)
//            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
//            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
    }


}