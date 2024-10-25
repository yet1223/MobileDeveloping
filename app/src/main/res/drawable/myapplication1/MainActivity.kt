package drawable.myapplication1

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication1.R
import drawable.myapplication1.Screens.MainScreen
import com.example.myapplication1.Screens.TableLayout
import drawable.myapplication1.ui.theme.MyApplication1Theme
import org.json.JSONObject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            drawable.myapplication1.ui.theme.MyApplication1Theme {
                val daysList = remember {
                    mutableStateOf(listOf<WeatherModel>())
                }
                val dialogState = remember {
                    mutableStateOf(false)
                }
                val currentDay = remember {
                    mutableStateOf(
                        WeatherModel(
                            "",
                            "",
                            "0.0",
                            "",
                            "",
                            "0.0",
                            "0.0",
                            ""
                        )
                    )
                }

                if (dialogState.value) DialogSearch(dialogState, onSubmit = {
                    getData(
                        it, this@MainActivity,
                        daysList, currentDay
                    )
                })

                getData("London", this, daysList, currentDay)

                Image(
                    painter = painterResource(
                        id = R.drawable.weather
                    ),
                    contentDescription = "image_1",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.5f),
                    contentScale = ContentScale.FillBounds
                )
                Column {
                    MainCard(currentDay,
                        onClickSync = {
                            getData(
                                "London", this@MainActivity,
                                daysList, currentDay
                            )
                        },
                        onClickSearch = {
                            dialogState.value = true
                        })
                    TabLayout(daysList, currentDay)
                }
            }
        }
    }
}


private fun getData(city: String, context: Context,
                    daysList: MutableState<List<WeatherModel>>,
                    currentDay: MutableState<WeatherModel>
) {
    val url = "https://api.weatherapi.com/v1/forecast.json" +
            "?key=$API_KEY" +
            "&q=$city" +
            "&days=3&aqi=no&alerts=no"
    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        { response ->
            val resp = String(response.toByteArray(Charsets.ISO_8859_1), Charsets.UTF_8)
            val list = getWeatherByDays(resp)
            currentDay.value = list[0]
            daysList.value = list
            Log.d("MyLog", "Response $response")
        },
        { error ->
            Log.d("MyLog", "VolleyError $error")
        }
    )
    queue.add(stringRequest)
}


private fun getWeatherByDays(response: String): List<WeatherModel> {
    if (response.isEmpty()) return listOf()

    val list = ArrayList<WeatherModel>()
    val mainObject = JSONObject(response)
    val city = mainObject.getJSONObject("location")
        .getString("name")
    val days = mainObject.getJSONObject("forecast")
        .getJSONArray("forecastday")

    for (i in 0 until days.length()) {
        val item = days[i] as JSONObject
        list.add(
            WeatherModel(
                city,
                item.getString("date"),
                "",
                item.getJSONObject("day")
                    .getJSONObject("condition")
                    .getString("text"),
                item.getJSONObject("day")
                    .getJSONObject("condition")
                    .getString("icon"),
                item.getJSONObject("day")
                    .getString("maxtemp_c")
                    .toFloat().toInt().toString() + "°C",
                item.getJSONObject("day")
                    .getString("mintemp_c")
                    .toFloat().toInt().toString() + "°C",
                item.getJSONArray("hour").toString()
            )
        )
    }
    list[0] = list[0].copy(
        time = mainObject.getJSONObject("current")
            .getString("last_updated"),
        currentTemp = mainObject.getJSONObject("current")
            .getString("temp_c")
    )
    return list
}