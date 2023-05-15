package com.example.meditationui.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.PlayCircleFilled
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationui.data.BottomMenuContent
import com.example.meditationui.data.Constants
import com.example.meditationui.data.Feature
import com.example.meditationui.ui.components.featureItem
import com.example.meditationui.ui.theme.*

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
//            .verticalScroll(
//                rememberScrollState()
//            )
    ) {
        Column(
//            modifier = Modifier
//                .verticalScroll(rememberScrollState())
        ){
            GreetingSection()
            ChipSection(chips = Constants.chipsList)
            CurrentMeditation()
            FeatureSection(features = Constants.features)
        }
        BottomMenu(
            items = Constants.bottomItems,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}


@Composable
fun GreetingSection(
    name: String = "Mayank"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
            .padding(15.dp)
    ) {

        Column(verticalArrangement = Arrangement.Center) {

            Text(
                text = "Good Morning $name",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.body1
            )
        }
        Icon(
            Icons.Outlined.Search, contentDescription = "",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow() {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite, style = MaterialTheme.typography.h2)
            }
        }
    }
}

@Composable
fun CurrentMeditation() {
    BoxWithConstraints(
        modifier = Modifier
            .padding(20.dp)
            .clip(
                RoundedCornerShape(15.dp)
            )
            .background(LightRed)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .height(60.dp)
    ) {
        val he = constraints.maxHeight
        val wi = constraints.maxWidth

        val path = Constants.getCurrentColorPath(wi, he)

        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = path,
                color = DarkRed
            )
        }
        Box(
//            modifier = Modifier.height(he.toFloat().dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Daily Thoughts",
                        style = MaterialTheme.typography.h1,
                    )
                    Text(
                        text = "Meditation - 3-10 min",
                        style = MaterialTheme.typography.body1
                    )
                }
                Icon(
                    Icons.Filled.PlayCircle, contentDescription = "",

//                        tint = ButtonBlue,
                    modifier = Modifier
                        .size(40.dp)
                )
            }


        }
    }
}

@Composable
fun FeatureSection(features: List<Feature>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 80.dp)
    ) {
        Text(
            text = "Feature",
            style = MaterialTheme.typography.h4,
            color = TextWhite,
            modifier = Modifier.padding(start = 10.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp),
            modifier = Modifier.fillMaxHeight()
        ) {

            items(features.size) {
                featureItem(feature = features[it], modifier = Modifier.padding(7.5.dp))
            }

        }
    }
}


@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                item.icon,
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )
    }
}













