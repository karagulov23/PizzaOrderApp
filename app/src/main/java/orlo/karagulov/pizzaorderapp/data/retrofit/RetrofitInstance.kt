package orlo.karagulov.foodorderapp.data.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val logger = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client = OkHttpClient.Builder()
        .addInterceptor(logger)
        .build()

    val PizzaApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://private-anon-eb93878302-pizzaapp.apiary-mock.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PizzaApi::class.java)
    }

}