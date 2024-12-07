package com.example.moviesapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.databinding.ActivityRecyclerViewBinding


class RecyclerView : AppCompatActivity() {
    private val moviesAdapter by lazy { MoviesAdapter() }
    private lateinit var binding: ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val username = intent.getStringExtra("Username")
        binding.welcome.text = "Welcome: $username"


        binding.toolbar.setTitle("MoviesApp")
        setSupportActionBar(binding.toolbar)

        MoviesAdapter.updateList(getMoreItems())
        binding.rvMovies.adapter = moviesAdapter
        binding.rvMovies.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    }



    private fun getMoreItems(): List<MoviesAdapter.MoviesDataClass> {
        return listOf(
                 MoviesAdapter.MoviesDataClass(
                "Elemental", R.drawable.elemental, "2023", "6.8",
                     "In a city where fire, water, land, and air residents live together, a fiery young woman and a go-with-the-flow guy discover something elemental: how much they have in common."),
            MoviesAdapter.MoviesDataClass("Mrs. Doubtfire",R.drawable.mrsdoubtfire,"1993","7.0",
                    "After a bitter divorce, a father disguises himself as a female housekeeper to be closer to his children, but the job becomes more than he bargained for."),
            MoviesAdapter.MoviesDataClass("The Intern", R.drawable.intern, "2015", "7.1",
                "A 70-year-old widower becomes an intern at an online fashion retailer, where he forms an unlikely friendship with its young CEO."
            ),
            MoviesAdapter.MoviesDataClass("The Adam Project", R.drawable.project, "2022", "6.7",
                "After crash-landing in 2022, time-traveling fighter pilot Adam Reed teams up with his 12-year-old self on a mission to save the future."

            ),
            MoviesAdapter.MoviesDataClass





            )


    }








    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.more ->
                true

            else -> super.onOptionsItemSelected(item)
        }

    }
}