package com.sbrobotics.irlbots.screens

import android.content.Context
import android.content.Context.AUDIO_SERVICE
import android.content.Context.VIBRATOR_SERVICE

import android.content.Intent
import android.media.AudioManager
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.NavHostController
import com.sbrobotics.irlbots.NavRoutes


@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun Home(navController: NavHostController) {

    var userName by remember { mutableStateOf("") }
    val onUserNameChange = { text : String ->
        userName = text
    }

    // on below line we are creating variable for
    // text view, image button and audio maneager.
    lateinit var currentModeTV: TextView
    lateinit var vibrateIB: ImageButton
    lateinit var silentIB: ImageButton
    lateinit var ringerIB: ImageButton
    lateinit var audioManager: AudioManager

    // on below line we are creating an integer
    // variable to get the curren audio mode.
    var currentAudioMode = 0

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CustomTextField(
                title = "Enter your name",
                textState = userName,
                onTextChange = onUserNameChange
            )

            Spacer(modifier = Modifier.size(30.dp))

/*            Button(onClick = { }) {
                Text(text = "Register")
            }*/
            /*Button(onClick = {
                navController.navigate(NavRoutes.Welcome.route)
            }) {
                Text(text = "Register")
            }*/
            Button(onClick = {
  /*              // on below line we are initializing our audio managrr.
                val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

                // on below line we are getting our current ring tone mode.
                currentAudioMode = audioManager.ringerMode;

                // on below line we are setting text view for the current mode.
                when (currentAudioMode) {
                    // on below line we are setting text view as ringer mode for normal ringer mode.
                    AudioManager.RINGER_MODE_NORMAL -> currentModeTV.setText("Ringer Mode")

                    // on below line we are setting silent mode for current silent mode.
                    AudioManager.RINGER_MODE_SILENT -> currentModeTV.setText("Silent Mode")

                    // on below line we are setting vibrate mode for current vibrate mode.
                    AudioManager.RINGER_MODE_VIBRATE -> currentModeTV.setText("Vibrate Mode")

                    // below code will be called when the current mode is not able to detect
                    else -> currentModeTV.setText("Fail to get mode")
                }*/

      /*          val effect = VibrationEffect.startComposition()
                    .addPrimitive(VibrationEffect.Composition.PRIMITIVE_SLOW_RISE, 0.5f)
                    .addPrimitive(VibrationEffect.Composition.PRIMITIVE_QUICK_FALL, 0.5f)
                    .addPrimitive(VibrationEffect.Composition.PRIMITIVE_TICK, 1.0f, 100)
                    .compose()*/



                navController.navigate(NavRoutes.Welcome.route + "/$userName")
            }) {
                Text(text = "Register")
            }

        }
    }
}

@Composable
fun CustomTextField(
    title: String,
    textState: String,
    onTextChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = textState,
        onValueChange = { onTextChange(it) },
        singleLine = true,
        label = { Text(title)},
        modifier = Modifier.padding(10.dp),
        textStyle = TextStyle(fontWeight = FontWeight.Bold,
            fontSize = 30.sp)
    )
}