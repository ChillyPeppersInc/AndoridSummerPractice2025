package com.example.summerpractice2025.istok.adapters

import Teacher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.summerpractice2025.istok.R

class TeachersAdapter(
    private val teachers: List<Teacher>,
    private val onItemClick: (Teacher) -> Unit
) : RecyclerView.Adapter<TeachersAdapter.TeacherViewHolder>() {

    inner class TeacherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.teacher_image)
        val name: TextView = itemView.findViewById(R.id.teacher_name)

        fun bind(teacher: Teacher) {
            image.setImageResource(teacher.imageResId)
            name.text = teacher.name

            itemView.setOnClickListener {
                onItemClick(teacher)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_teacher, parent, false)
        return TeacherViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val teacher = teachers[position]
        holder.bind(teacher)
    }

    override fun getItemCount(): Int = teachers.size
}