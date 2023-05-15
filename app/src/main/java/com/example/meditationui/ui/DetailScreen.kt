package com.example.meditationui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Headphones
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.meditationui.data.Feature
import com.example.meditationui.ui.components.featureItem
import com.example.meditationui.ui.theme.*


@Preview
@Composable
fun DetailScreen(
    feature: Feature = Feature(
        title = "",
        Icons.Outlined.Headphones,
        BlueViolet1,
        BlueViolet2,
        BlueViolet3
    ),
    navController: NavController = rememberNavController()
) {
    MaterialTheme() {
        Scaffold(
            backgroundColor = DeepBlue,
            topBar = {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 20.dp)
                ) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = null,

                        modifier = Modifier
                            .padding(10.dp)
                            .clickable {
                                if (navController.previousBackStackEntry != null) {
                                    navController.navigateUp()
                                } else {
                                    null
                                }
                            },
                        tint = TextWhite
                    )
                    Icon(
                        Icons.Filled.Star, contentDescription = "",
                        tint = TextWhite
                    )
                }
            },
            content = { contentPadding ->
                // Screen content
                Box(modifier = Modifier.padding(contentPadding)) {
                    Column(
                        horizontalAlignment = Alignment.Start,

                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp)
                    ) {

                        Text(
                            text = "Sleep Meditation",
                            style = MaterialTheme.typography.h4,
                            color = TextWhite
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "We wish you have a good day!",
                            style = MaterialTheme.typography.body1,
                            color = TextWhite
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        featureItem(feature = feature, ratio = 1.4f, navController = navController)

                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            text = "Sleep music  - 45 min",
                            style = MaterialTheme.typography.body1,
                            color = AquaBlue
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Ease the mind into a restful night's sleep with these deep, amblent tones.",
                            style = MaterialTheme.typography.body1,
                            color = AquaBlue,
                            lineHeight = 24.sp
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Icon(
                                    Icons.Filled.Star, contentDescription = "",
                                    tint = TextWhite
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "12,542 saved",
                                    style = MaterialTheme.typography.body1,
                                    color = AquaBlue
                                )
                            }
                            Row(
                                horizontalArrangement = Arrangement.End
                            ) {
                                Icon(
                                    Icons.Filled.Headphones, contentDescription = "",
                                    tint = TextWhite
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "43,752 listening",
                                    style = MaterialTheme.typography.body1,
                                    color = AquaBlue
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Divider(color = DarkerButtonBlue)


                    }
                }

            }
        )
    }
}