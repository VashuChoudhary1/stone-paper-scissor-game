package com.example.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playButton: Button = findViewById(R.id.button)
        playButton.setOnClickListener { playCard() }
        playCard()
    }

    private fun playCard() {
        val card = Card(3)
        val cardPlay = card.play()
        val cardImage: ImageView = findViewById(R.id.imageView2)
        val drawableResource = when (cardPlay) {
            1 -> R.drawable.card_1
            2 -> R.drawable.card_2
            else -> R.drawable.card_3

        }
        cardImage.setImageResource(drawableResource)
        cardImage.contentDescription = cardPlay.toString()

    }
}
class Card( private val numSides: Int){
    fun play(): Int{
        return(1..numSides).random()
    }
}