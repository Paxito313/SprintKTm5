package com.example.sprintkt3v

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductosFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductosAdapter
    private var listaProductos: List<Zapato> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_productos, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewProductos)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = ProductosAdapter(listaProductos) { zapato ->
            mostrarDetalleZapato(zapato)
        }
        recyclerView.adapter = adapter

        return view
    }

    private fun mostrarDetalleZapato(zapato: Zapato) {
        val detalleFragment = DetalleZapatoFragment.newInstance(zapato)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detalleFragment)
            .addToBackStack(null)
            .commit()
    }

}
