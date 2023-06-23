package com.example.kuit_team1_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit_team1_android.databinding.FragmentMenuBinding
import com.example.kuit_team1_android.databinding.FragmentSelectedMenuBinding

class SelectedMenuFragment : Fragment() {
    lateinit var binding: FragmentSelectedMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectedMenuBinding.inflate(inflater, container, false)


        return binding.root
    }

}