package br.unitins.cinema.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.unitins.cinema.R
import br.unitins.cinema.adapters.AdapterListaCrudSala
import br.unitins.cinema.model.SQLiteHelperDB

class SalaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sala, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_lista_sala)
        val db = SQLiteHelperDB(view.context)
        val layoutManager = GridLayoutManager(view.context, 1)
        recyclerView!!.layoutManager = layoutManager
        recyclerView.hasFixedSize()
        val adapterSala = AdapterListaCrudSala(db.getSalas(), view.context)
        recyclerView.adapter = adapterSala

    }

}
