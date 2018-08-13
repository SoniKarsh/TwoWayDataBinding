package restaurant.sa.com.twowaydatabinding.datalistview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*
import restaurant.sa.com.twowaydatabinding.R
import restaurant.sa.com.twowaydatabinding.model.Data

class CustomAdapter(val context: Context, var listOfData: ArrayList<Data>): RecyclerView.Adapter<CustomAdapter.CustomView>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {
        return CustomView(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return listOfData.size
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {
        holder.firstName.text = listOfData[holder.adapterPosition].firstName
        holder.lastName.text = listOfData[holder.adapterPosition].lastName
    }

    class CustomView(view: View): RecyclerView.ViewHolder(view) {
        var firstName = view.firstName
        var lastName = view.lastName
    }

}