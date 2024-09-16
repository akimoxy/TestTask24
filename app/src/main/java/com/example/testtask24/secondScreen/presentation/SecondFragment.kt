package com.example.testtask24.secondScreen.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtask24.databinding.FragmentSecondBinding
import com.example.testtask24.firstScreen.domain.models.CardInfo
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel <SecondFragmentViewModel>()
    private val listHistory = listOf<CardInfo>()
    private val adapterHistory: HistoryAdapter =
        HistoryAdapter(listHistory)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapterAndRecycler()
       viewModel.getState().observe(viewLifecycleOwner){
           when(it){
               is SecondFragmentState.History->{
                   adapterHistory.updateList(it.cardInfo)
                   Log.d("шшшшш",it.cardInfo.toString())
               }
               is SecondFragmentState.EmptyHistory->{

               }
           }
       }

    }
    private fun initAdapterAndRecycler(){

        binding.recyclerViewHist.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewHist.adapter = adapterHistory
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}