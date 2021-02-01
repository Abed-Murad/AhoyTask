package tech.abed_murad.ahoytask.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import tech.abed_murad.ahoytask.R
import tech.abed_murad.ahoytask.databinding.ItemWeatherForecastBinding
import tech.abed_murad.ahoytask.util.getDay
import tech.abed_murad.ahoytask.util.getWeatherIcon
import tech.abed_murad.local.model.ForecastResponse.DayWeather

class ForecastAdapter(itemClickListener: RecyclerOnItemClickListener, dayWeatherArrayList: List<DayWeather>) : RecyclerView.Adapter<ForecastAdapter.WeatherHolder>() {

    var mItemClickListener: RecyclerOnItemClickListener = itemClickListener

    private val dayWeatherList: List<DayWeather> = dayWeatherArrayList

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherHolder {
        val inflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding =
            DataBindingUtil.inflate<ItemWeatherForecastBinding>(
                inflater,
                R.layout.item_weather_forecast,
                parent,
                false
            )
        return WeatherHolder(binding)
    }


    override fun getItemCount() = dayWeatherList.size


    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.bind(dayWeatherList[position])
    }

    inner class WeatherHolder(private val binding: ItemWeatherForecastBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        private var mDayWeather: DayWeather? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(dayWeather: DayWeather) {
            this.mDayWeather = dayWeather
            binding.today = dayWeather
            binding.weatherIconIV.setImageResource(dayWeather.weather[0].main.getWeatherIcon())
            binding.dateTV.text = dayWeather.dt.getDay()
            binding.executePendingBindings()
        }

        override fun onClick(v: View?) {
            mItemClickListener.onItemClick(mDayWeather!!)
            notifyDataSetChanged()
        }
    }


    interface RecyclerOnItemClickListener {
        fun onItemClick(selectedDay: DayWeather)
    }


}