package com.internshala.bookhub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.internshala.bookhub.R
import com.internshala.bookhub.model.Book

class DashboardRecyclerAdapter(val context: Context, val itemList: ArrayList<Book>): RecyclerView.Adapter<DashboardRecyclerAdapter.DasboardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DasboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent, false)
        return DasboardViewHolder(view)
    }
    override fun onBindViewHolder(holder: DasboardViewHolder, position: Int) {
        val book = itemList[position]
        holder.textBookName.text = book.bookName
        holder.textBookAuthor.text = book.bookAuthor
        holder.textBookPrice.text = book.bookCost
        holder.textBookRating.text = book.bookRating
        holder.imgBookImage.setImageResource(book.bookImage)

        holder.liContent.setOnClickListener {
            Toast.makeText(context, "Clicked on ${holder.textBookName.text}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    class DasboardViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textBookName: TextView = view.findViewById(R.id.txtBookName)
        val textBookAuthor: TextView = view.findViewById(R.id.txtBookAuthor)
        val  textBookPrice: TextView = view.findViewById(R.id.txtBookPrice)
        val  textBookRating: TextView = view.findViewById(R.id.txtBookRating)
        val  imgBookImage: ImageView = view.findViewById(R.id.imgBookImage)
        val liContent: LinearLayout = view.findViewById(R.id.liContent)
    }


}