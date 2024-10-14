package com.example.sprintkt3v

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

interface Producto {
    val nombre: String
    val precio: Double
    val descripcion: String
}

@Parcelize
data class Zapato(
    override val nombre: String,
    override val precio: Double,
    override val descripcion: String,
    val imagenUrl: String,
    var cantidad: Int = 1
) : Producto, Parcelable
