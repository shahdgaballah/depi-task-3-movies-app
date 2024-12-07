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

        moviesAdapter.updateList(getMoreItems())
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
            MoviesAdapter.MoviesDataClass("Sound of Metal", R.drawable.som, "2019", "7.8",
                "A drummer's life is thrown into freefall when he begins to lose his hearing and has to adapt to a new world of silence."
            ),
            MoviesAdapter.MoviesDataClass("Inglourious Basterds", R.drawable.ib, "2009", "8.3",
                "In Nazi-occupied France during World War II, a group of Jewish-American soldiers known as 'The Basterds' plan to assassinate Nazi leaders, while a young Jewish cinema proprietor seeks to avenge her family's death."
                ),
            MoviesAdapter.MoviesDataClass("To Kill A Mocking Bird", R.drawable.amb,"1962", "8.3",
                "Atticus Finch, a lawyer in the Depression-era South, defends a Black man against an undeserved rape charge, and his kids against prejudice."

            ),
            MoviesAdapter.MoviesDataClass("Scent of a Woman", R.drawable.sow, "1992", "8.0",
                    "The film follows a prep school student, Charlie, who takes on a temporary job to assist a blind and irritable retired Lieutenant Colonel, Frank Slade, over the Thanksgiving weekend. The journey leads to profound life lessons for both characters as they navigate challenges, form an unlikely bond, and discover the true meaning of integrity and courage."),
            MoviesAdapter.MoviesDataClass("Coco", R.drawable.coco, "2017", "8.4",
                "Despite his family's baffling generations-old ban on music, Miguel dreams of becoming an accomplished musician like his idol, Ernesto de la Cruz. Desperate to prove his talent, Miguel finds himself in the stunning and colorful Land of the Dead following a mysterious chain of events. Along the way, he meets charming trickster Hector, and together, they set off on an extraordinary journey to unlock the real story behind Miguel's family history."
            ),
            MoviesAdapter.MoviesDataClass("Soul", R.drawable.soul, "2020", "8.0",
                "Soul follows Joe Gardner, a middle school music teacher who dreams of becoming a jazz musician. After a life-changing event, Joe finds himself in the afterlife, where he must guide another soul, 22, who has no interest in living on Earth. Together, they explore the meaning of life, purpose, and passion. As they journey through various realms, Joe discovers that life is about more than fulfilling a dream; it’s about experiencing the joy in the little moments."
                ),
            MoviesAdapter.MoviesDataClass("The Shawshank Redemption", R.drawable.sr, "1994","9.3",
                "The film tells the story of Andy Dufresne, a banker sentenced to life imprisonment at Shawshank State Penitentiary for the murders of his wife and her lover, despite claiming his innocence. Over the years, Andy befriends fellow inmate Ellis \"Red\" Redding and becomes an instrumental figure in the prison's money-laundering operation, all while enduring hardships and fostering a sense of hope."
            )
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