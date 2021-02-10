package com.bt.nostecalendarview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bt.nostecalendarview.dataClass.Flight
import com.bt.nostecalendarview.databinding.ItemEventBinding
import java.time.format.DateTimeFormatter
import android.util.Log
import kotlin.random.Random

/**
 * Created by ArtemLampa on 09.02.2021.
 */
class EventsAdapter : RecyclerView.Adapter<EventsAdapter.EventsViewHolder>() {

    val flights: ArrayList<Flight>? = null
    lateinit var binding: ItemEventBinding

    private val formatter =
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            DateTimeFormatter.ofPattern("EEE'\n'dd MMM'\n'HH:mm")
        } else {
            Log.e("TAG", "sorry")
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        binding = ItemEventBinding.inflate(LayoutInflater.from(parent.context))
        return EventsViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: EventsViewHolder, position: Int) {
        viewHolder.bind(flights?.get(position))
    }

    override fun getItemCount(): Int = flights?.size ?: 4

    inner class EventsViewHolder(val binding: ItemEventBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(flight: Flight?) {
            with(binding) {
                executePendingBindings()
            }
        }
    }
}