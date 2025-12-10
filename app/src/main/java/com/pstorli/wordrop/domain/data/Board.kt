package com.pstorli.wordrop.domain.data

class Board (val rows: Int =0, val cols: Int=0)
{
    // The squares on the board:
    var squares: Array<Array<Square>> = Array(rows) { rowIndex ->
        // This lambda is called for each row (0, 1, 2)

        // Create the inner array (the columns) for this specific row
        Array(cols) { colIndex ->
            // Create a new instance of the Sq class for each cell
            Square (row = rowIndex, col = colIndex)
        }
    }
}