package com.clml.clmaplication.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.clml.clmaplication.R
import com.clml.clmaplication.databinding.FragmentListaInicialBinding
import com.clml.clmaplication.domain.Tarefa
import com.clml.clmaplication.view.adapter.AdaptadorTarefas
import com.clml.clmaplication.viewmodel.ApiViewModel


class ListaInicial : Fragment() {


    private  lateinit var binding: FragmentListaInicialBinding
    private val viewModel: ApiViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListaInicialBinding.inflate(inflater, container, false)
        binding.meuFragmento = this
        binding.lifecycleOwner = this

        //binding.btChamarAPI.setOnClickListener { chamarAPI() }

        viewModel.resultadoParaTela.observe(viewLifecycleOwner){ lista ->
            mostrarResultadoAPI(lista)
        }

        binding.rvTarefas.layoutManager = LinearLayoutManager(context)

        // Inflate the layout for this fragment
        return binding.root
    }

    fun mostrarResultadoAPI(lista: List<Tarefa>){
        val adaptador = AdaptadorTarefas(lista)

        binding.rvTarefas.adapter = adaptador

    }
     fun chamarAPI(){
         viewModel.chamarAPI()
    }


}