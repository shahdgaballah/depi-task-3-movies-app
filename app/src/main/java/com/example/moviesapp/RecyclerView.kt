package com.example.moviesapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Grid
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapp.databinding.ActivityRecyclerViewBinding
import androidx.recyclerview.widget.RecyclerView.LayoutManager as LayoutManager1

class RecyclerView : AppCompatActivity() {


    private lateinit var binding: ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val username = intent.getStringExtra("Username")
        binding.welcome.text = "Welcome: $username"


        binding.toolbar.setTitle("MoviesApp")
        setSupportActionBar(binding.toolbar)

        binding.rvMovies.layoutManager =GridLayoutManager(this, GridLayoutManager.HORIZONTAL)


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