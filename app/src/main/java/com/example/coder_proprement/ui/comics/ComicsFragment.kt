package com.example.coder_proprement.ui.comics

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coder_proprement.databinding.FragmentComicsBinding
import com.example.coder_proprement.ui.recyclerviewadapters.RecyclerViewComicAdapter
import fr.iem.model.Comic

class ComicsFragment : Fragment() {

    private var _binding: FragmentComicsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var adapter: RecyclerViewComicAdapter


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentComicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val comicsViewModel =
            ViewModelProvider(this)[ComicsViewModel::class.java]

        val recycle = binding.listComic
        adapter = RecyclerViewComicAdapter(requireContext(), arrayListOf<Comic>()) {}
        recycle.adapter = adapter
        recycle.layoutManager = GridLayoutManager(this.context, 2)

        comicsViewModel.data.observe(viewLifecycleOwner) {
            adapter.updateItems(it)
            adapter.notifyDataSetChanged()
            Log.d("adapter", "Adapter notified")
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}