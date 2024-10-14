package com.example.sprintkt3v

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var botonIrACarrito: Button
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonIrACarrito = findViewById(R.id.boton_ir_a_carrito)

        mediaPlayer = MediaPlayer.create(this, R.raw.fondo)
        mediaPlayer.isLooping = true
        mediaPlayer.start()


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ListaZapatosFragment())
                .commit()
        }


        botonIrACarrito.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CarritoFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }
}
