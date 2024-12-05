package com.example.moviesapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener{
            val username = binding.username.text.toString().trim()
            val password = binding.password.text.toString().trim()

            if(username.isEmpty()){
                binding.username.error =  "Username cannot be empty"
                return@setOnClickListener
            }
            if (password.length <8) {
                binding.password.error = "Password must be at least 8 characters"
                return@setOnClickListener

            }
            val intent = Intent(this,RecyclerView::class.java)
                intent.putExtra("Username", username)
            startActivity(intent)
               finish()
        }
        }
    }