package com.example.snapchef

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.snapchef.adapter.FlavourAdapter
import com.example.snapchef.databinding.ActivityDetailBinding
import com.example.snapchef.model.Ingredients
import com.example.snapchef.model.recipeContains
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private val list = ArrayList<Ingredients>()

    private lateinit var binding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        val getDatas = intent.getParcelableExtra<recipeContains>(data_reeciever) as recipeContains

        binding.rvFlavour.setHasFixedSize(true)
        binding.rvFlavour.layoutManager = LinearLayoutManager(this)

        Picasso.get().load(getDatas.image).into(binding.foodImageDetail)
        binding.foodNameDetail.text = getDatas.label
        binding.foodeMakerDetail.text = getDatas.source

        list.addAll(getDatas.ingredients)
        binding.rvFlavour.adapter = FlavourAdapter(list)

    }

    companion object{
        val data_reeciever = "data_input"
    }
}