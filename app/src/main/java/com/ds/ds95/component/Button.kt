package com.ds.ds95.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.ds.ds95.core.font.FontStyleTitle
import com.ds.ds95.core.token.TokensSize

@Composable
fun Ds95Button(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {}
) {
    Ds95ElevatedBackground(
        modifier = modifier
            .clickable(onClick = onClick)
    ) {
        Text(
            text= text,
            modifier = Modifier.padding(TokensSize.largePixel),
            textAlign = TextAlign.Center,
            style = FontStyleTitle,
        )
    }
}