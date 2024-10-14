package com.example.sprintkt3v

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class DetalleZapatoFragment : Fragment() {

    private lateinit var zapato: Zapato
    private lateinit var mediaPlayer: MediaPlayer

    companion object {
        fun newInstance(zapato: Zapato): DetalleZapatoFragment {
            val fragment = DetalleZapatoFragment()
            val args = Bundle().apply {
                putParcelable("zapato", zapato)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detalle_zapato, container, false)

        zapato = arguments?.getParcelable("zapato") ?: throw IllegalArgumentException("Zapato no encontrado")

        val nombreZapato: TextView = view.findViewById(R.id.nombreZapatoDetalle)
        val precioZapato: TextView = view.findViewById(R.id.precioZapatoDetalle)
        val descripcionZapato: TextView = view.findViewById(R.id.descripcionZapato)
        val imagenZapato: ImageView = view.findViewById(R.id.imagenZapatoDetalle)
        val btnAgregarCarrito: Button = view.findViewById(R.id.botonAgregarCarrito)
        val btnVolver: Button = view.findViewById(R.id.botonVolver)

        nombreZapato.text = zapato.nombre
        precioZapato.text = "$${zapato.precio}"
        descripcionZapato.text = zapato.descripcion

        Glide.with(this).load(zapato.imagenUrl).into(imagenZapato)

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.cluclu)

        btnAgregarCarrito.setOnClickListener {
            Carrito.agregarProducto(zapato)
            mediaPlayer.start()
            Toast.makeText(requireContext(), "${zapato.nombre} agregado al carrito", Toast.LENGTH_SHORT).show()
        }

        btnVolver.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
