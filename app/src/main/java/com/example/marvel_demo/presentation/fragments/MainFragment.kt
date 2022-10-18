package com.example.marvel_demo.presentation.fragments

import com.example.marvel_demo.presentation.Adapter.Adapter
import android.os.Bundle
import com.example.marvel_demo.data.ModelClasses.ListModelClass
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProviders
import com.example.marvel_demo.data.ModelClasses.DataModelClass
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.marvel_demo.R
import com.example.marvel_demo.data.dataSource.local.LocalDataSource
import com.example.marvel_demo.data.dataSource.remote.RemoteDataSource
import com.example.marvel_demo.data.repository.Repository
import com.example.marvel_demo.presentation.viewModels.MarvelViewModel
import com.example.marvel_demo.presentation.viewModels.MyViewModelFactory

class MainFragment : Fragment() {
    var imageView: ImageView? = null
    var resultsList: List<ListModelClass>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModelFactory: MyViewModelFactory
        val remoteDataSource = RemoteDataSource()
        val localDataSource = LocalDataSource(context!!)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        imageView = view.findViewById(R.id.imageView)
        val repository = Repository(remoteDataSource, localDataSource)
        viewModelFactory = MyViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MarvelViewModel::class.java)
        viewModel.getVolumesResponseLiveData()
            .observe(viewLifecycleOwner) { results: DataModelClass? ->
                val adapter = Adapter(context!!, results?.data?.results!!)
                results.data!!.results.also { resultsList }
                recyclerView.adapter = adapter

                adapter.setClickListener(object : Adapter.ItemClickListener {
                    override fun onItemClick(
                        view: View?,
                        position: Int,
                        data: MutableList<ListModelClass?>
                    ) {
                        val action =
                            MainFragmentDirections.actionMainFragmentToDescriptionFragment(
                                data[position]?.description
                            )
                        findNavController().navigate(action)

                    }

                })
            }
    }


}