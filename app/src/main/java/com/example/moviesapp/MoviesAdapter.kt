package com.example.moviesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.*
import com.example.moviesapp.databinding.MovieItemBinding
import androidx.recyclerview.widget.RecyclerView


class MoviesAdapter:RecyclerView.Adapter<MoviesAdapter.ViewHolder> (){
    private var movieList :List<MoviesDataClass> = emptyList()
    data class MoviesDataClass(var title: String,
                               var image: Int,
                        var date : String,
                        var rating : String,
                               var description : String,

    )
    class ViewHolder(val binding: MovieItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(movieItem: MoviesDataClass ) {
            binding.tvTitle.text = movieItem.title
            binding.tvDescription.text = movieItem.description
            binding.tvDate.text = movieItem.date
            binding.tvRating.text = movieItem.rating
            binding.movieImage.setImageResource(movieItem.image)
        }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    fun updateList(newList: List<MoviesAdapter.MoviesDataClass>){
        val diffUtilCallback = MyDiffUtil(oldList =this.movieList, newList =newList)
        this.movieList = newList
        val diffUtilResult = calculateDiff(diffUtilCallback)
        diffUtilResult.dispatchUpdatesTo(this)
    }


}




