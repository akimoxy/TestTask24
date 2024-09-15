package com.example.testtask24.firstScreen.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.testtask24.R
import com.example.testtask24.databinding.FragmentFirstBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

const val MIN_SIZE_BIN = 6
const val MAX_LENGTH_TEXT = 21

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    val viewModel by viewModel<FirstFragmentViewModel>()
    var searchNumber = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textAndClickListeners()

        viewModel.getState().observe(viewLifecycleOwner) {
            when (it) {
                is FirstFragmentState.FoundInfo -> {
                    with(binding) {
                        visibility(it.cardInfo.scheme, scheme)
                        visibility(it.cardInfo.brand, brand)
                        visibility(it.cardInfo.number?.length, length)
                        visibility(it.cardInfo.bank?.name, bankName)
                        visibility(it.cardInfo.bank?.url, bankUrl)
                        visibility(it.cardInfo.bank?.city, bankCity)
                        visibility(it.cardInfo.bank?.phone, bankPhone)
                        visibility(it.cardInfo.type, type)
                        visibility(it.cardInfo.country?.alpha2, countryAlfa2)
                        visibility(it.cardInfo.country?.name, countryName)
                        visibility(it.cardInfo.country?.latitude, countryLatitude)
                        visibility(it.cardInfo.country?.longitude, countryLongitude)
                        setTextAndVisibilityBoolean(it.cardInfo.prepaid, prepaid)
                        setTextAndVisibilityBoolean(it.cardInfo.number?.luhn, luhn)
                    }
                }

                is FirstFragmentState.Error -> {
                    toast(requireContext().getString(R.string.toast_first_fragment_error))
                }

                is FirstFragmentState.BeforeSearch -> {
                    // do some work
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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

    private fun toast(text: String) {
        Toast.makeText(
            requireContext(),
            text,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun setTextAndVisibilityBoolean(boolean: Boolean?, view: TextView) {
        if (boolean != null) {
            if (boolean == true) {
                view.text = requireContext().getString(R.string.Yes)
            } else view.text = requireContext().getString(R.string.No)
        } else view.visibility = View.GONE
    }

    private fun textAndClickListeners() {
        binding.searchTv.setOnClickListener {
            if (searchNumber.length >= MIN_SIZE_BIN) {
                viewModel.searchCardInfo(searchNumber)
            } else {
                toast(requireContext().getString(R.string.toast_min_length))
            }
        }
        binding.searchEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                searchNumber = p0.toString()
            }
        })
    }
}