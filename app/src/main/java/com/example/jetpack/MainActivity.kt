package com.example.jetpack

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.frames.wasModified
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.engine.geometry.Outline
import androidx.ui.engine.geometry.Shape
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Card
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}

fun NewsStory() {
    //load image into the app from the drawable
    Padding(left = 8.dp, top = 8.dp, right = 8.dp, bottom = 0.dp) {
        val image = +imageResource(R.drawable.ic_header)
        Spacing(16.dp)
        Card {
            MaterialTheme {
                Column(
                    //setting size of column to fill entire space on screen
                    crossAxisSize = LayoutSize.Expand,
                    //more like giving it some padding or margin
                    modifier = Spacing(bottom = 16.dp)
                ) {
                    //container is a content holder for other objects
                    Container(expanded = true, height = 180.dp) {
                        //clip method is used to round the corners
                        //DrawImage() actually handles drawing of the image on the screen
                        DrawImage(image)
                    }
                    //space between image and the text

                    HeightSpacer(16.dp)
                    Padding(left = 16.dp, top = 0.dp, right = 16.dp, bottom = 0.dp) {
                        Column {

                            Text(
                                "I spent the night here, and it's not all hype!",
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                style = (+themeTextStyle { h6 }).withOpacity(0.87f)
                            )
                            Text(
                                "Teshie Estates, Accra",
                                style = (+themeTextStyle { body2 }).withOpacity(0.87f)
                            )
                            Text(
                                "October 31",
                                style = (+themeTextStyle { body2 }).withOpacity(0.6f)
                            )
                        }
                    }

                    Padding(left = 16.dp, right = 16.dp, top = 16.dp, bottom = 0.dp){
                        Button(text = "Check Details", style = OutlinedButtonStyle(
                            color = Color.White,
                            contentColor = Color.DarkGray,
                            border = Border(Color.Black, Dp(2f)),
                            elevation = Dp(4f))
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        FlexColumn {
            expanded(flex = 1f) {
                VerticalScroller {
                    Column {
                        for (i in 1..5) {
                            NewsStory()
                        }
                    }
                }
            }
        }
    }
}
