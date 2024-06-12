package com.vimalcvs.mvp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vimalcvs.mvp.databinding.CategoryItemBinding
import com.vimalcvs.mvp.room.RoomEntity

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    var onItemClick: ((RoomEntity) -> Unit)? = null
    private var categories = listOf<RoomEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.binding.apply {
            categoryName.text = category.category_name
            radioCount.text = category.radio_count.toString()

        }
    }

    override fun getItemCount() = categories.size

    fun setCategories(categories: List<RoomEntity>) {
        this.categories = categories
        notifyDataSetChanged()
    }


    class CategoryViewHolder(val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}
