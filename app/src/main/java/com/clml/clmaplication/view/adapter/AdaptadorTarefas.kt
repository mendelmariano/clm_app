package com.clml.clmaplication.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clml.clmaplication.R
import com.clml.clmaplication.databinding.ItemDeTarefaBinding
import com.clml.clmaplication.domain.Tarefa

class AdaptadorTarefas(
    val lista: List<Tarefa>
    ) : RecyclerView.Adapter<AdaptadorTarefas.GuardadorDeDadosTarefa>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuardadorDeDadosTarefa {
        val instanciaDoXML = LayoutInflater.from(parent.context).inflate(R.layout.item_de_tarefa, parent, false)
        val guardador = GuardadorDeDadosTarefa(instanciaDoXML)
        return guardador

    }

    override fun onBindViewHolder(holder: GuardadorDeDadosTarefa, position: Int) {
       val binding = holder.binding
        val t = lista[position]
        binding.tarefa = t
        binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    inner class GuardadorDeDadosTarefa(v: View) : RecyclerView.ViewHolder(v) {
        val binding: ItemDeTarefaBinding = ItemDeTarefaBinding.bind(v)


    }

}