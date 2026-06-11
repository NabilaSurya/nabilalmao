package com.example.nabila_lmao.pertemuan_11

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nabila_lmao.databinding.ItemOnboardingBinding

class OnBoardingAdapter(
    private val items: List<OnBoardingItem>
) : RecyclerView.Adapter<OnBoardingAdapter.ViewHolder>() {

    inner class ViewHolder(
        val binding: ItemOnboardingBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        return ViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        holder.binding.imgOnboarding.setImageResource(
            items[position].image
        )

        holder.binding.tvTitle.text =
            items[position].title

        holder.binding.tvDescription.text =
            items[position].description
    }
}