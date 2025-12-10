package com.pstorli.wordrop.domain.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.pstorli.wordrop.domain.data.Game
import com.pstorli.wordrop.util.Prefs

class Vm (val app: Application) : AndroidViewModel (app)
{
    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////
    var prefs           = Prefs(app) // Preferences, initialize first

    // The game
    lateinit var game :Game

    /**
     * Create a new game.
     */
    fun createGame (rows:Int=0, cols:Int=0) {
        game = Game (rows,cols)
    }
}