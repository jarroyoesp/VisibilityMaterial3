@file:OptIn(ExperimentalMaterial3Api::class)

package com.jarroyo.visibilitymaterial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.Visibility
import com.jarroyo.visibilitymaterial3.ui.theme.VisibilityMaterial3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisibilityMaterial3Theme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}


@Composable
fun MainContent() {
    ConstraintLayout(modifier = Modifier
        .height(60.dp)
        .fillMaxWidth()) {
        val (checkBoxRef, radioButtonRef, textHiddenRef, titleRef) = createRefs()
        Checkbox(
            checked = false,
            onCheckedChange = { },
            modifier = Modifier
                .constrainAs(checkBoxRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    visibility = Visibility.Gone
                }
        )
        RadioButton(
            selected = false,
            onClick = { },
            modifier = Modifier
                .constrainAs(radioButtonRef) {
                    top.linkTo(parent.top)
                    start.linkTo(checkBoxRef.end)
                    bottom.linkTo(parent.bottom)
                    visibility = Visibility.Gone
                }
        )
        Text(
            text = "Lorem ipsum hidden",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .constrainAs(textHiddenRef) {
                    top.linkTo(parent.top)
                    start.linkTo(radioButtonRef.end)
                    bottom.linkTo(parent.bottom)
                    visibility = Visibility.Gone
                }
        )
        Text(
            text = "Lorem ipsum",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.constrainAs(titleRef) {
                top.linkTo(parent.top)
                start.linkTo(textHiddenRef.end, 8.dp)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VisibilityMaterial3Theme {
        MainContent()
    }
}