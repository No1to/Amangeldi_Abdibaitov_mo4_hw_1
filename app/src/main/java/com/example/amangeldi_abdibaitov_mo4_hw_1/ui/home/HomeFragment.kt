package com.example.amangeldi_abdibaitov_mo4_hw_1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.amangeldi_abdibaitov_mo4_hw_1.databinding.FragmentHomeBinding
import com.example.amangeldi_abdibaitov_mo4_hw_1.databinding.ItemTaskBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val taskList = arrayListOf(
        TaskModel("No1to","https://www.twitch.tv/emn1to"),
        TaskModel("","Mirrors"),
        TaskModel("url","String")
   )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val adapter = TaskAdapter(taskList)
        binding.rvTask.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    inner class TaskAdapter(private val taskList: List<TaskModel>) :
        RecyclerView.Adapter<TaskAdapter.ViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                ItemTaskBinding.inflate
                    (LayoutInflater.from(parent.context), parent, false)
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(taskList[position])
        }

        override fun getItemCount(): Int {
            return taskList.size
        }

        inner class ViewHolder(private val binding: ItemTaskBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(task: TaskModel) {
                binding.tvTitle.text = task.title
                binding.tvDescription.text = task.description

//              Glide.with(binding.imgPoster).load(music.poster).into(binding.imgPoster)
//              binding.imgPoster.loadImage(music.poster)
            }
        }
    }
}