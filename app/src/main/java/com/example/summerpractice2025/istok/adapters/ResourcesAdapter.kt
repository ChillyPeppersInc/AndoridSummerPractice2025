package com.example.summerpractice2025.istok.adapters

import EducationalResource
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.summerpractice2025.istok.R

class ResourcesAdapter(
    private val resources: List<EducationalResource>,
    private val onItemClick: (EducationalResource) -> Unit
) : RecyclerView.Adapter<ResourcesAdapter.ResourceViewHolder>() {

    inner class ResourceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.resource_image)
        val title: TextView = itemView.findViewById(R.id.resource_title)

        fun bind(resource: EducationalResource) {
            image.setImageResource(resource.imageResId)
            title.text = resource.title

            itemView.setOnClickListener {
                onItemClick(resource)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_resource, parent, false)
        return ResourceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResourceViewHolder, position: Int) {
        val resource = resources[position]
        holder.bind(resource)
    }

    override fun getItemCount(): Int = resources.size
}