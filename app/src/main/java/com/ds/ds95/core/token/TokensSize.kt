package com.ds.ds95.core.token

import androidx.compose.ui.unit.*

@OptIn(ExperimentalUnitApi::class)
object TokensSize{

    val smallPixel: Dp = 5.dp
    val mediumPixel: Dp = 8.dp
    val largePixel: Dp = 16.dp
    val smallText: TextUnit = TextUnit(14f, TextUnitType.Sp)
    val mediumText: TextUnit = TextUnit(18f, TextUnitType.Sp)
    val largeText: TextUnit = TextUnit(22f, TextUnitType.Sp)

    override fun toString(): String {
        return """
            TokensSize(
              smallPixel= $smallPixel,
              mediumPixel= $mediumPixel,
              largePixel= $largePixel,
              smallText= $smallText,
              mediumText= $mediumText,
              largeText= $largeText
            )
        """.trimIndent()
    }
}