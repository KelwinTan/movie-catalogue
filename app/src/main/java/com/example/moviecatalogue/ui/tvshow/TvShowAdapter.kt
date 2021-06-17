package com.example.moviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.FilmEntity
import com.example.moviecatalogue.databinding.ItemsTvshowBinding
import com.example.moviecatalogue.ui.detail.DetailFilmActivity

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.FilmViewHolder>() {

    class FilmViewHolder(private val binding: ItemsTvshowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: FilmEntity) {
            with(binding){
                tvTvshowTitle.text = tvShow.title
                tvTvshowDate.text = itemView.resources.getString(R.string.release_date, tvShow.releaseDate)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(DetailFilmActivity.EXTRA_FILM, tvShow.filmId)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(tvShow.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(tvshowImg)
            }
        }
    }

    private var listTvShows = ArrayList<FilmEntity>()

    fun setTvShows(tvShows: List<FilmEntity>?) {
        if(tvShows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FilmViewHolder {
        val itemsTvShowBinding = ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val tvShow = listTvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShows.size

}