package br.com.fiap.rpp.jogosfavoritos

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.rpp.jogosfavoritos.model.Game
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGameList.adapter = GameAdapter(this, loadGames()) { itemTapListener(it) }

    }

    private fun loadGames(): MutableList<Game> {

        val gameList = mutableListOf<Game>()

        gameList.add(mockGame())

        return gameList
    }

    private fun mockGame(): Game {
        return Game(0, "EletricGame 2000", "2019", "Jogo Eletrizante")
    }

    private fun itemTapListener(game: Game) {
        Toast.makeText(this, game.title, Toast.LENGTH_SHORT).show()
    }

}
