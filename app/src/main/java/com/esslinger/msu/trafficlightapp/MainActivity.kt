package com.esslinger.msu.trafficlightapp

import android.os.Bundle
import androidx.core.content.ContextCompat
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var trafficLightImage: ImageView
    private lateinit var trafficLightButton: Button
    private var lightIndex = 0
    private val lightColors = arrayOf(R.color.red, R.color.yellow, R.color.green)
    private val lightTexts = arrayOf("STOP", "WAIT", "GO")
    private val lightImages = arrayOf(R.drawable.redlight, R.drawable.yellowlight, R.drawable.greenlight)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trafficLightImage = findViewById(R.id.traffic_light_image)
        trafficLightButton = findViewById(R.id.traffic_light_button)

        trafficLightButton.setOnClickListener {
            lightIndex = (lightIndex + 1) % lightColors.size
            updateTrafficLight()
        }
    }

    private fun updateTrafficLight() {
        val backgroundColorResId = lightColors[lightIndex]
        val buttonText = lightTexts[lightIndex]
        val imageResource = lightImages[lightIndex]

        val backgroundColor = ContextCompat.getColor(this, backgroundColorResId)
        trafficLightButton.setBackgroundColor(backgroundColor)
        trafficLightButton.text = buttonText
        trafficLightButton.setTextColor(ContextCompat.getColor(this, android.R.color.black))
        trafficLightImage.setImageResource(imageResource)
    }

}