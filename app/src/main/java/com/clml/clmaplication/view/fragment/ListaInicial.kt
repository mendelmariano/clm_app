package com.clml.clmaplication.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clml.clmaplication.R
import com.clml.clmaplication.databinding.FragmentListaInicialBinding


class ListaInicial : Fragment() {
    // TODO: Rename and change types of parameters

    private  lateinit var binding: FragmentListaInicialBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListaInicialBinding.inflate(inflater, container, false)
        binding.meuFragmento = this
        binding.lifecycleOwner = this

        //binding.btChamarAPI.setOnClickListener { chamarAPI() }

        // Inflate the layout for this fragment
        return binding.root
    }

    fun chamarAPI(){
        //TODO: CHAMAR A API WEB ATRAVES DA VIEWMODEL
    }


}