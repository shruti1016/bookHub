package com.internshala.bookhub.fragment

import android.app.AlertDialog
import android.app.VoiceInteractor
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.internshala.bookhub.R
import com.internshala.bookhub.adapter.DashboardRecyclerAdapter
import com.internshala.bookhub.model.Book
import com.internshala.bookhub.util.ConnectionManager
import com.android.volley.Response as Response1


class DashboardFragment : Fragment() {

    lateinit var recyclerDashboard: RecyclerView


    val bookList = arrayListOf<String>(" In Search of Lost Time",
            " One Hundred Years of Solitude",
            "Ulysses",
            "Don Quixote",
            "The Great Gatsby",
            "Moby Dick",
            "War and Peace",
            "Hamlet",
            "The Odyssey",
            "Madame Bovary")


    lateinit var recyclerAdapter: DashboardRecyclerAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var btnCheckInternet : Button

    val bookInfoList = arrayListOf<Book>(
            Book("In Search of Lost Time", "Marcel Proust", "Rs299", "4.5", R.drawable.in_search_of_lost_time),
            Book("One Hundred Years of Solitude","Gabriel Garcia Marquez", "Rs199", "3.6", R.drawable.one_hundred_years_of_soltitude),
            Book("Ulysses","James Joyce", "Rs599", "4.9",R.drawable.ulysses),
            Book("Don Quixote","Miguel de Cervantes","Rs259","3.7",R.drawable.don_quixote),
            Book("The Great Gatsby","F. Scott Fitzgerald","Rs379", "3.9",R.drawable.the_great_gatsby),
            Book("Moby Dick","Herman Melville","Rs199","3.1",R.drawable.moby_dick),
            Book("War and Peace","Leo Tolstoy","Rs329","3.0",R.drawable.war_and_peace),
            Book("Hamlet","William Shakespeare","Rs479","3.4",R.drawable.hamlet),
            Book("The Odyssey","Homer","Rs 579","4.1",R.drawable.the_odyssey),
            Book("Madame Bovary","Gustave Flaubert","Rs539","4.3",R.drawable.madame_bovary),


    )


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        recyclerDashboard = view.findViewById(R.id.recyclerDashboard)
        btnCheckInternet = view.findViewById(R.id.btnCheckInternet)

        btnCheckInternet.setOnClickListener {
            if (ConnectionManager().checkConnectivity(activity as Context)){
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Success")
                dialog.setMessage("Internet Connection Found")
                dialog.setPositiveButton("Ok"){text, listner -> }
                dialog.setNegativeButton("Cancel"){text, listener ->}
                dialog.create()
                dialog.show()
            }else{
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Error")
                dialog.setMessage("Internet Connection not Found")
                dialog.setPositiveButton("Ok"){text, listner -> }
                dialog.setNegativeButton("Cancel"){text, listener ->}
                dialog.create()
                dialog.show()

            }
        }
        layoutManager = LinearLayoutManager(activity)
        recyclerAdapter = DashboardRecyclerAdapter(activity as Context, bookInfoList)
        recyclerDashboard.adapter = recyclerAdapter
        recyclerDashboard.layoutManager = layoutManager
        recyclerDashboard.addItemDecoration(DividerItemDecoration(recyclerDashboard.context, (layoutManager as LinearLayoutManager).orientation))
        val queue = Volley.newRequestQueue(activity as Context)
        
        return view
    }

}