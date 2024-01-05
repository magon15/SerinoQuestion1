package com.example.serinoquestion1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.serinoquestion1.databinding.ActivityPriceListBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityPriceListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_price_list)

        val items = arrayOf("Toothpaste","Toothbrush","Mouthwash", "Hand Soap", "Candies", "Cotton", "Body Wash", "Floss", "Electric Toothbrush", "Cologne")
        val prices = (0..items.size).map { (10..30).random() }
        binding.recyclerPriceList.apply {
            adapter = PriceListAdapter(
                items,
                prices.toIntArray()
            )
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}