package com.kej.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.toast
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getStringExtra("height").toInt()
        val weight = intent.getStringExtra("weight").toInt()

        val bmi = weight/ (height / 100.0).pow(2.0)

        when{
            bmi >= 35 -> resultTextVie.text ="고도 비만"
            bmi >= 30 -> resultTextVie.text ="2단계 비만"
            bmi >= 25 -> resultTextVie.text ="1단계 비만"
            bmi >= 23 -> resultTextVie.text ="과체중"
            bmi >= 18.5 -> resultTextVie.text ="정상"
            else -> resultTextVie.text ="저체중"
        }

        when{
            bmi >= 23 ->
                imageView.setImageResource(R.drawable.ic_sentiment_very_dissatisfied_black_24dp)
            bmi >= 18.5 ->
                imageView.setImageResource(R.drawable.ic_insert_emoticon_black_24dp)
            else ->
                imageView.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp)
        }

        toast("$bmi")

    }
}
