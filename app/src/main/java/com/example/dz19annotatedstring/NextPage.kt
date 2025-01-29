package com.example.dz19annotatedstring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dz19annotatedstring.ui.theme.DZ19AnnotatedStringTheme


class NextPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DZ19AnnotatedStringTheme {

                val linkAnnotation = LinkAnnotation.Clickable(tag = "back_button") {
                    onBackPressed()
                }

                Text(
                    fontSize = 32.sp,
                    text = buildAnnotatedString {
                        withStyle(
                            ParagraphStyle(
                                lineHeight = 40.sp,
                                textIndent = TextIndent(30.sp, 10.sp)
                            )
                        ) {
                            append("Ну вот мы на второй странице! Может вернемся на ")
                            withLink(link = linkAnnotation) {
                                withStyle(
                                    SpanStyle(
                                        color = Color.Red,
                                        textDecoration = TextDecoration.Underline,
                                    )
                                ) {
                                    append("старт")
                                }
                            }
                            append(" ?")
                        }

                    }
                )
            }
        }
    }
}