package com.example.jdn

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorListener
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jdn.ui.theme.JDNTheme

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
                }
            }
        }
    }
}

@Composable
fun Juego(modifier: Modifier = Modifier) {
    var contexto = LocalContext.current
    var mediaplayer: MediaPlayer? = null
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

