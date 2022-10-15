package com.example.hammersystemtest.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hammersystemtest.App
import com.example.hammersystemtest.R
import com.example.hammersystemtest.ui.adapters.CategoryRecyclerViewAdapter
import com.example.hammersystemtest.ui.adapters.ProductsRecyclerViewAdapter
import com.example.hammersystemtest.databinding.FragmentHomeBinding
import com.example.hammersystemtest.utils.ResultState
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelProvider: HomeViewModelProvider
    lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapterCategory: CategoryRecyclerViewAdapter
    private lateinit var adapterProduct: ProductsRecyclerViewAdapter

    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelProvider)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createAdapterCategory()
        createAdapterProduct()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun createAdapterCategory() {
        adapterCategory = CategoryRecyclerViewAdapter()
        binding.apply {
            listCategory.adapter = adapterCategory
            listCategory.addItemDecoration(
                DividerItemDecoration(requireContext(), LinearLayoutManager.HORIZONTAL)
                    .apply {
                        setDrawable(resources.getDrawable(R.drawable.decorator_vertical))
                    }
            )
        }

        observeCategory()
    }

    private fun observeCategory() {
        val list = listOf("Пицца", "Комбо", "Десерты", "Напитки", "Снэки")
        adapterCategory.setList(list)
    }

    private fun createAdapterProduct() {
        adapterProduct = ProductsRecyclerViewAdapter()
        binding.listProducts.adapter = adapterProduct
        observeProduct()
    }

    private fun observeProduct() {
        viewModel.dataNetwork.observe(viewLifecycleOwner) {
            when (it) {
                is ResultState.Loading -> {
                    binding.progressCircular.visibility = View.VISIBLE
                }
                is ResultState.Success -> {
                    binding.apply {
                        progressCircular.visibility = View.GONE
                        listProducts.visibility = View.VISIBLE
                    }
                    adapterProduct.setData(it.data)
                }
                is ResultState.Error -> {
                    binding.progressCircular.visibility = View.GONE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}