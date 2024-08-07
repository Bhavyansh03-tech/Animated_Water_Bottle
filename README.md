# Animated Water Bottle in Jetpack Compose

This project demonstrates an animated water bottle UI using Jetpack Compose. It visually represents the amount of water consumed out of a total capacity with a dynamic animation.

## Features

- Animated water level based on consumption.
- Interactive UI with a button to add water.
- Smooth transitions and animations using Jetpack Compose.

## Preview

<img src="https://github.com/user-attachments/assets/f5b9644f-ee4e-4e28-9779-df36b1a375b7" alt="First Screenshot" style="width: 200px; height: auto; margin-right: 10px;">

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/Bhavyansh03-tech/Animated_Water_Bottle.git
    ```

2. Open the project in Android Studio.

3. Sync the project with Gradle files.

## Usage

To use this composable in your project, simply include the `WaterBottle` composable in your UI. Here's a brief example:

```kotlin
@Composable
fun WaterBottle(
    modifier: Modifier = Modifier,
    totalWaterAmount: Int,
    unit: String,
    usedWaterAmount: Int,
    waterColor: Color = Color(0xff279eff),
    bottleColor: Color = Color.White,
    capColor: Color = Color(0xff0065b9)
) {
    val waterPercentage =
        animateFloatAsState(
            targetValue = usedWaterAmount.toFloat() / totalWaterAmount.toFloat(),
            label = "Water Waves Animation",
            animationSpec = tween(durationMillis = 1000)
        ).value

    val usedWaterAmountAnimation =
        animateIntAsState(
            targetValue = usedWaterAmount,
            label = "Used Water Animation",
            animationSpec = tween(durationMillis = 1000)
        ).value

    Box(
        modifier = modifier
            .width(200.dp)
            .height(600.dp)
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val width = size.width
            val height = size.height

            val capWidth = size.width * 0.55f
            val capHeight = size.height * 0.13f

            val bottleBodyPath = Path().apply {
                moveTo(
                    x = width * 0.3f, y = height * 0.1f
                )
                lineTo(
                    x = width * 0.3f, y = height * 0.2f
                )
                quadraticBezierTo(
                    x1 = 0f, y1 = height * 0.3f,
                    x2 = 0f, y2 = height * 0.4f
                )
                lineTo(
                    x = 0f,
                    y = height * 0.95f
                )
                quadraticBezierTo(
                    x1 = 0f, y1 = height,
                    x2 = width * 0.05f, y2 = height
                )
                lineTo(
                    x = width * 0.95f,
                    y = height
                )
                quadraticBezierTo(
                    x1 = width, y1 = height,
                    x2 = width, y2 = height * 0.95f
                )
                lineTo(
                    x = width,
                    y = height * 0.4f
                )
                quadraticBezierTo(
                    x1 = width, y1 = height * 0.3f,
                    x2 = width * 0.7f, y2 = height * 0.2f
                )
                lineTo(
                    x = width * 0.7f,
                    y = height * 0.1f
                )
                close()
            }
            clipPath(
                bottleBodyPath
            ) {
                drawRect(
                    color = bottleColor,
                    size = size
                )

                val waterWavesYPosition = (1 - waterPercentage) * size.height
                val waterPath = Path().apply {
                    moveTo(
                        x = 0f,
                        y = waterWavesYPosition
                    )
                    lineTo(
                        x = size.width,
                        y = waterWavesYPosition
                    )
                    lineTo(
                        x = size.width,
                        y = size.height
                    )
                    lineTo(
                        x = 0f,
                        y = size.height
                    )
                    close()
                }
                drawPath(
                    path = waterPath,
                    color = waterColor
                )
            }
            drawRoundRect(
                color = capColor,
                size = Size(capWidth, capHeight),
                topLeft = Offset(size.width / 2 - capWidth / 2f, 0f),
                cornerRadius = CornerRadius(45f, 45f)
            )
        }

        val text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = if (waterPercentage > 0.5f) bottleColor else waterColor,
                    fontSize = 44.sp
                )
            ) {
                append(usedWaterAmountAnimation.toString())
            }
            withStyle(
                style = SpanStyle(
                    color = if (waterPercentage > 0.5f) bottleColor else waterColor,
                    fontSize = 22.sp
                )
            ) {
                append(" ")
                append(unit)
            }
        }

        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(text = text)
        }
    }
}
```

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any improvements or bug fixes.

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Create a new Pull Request.

## Contact

For questions or feedback, please contact [@Bhavyansh03-tech](https://github.com/Bhavyansh03-tech).

---
