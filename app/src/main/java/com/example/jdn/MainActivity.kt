package com.example.jdn

import android.content.Context
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jdn.ui.theme.JDNTheme

var mediaplayer: MediaPlayer? = null
var sensorManager: SensorManager? = null
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JDNTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Juego()
                    agitaCristales(this, sensorManager)
                }
            }
        }
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onResume() {
        super.onResume()

    }
}

@Composable
fun Juego(modifier: Modifier = Modifier) {
    var contexto = LocalContext.current
    Column(modifier.fillMaxSize()) {
        Row (
            modifier
                .fillMaxSize()
                .weight(1f)) {
            Column (horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)){
                Image(painterResource(id = R.drawable.gallina),
                    contentDescription = "gallina",
                    modifier = modifier
                        .clickable {
                            mediaplayer = sonidoAnimal(idSonido = 1, contexto)
                            mediaplayer!!.start()
                        })
                Text(text = "Gallina", fontSize = 20.sp)
            }
            Column (horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)) {
                Image(painterResource(id = R.drawable.oveja),
                    contentDescription = "gallina",
                    modifier = modifier
                        .clickable {
                            mediaplayer = sonidoAnimal(idSonido = 2, contexto)
                            mediaplayer!!.start()
                        })
                Text(text = "Oveja", fontSize = 20.sp)
            }
        }
        Row (
            modifier
                .fillMaxSize()
                .weight(1f)){
            Column (horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)){
                Image(painterResource(id = R.drawable.patocua),
                    contentDescription = "gallina",
                    modifier = modifier
                        .clickable {
                            mediaplayer = sonidoAnimal(idSonido = 3, contexto)
                            mediaplayer!!.start()
                        })
                Text(text = "Pato", fontSize = 20.sp)
            }
            Column (horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)){
                Image(painterResource(id = R.drawable.vaca),
                    contentDescription = "gallina",
                    modifier = modifier
                        .clickable {
                            mediaplayer = sonidoAnimal(idSonido = 4, contexto)
                            mediaplayer!!.start()
                        })
                Text(text = "Vaca", fontSize = 20.sp)
            }
        }
        Row (
            modifier
                .fillMaxSize()
                .weight(1f)){
            Column (horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)){
                Image(painterResource(id = R.drawable.caballo_homosexual_de_las_montanyas),
                    contentDescription = "gallina",
                    modifier = modifier
                        .clickable {
                            mediaplayer = sonidoAnimal(idSonido = 5, contexto)
                            mediaplayer!!.start()
                        })
                Text(text = "Caballo", fontSize = 20.sp)
            }
            Column (horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)){
                Image(painterResource(id = R.drawable.pezmiguel),
                    contentDescription = "gallina",
                    modifier = modifier
                        .clickable {
                            mediaplayer = sonidoAnimal(idSonido = 6, contexto)
                            mediaplayer!!.start()
                        })
                Text(text = "Pez", fontSize = 20.sp)
            }
        }
    }
}
fun agitaCristales(context: Context, sensorManager: SensorManager?) {
    //sensor de aceleracion
    val sensor = com.example.jdn.sensorManager?.getDefaultSensor(android.hardware.Sensor.TYPE_ACCELEROMETER)
    //listener del sensor
    com.example.jdn.sensorManager?.registerListener(
        object : android.hardware.SensorEventListener {
            //si se agita el movil, reproducir sonido de cristales
            override fun onSensorChanged(event: android.hardware.SensorEvent?) {
                if (event != null) {
                    if (event.values[0] > 24 || event.values[1] > 24 || event.values[2] > 24) {
                        mediaplayer = MediaPlayer.create(context, R.raw.cristasles_rotos)
                        mediaplayer?.start()
                    }
                }
            }
            //no se usa
            override fun onAccuracyChanged(sensor: android.hardware.Sensor?, accuracy: Int) {
            }
        },
        sensor,
        android.hardware.SensorManager.SENSOR_DELAY_NORMAL
    )
}

fun sonidoAnimal(idSonido: Int, contexto: Context): MediaPlayer? {
    var mediaplayer: MediaPlayer? = null
    when (idSonido) {
        1 -> mediaplayer = MediaPlayer.create(contexto, R.raw.cacareo_gallina)
        2 -> mediaplayer = MediaPlayer.create(contexto, R.raw.balido_oveja)
        3 -> mediaplayer = MediaPlayer.create(contexto, R.raw.cuack_pato)
        4 -> mediaplayer = MediaPlayer.create(contexto, R.raw.mugido_vaca)
        5 -> mediaplayer = MediaPlayer.create(contexto, R.raw.relicho_caballo)
        6 -> mediaplayer = MediaPlayer.create(contexto, R.raw.miguemamawebo_mp3)
    }
    return mediaplayer
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JDNTheme {
        Juego()
    }
}

