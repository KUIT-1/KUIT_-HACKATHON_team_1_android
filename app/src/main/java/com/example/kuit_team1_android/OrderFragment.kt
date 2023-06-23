package com.example.kuit_team1_android

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit_team1_android.databinding.FragmentOrderBinding
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentOrderBinding
    private var param1: String? = null
    private var param2: String? = null
    var menuList : ArrayList<HomeItem> = arrayListOf()
    var pagerHandler = Handler(Looper.getMainLooper())

    private val categoyList = listOf<String>("전체 메뉴","나만의 메뉴")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        binding.webtoonBannerVp.adapter = bannerAdapter
//        binding.webtoonBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        menuList.add(HomeItem(R.drawable.img,"아메리카노","달달구리",1))
        val starbucksMenuAdapter = starbucksMenuVPAdapter(this)
        binding.starbucksMenuListVp.adapter = starbucksMenuAdapter
        TabLayoutMediator(binding.starbucksCategoryTb,binding.starbucksMenuListVp){
                tab,pos ->
            tab.text = categoyList[pos]
        }.attach()

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OrderFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}