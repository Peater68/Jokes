package hu.bme.aut.jokes.ui.randomjokes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import hu.bme.aut.jokes.R
import hu.bme.aut.jokes.databinding.RowJokeItemBinding
import hu.bme.aut.jokes.ui.randomjokes.model.Joke
import hu.bme.aut.jokes.ui.randomjokes.model.JokeComparator


class JokesAdapter(
    private val context: Context,
    private val iconClick: ((id: Long) -> Unit)? = null
) :
    ListAdapter<Joke, JokesAdapter.ViewHolder>(JokeComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(RowJokeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        with(holder.binding) {
            categoryText.text = item.category
            jokeText.text = item.joke
            if (item.isLiked) {
                likeButton.setImageResource(R.drawable.ic_star_filled)
            } else {
                likeButton.setImageResource(R.drawable.ic_star_outline)
            }
            likeButton.setOnClickListener { iconClick?.invoke(item.id) }
            item.flags.forEach {
                flagChipGroup.addView(Chip(context).apply { text = it.name })
            }
        }
    }

    inner class ViewHolder(val binding: RowJokeItemBinding) : RecyclerView.ViewHolder(binding.root)
}