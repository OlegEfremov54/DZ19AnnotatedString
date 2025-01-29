package com.example.dz19annotatedstring

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.dz19annotatedstring.ui.theme.DZ19AnnotatedStringTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DZ19AnnotatedStringTheme {
                val linkAnnotation = LinkAnnotation.Clickable(
                    tag = "next_page",
                    styles = null
                ) {
                    val intent = Intent(this, NextPage::class.java)
                    startActivity(intent)
                }

                Text(
                    buildAnnotatedString {
                        append("Перейдем на  ")

                        withLink(
                            link = linkAnnotation
                        ) {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.primary,
                                    fontSize = 32.sp,
                                    textDecoration = TextDecoration.Underline,
                                )
                            ) {
                                append("следующую ")
                            }
                        }

                        append(" страницу?")

                    },
                    fontSize = 32.sp
                )


            }
        }
    }
}