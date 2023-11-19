package com.example.androidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.androidapp.databinding.FragmentSecondBinding


class Frag2: Fragment() {

    lateinit var binding: FragmentSecondBinding

    val args:Frag2Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val first_tv = view.findViewById<TextView>(R.id.name)
        val second_tv = view.findViewById<TextView>(R.id.country)
        val img = view.findViewById<ImageView>(R.id.img)

        val string1 = args.name
        val string2 = args.country
        val img1 = args.image

        first_tv.text = string1
        second_tv.text = string2
        img.setImageResource(img1)



        val button = view.findViewById<Button>(R.id.buttonTo1)
        button.setOnClickListener{ findNavController().navigate(R.id.action_secondFragment_to_firstFragment2)
        }
    }

}
