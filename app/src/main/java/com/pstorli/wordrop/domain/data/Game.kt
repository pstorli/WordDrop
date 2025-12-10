package com.pstorli.wordrop.domain.data

class Game (val rows: Int =0, val cols: Int=0) {
    // The board
    var board = Board (rows, cols)

}