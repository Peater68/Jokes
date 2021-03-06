package hu.bme.aut.jokes.ui.common.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import hu.bme.aut.jokes.R
import hu.bme.aut.jokes.databinding.RowJokeItemBinding
import hu.bme.aut.jokes.ui.common.model.Joke
import hu.bme.aut.jokes.ui.common.model.JokeComparator

enum class JokesAdapterType {
    RANDOM, MY
}

class JokesAdapter(
    private val context: Context,
    private val type: JokesAdapterType = JokesAdapterType.RANDOM,
    private val iconClick: ((joke: Joke) -> Unit)? = null
) :
    ListAdapter<Joke, JokesAdapter.ViewHolder>(JokeComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(RowJokeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        with(holder.binding) {
            categoryText.text = item.category
            jokeText.text = item.joke

            setupIcon(item)

            flagChipGroup.removeAllViews()
            item.flags.forEach {
                flagChipGroup.addView(Chip(context).apply { text = it.name })
            }
        }
    }

    private fun RowJokeItemBinding.setupIcon(joke: Joke) {
        when (type) {
            JokesAdapterType.RANDOM -> {
                if (joke.isLiked) {
                    likeButton.setImageResource(R.drawable.ic_star_filled)
                } else {
                    likeButton.setImageResource(R.drawable.ic_star_outline)
                }
            }
            JokesAdapterType.MY -> {
                likeButton.setImageResource(R.drawable.ic_delete)
            }
        }
        likeButton.setOnClickListener { iconClick?.invoke(joke) }
    }

    inner class ViewHolder(val binding: RowJokeItemBinding) : RecyclerView.ViewHolder(binding.root)
}