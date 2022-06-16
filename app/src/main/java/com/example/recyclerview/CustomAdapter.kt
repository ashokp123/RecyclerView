package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ViewDesignBinding

class CustomAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

	lateinit var mContext: Context

	// create new views
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		// inflates the card_view_design view
		// that is used to hold list item
		//val view = LayoutInflater.from(parent.context).inflate(R.layout.view_design, parent, false)
		//return ViewHolder(view)
		val binding = ViewDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		val src = ViewHolder(binding)
		mContext = parent.context
		return src
	}

	// binds the list items to a view
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {

		val ItemsViewModel = mList[position]

		if (ItemsViewModel.text.equals(mContext.resources.getString(R.string.n_height)) || ItemsViewModel.text.equals(mContext.resources.getString(R.string.n_lenght)) ||
			ItemsViewModel.text.equals(mContext.resources.getString(R.string.n_width)) || ItemsViewModel.text.equals(mContext.resources.getString(R.string.n_maximum_axle)) ||
			ItemsViewModel.text.equals(mContext.resources.getString(R.string.n_current_weight)) || ItemsViewModel.text.equals(mContext.resources.getString(R.string.n_axel_maximum_weight))){
			holder.unit_lay.visibility = View.VISIBLE
			holder.inc_dec_lay.visibility = View.GONE
			holder.nav_lay.visibility = View.GONE
		}else if (ItemsViewModel.text.equals(mContext.resources.getString(R.string.n_number_of_axles)) || ItemsViewModel.text.equals(mContext.resources.getString(R.string.n_number_of_trailers))){
			holder.unit_lay.visibility = View.GONE
			holder.inc_dec_lay.visibility = View.VISIBLE
			holder.nav_lay.visibility = View.GONE
		}else if(ItemsViewModel.text.equals(mContext.resources.getString(R.string.n_tunnel_restrictions)) || ItemsViewModel.text.equals(mContext.resources.getString(R.string.n_hazardous_load)) ||
			ItemsViewModel.text.equals(mContext.resources.getString(R.string.n_bk_roads))){
			holder.unit_lay.visibility = View.GONE
			holder.inc_dec_lay.visibility = View.GONE
			holder.nav_lay.visibility = View.VISIBLE
		}

		// sets the image to the imageview from our itemHolder class
		holder.imageView.setImageResource(ItemsViewModel.image)

		// sets the text to the textview from our itemHolder class
		holder.textView.text = ItemsViewModel.text
		holder.txtView_one.text = ItemsViewModel.textOne

        holder.img_plus.setOnClickListener(View.OnClickListener {
            ItemsViewModel.count = ItemsViewModel.count+1
            holder.txt_count.text = ItemsViewModel.count.toString()
        })

        holder.img_minus.setOnClickListener(View.OnClickListener {
            if(ItemsViewModel.count<=0){
                ItemsViewModel.count = 0
                holder.txt_count.text = ItemsViewModel.count.toString()
            }else {
                ItemsViewModel.count--
                holder.txt_count.text = ItemsViewModel.count.toString()
            }
        })

	}

	// return the number of the items in the list
	override fun getItemCount(): Int {
		return mList.size
	}

	// Holds the views for adding it to image and text
	class ViewHolder(ItemView:  ViewDesignBinding) : RecyclerView.ViewHolder(ItemView.root) {
		val imageView: ImageView = itemView.findViewById(R.id.imageview)
		val textView: TextView = itemView.findViewById(R.id.textView)
		val txtView_one: TextView = itemView.findViewById(R.id.textView_one)
		val unit_lay: LinearLayout = itemView.findViewById(R.id.unit_lay)
		val inc_dec_lay: LinearLayout = itemView.findViewById(R.id.inc_dec_lay)
		val nav_lay: LinearLayout = itemView.findViewById(R.id.nav_lay)

        val img_minus: ImageButton = itemView.findViewById(R.id.img_minus)
        var txt_count: TextView = itemView.findViewById(R.id.txt_count)
        val img_plus: ImageButton = itemView.findViewById(R.id.img_plus)

	}
}
