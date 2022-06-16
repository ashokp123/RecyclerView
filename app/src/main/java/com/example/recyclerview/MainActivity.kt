package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var adapter: CustomAdapter
    lateinit var recyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){

        // getting the recyclerview by its id
        recyclerview = findViewById(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        /*for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.app_logo, "Item " + i))
        }*/

        data.add(ItemsViewModel(R.drawable.app_logo, resources.getString(R.string.n_height),resources.getString(R.string.n_full_vehicle_height),0))
        data.add(ItemsViewModel(R.drawable.app_logo, resources.getString(R.string.n_lenght),resources.getString(R.string.n_full_vehicle_lenght),0))
        data.add(ItemsViewModel(R.drawable.app_logo, resources.getString(R.string.n_maximum_axle),resources.getString(R.string.n_info),0))
        data.add(ItemsViewModel(R.drawable.app_logo, resources.getString(R.string.n_width),resources.getString(R.string.n_full_vehicle_width),0))
        data.add(ItemsViewModel(R.drawable.app_logo, resources.getString(R.string.n_current_weight),resources.getString(R.string.n_current_weight_of_vehicle),0))
        data.add(ItemsViewModel(R.drawable.app_logo, resources.getString(R.string.n_axel_maximum_weight),resources.getString(R.string.n_info,),0))
        data.add(ItemsViewModel(R.drawable.app_logo, resources.getString(R.string.n_number_of_trailers),resources.getString(R.string.n_total_number_of_trailers_added),0))
        data.add(ItemsViewModel(R.drawable.app_logo, resources.getString(R.string.n_number_of_axles),resources.getString(R.string.n_info),0))
        data.add(ItemsViewModel(R.drawable.app_logo, resources.getString(R.string.n_hazardous_load),resources.getString(R.string.n_explosive),0))
        data.add(ItemsViewModel(R.drawable.app_logo, resources.getString(R.string.n_tunnel_restrictions),resources.getString(R.string.n_off),0))
        data.add(ItemsViewModel(R.drawable.app_logo, resources.getString(R.string.n_bk_roads),resources.getString(R.string.n_off),0))

        // This will pass the ArrayList to our Adapter
        adapter = CustomAdapter(data)
        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }
}