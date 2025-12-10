package com.pstorli.wordrop.domain.data

import androidx.compose.ui.graphics.Color
import com.pstorli.wordrop.R

class Game (val rows: Int =0, val cols: Int=0) {
    // The board
    var board = Board (rows, cols)

    init {
        // ************************************************* //
        // Test Code
        // ************************************************* //

        // Try setting a color
        val square2 = getSquare (9,7)
        square2.imageId = R.drawable.ic_0

        // Try setting a color
        val square = getSquare (5,5)
        square.backgroundColor = Color.Green
    }

    /**
     * Set a square on the board to a new value.
     */
    fun setSquare (square: Square) {
        board.squares[square.row][square.col] = square
    }

    fun getSquare (row: Int, col: Int): Square {
        return board.squares[row][col]
    }
}