package com.pstorli.wordrop.domain.data

import androidx.compose.ui.graphics.Color

class Square (var row: Int =0, var col: Int=0)
{
    var imageId: Int?           = null // R.drawable.ic_square
    var backgroundColor: Color? = null // trans
    var contentDescription      = ""
}