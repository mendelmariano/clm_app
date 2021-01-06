package com.clml.clmaplication.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.clml.clmaplication.R
import com.clml.clmaplication.databinding.FragmentListaInicialBinding
import com.clml.clmaplication.domain.Tarefa
import com.clml.clmaplication.viewmodel.ApiViewModel


class ListaInicial : Fragment() {
    // TODO: Rename and change types of parameters

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

        // Inflate the layout for this fragment
        return binding.root
    }

    fun mostrarResultadoAPI(lista: List<Tarefa>){
        var primeiroObjetoDalista = lista.first()
        var str = "id: ${primeiroObjetoDalista.id} titulo: ${primeiroObjetoDalista.title}"

        Toast.makeText(context, "testeeee", Toast.LENGTH_LONG).show()
    }
     suspend fun chamarAPI(){
        viewModel.chamarAPI()
    }


}