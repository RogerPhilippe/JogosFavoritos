package br.com.fiap.rpp.jogosfavoritos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.rpp.jogosfavoritos.model.Game
import kotlinx.android.synthetic.main.game_item.view.*

class GameAdapter(
    private val mContext: Context,
    private val mGameList: MutableList<Game>,
    private val listener: (Game) -> Unit
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = LayoutInflater.from(mContext).inflate(R.layout.game_item, parent, false)
        return GameViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mGameList.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bindView(mGameList[position], listener)
    }


    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(game: Game, listener: (Game) -> Unit) = with(itemView) {

            if (game.imageResource > 0) {
                gameImage.setImageDrawable(ContextCompat.getDrawable(context, game.imageResource))
            }
            gameTitle.text = game.title
            gameYear.text = resources.getString(R.string.game_year, game.year)
            gameDescription.text = game.description

            setOnClickListener { listener(game) }
        }
    }
}