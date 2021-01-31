package tech.abed_murad.ahoytask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import tech.abed_murad.ahoytask.databinding.ItemWeatherForecastBinding
import tech.abed_murad.ahoytask.local.model.ForecastResponse.DayWeather

class ForecastAdapter(
    itemClickListener: RecyclerOnItemClickListener,
    dayWeatherArrayList: ArrayList<DayWeather>
) :
    RecyclerView.Adapter<ForecastAdapter.WeatherHolder>() {

    var mItemClickListener: RecyclerOnItemClickListener = itemClickListener

    private val dayWeatherList: ArrayList<DayWeather> = dayWeatherArrayList

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ForecastAdapter.WeatherHolder {
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
            binding.weatherIconIV.setImageResource(dayWeather.weather[0].main.getImageIcon())
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