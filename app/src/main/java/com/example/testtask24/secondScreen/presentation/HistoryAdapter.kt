package com.example.testtask24.secondScreen.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask24.R
import com.example.testtask24.databinding.CardItemHistBinding
import com.example.testtask24.databinding.FragmentSecondBinding
import com.example.testtask24.firstScreen.domain.models.CardInfo
import com.example.testtask24.firstScreen.presentation.MAX_LENGTH_TEXT

class HistoryAdapter(
    private var list: List<CardInfo>
) : RecyclerView.Adapter<HistoryAdapter.SearchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardItemHistBinding.inflate(inflater, parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(list[position])

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<CardInfo>) {
        list = newList
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class SearchViewHolder(private val binding: CardItemHistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CardInfo) {
            visibility(item.scheme, binding.schemeItem)
            visibility(item.bank?.url, binding.bankUrlItem)
            visibility(item.bank?.name, binding.bankNameItem)
            visibility(item.bank?.city, binding.bankCityItem)
            visibility(item.type, binding.typeItem)
            visibility(item.number?.length, binding.lengthItem)
            visibility(item.number?.luhn, binding.luhnItem)
            visibility(item.brand, binding.brandItem)
            visibility(item.country?.name, binding.countryNameItem)
            visibility(item.country?.alpha2, binding.countryAlfa2Item)
            visibility(item.country?.latitude, binding.countryLatitudeItem)
            visibility(item.country?.longitude, binding.countryLongitudeItem)
            visibility(item.prepaid, binding.prepaidItem)
        }

    }
    private fun <T> visibility(some: T, view: View) {
        if (some == null) {
            view.isVisible = false
        } else {
            view.isVisible = true
            val text = some.toString()
            if (text.length >= MAX_LENGTH_TEXT) {
                (view as TextView).text = text.substring(0, MAX_LENGTH_TEXT) + "..."
            } else (view as TextView).text = text
        }
    }
}