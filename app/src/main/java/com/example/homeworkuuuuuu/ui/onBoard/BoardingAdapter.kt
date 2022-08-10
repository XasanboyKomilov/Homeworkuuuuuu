package com.example.homeworkuuuuuu.ui.onBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkuuuuuu.R
import com.example.homeworkuuuuuu.databinding.ItemBoardingBinding
import com.example.homeworkuuuuuu.models.Board

class BoardingAdapter(private val onStartClick: () -> Unit) :
    RecyclerView.Adapter<BoardingAdapter.ViewHolder>() {

    val arrayList = arrayListOf<Board>(
        Board("", R.raw.task),
        Board("", R.raw.tasks),
        Board("", R.raw.multitasking)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = arrayList.size

    inner class ViewHolder(private val binding: ItemBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.tvTitle.text = arrayList[adapterPosition].title
            binding.lottieMain.setAnimation(arrayList[adapterPosition].lottie)
            binding.btnStart.isVisible = adapterPosition == arrayList.lastIndex
            binding.btnStart.setOnClickListener {
                onStartClick()
            }
        }
    }
}