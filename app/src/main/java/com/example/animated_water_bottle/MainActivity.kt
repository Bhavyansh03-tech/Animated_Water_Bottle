package com.example.animated_water_bottle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animated_water_bottle.ui.theme.AnimatedWaterBottleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimatedWaterBottleTheme {

                var usedAmount by remember {
                    mutableIntStateOf(400)
                }

                val totalAmount = remember {
                    2400
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        WaterBottle(totalWaterAmount = totalAmount, unit = "ml", usedWaterAmount = usedAmount)

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(text = "Total amount is : $$totalAmount")

                        Button(
                            onClick = {
                                usedAmount += 200
                                if (usedAmount >= totalAmount) {
                                    usedAmount = totalAmount
                                }
                            }
                        ) {
                            Text(text = "Add 200")
                        }
                    }
                }
            }
        }
    }
}