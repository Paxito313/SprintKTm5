package com.example.sprintkt3v


object Carrito {
    private val productos = mutableListOf<Zapato>()

    fun agregarProducto(producto: Zapato) {
        productos.add(producto)
    }

    fun obtenerProductos(): List<Zapato> {
        return productos
    }

    fun vaciarCarrito() {
        productos.clear()
    }
}
