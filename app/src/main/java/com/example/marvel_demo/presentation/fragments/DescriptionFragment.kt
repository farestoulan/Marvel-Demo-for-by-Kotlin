package com.example.marvel_demo.presentation.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.marvel_demo.R

class DescriptionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.tv_Description)

        val args: DescriptionFragmentArgs =
            DescriptionFragmentArgs.fromBundle(arguments!!)
        textView.text = args.name
    }


}