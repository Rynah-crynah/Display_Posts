package ninah.example.my

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API_Client {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun <T> buildAPI_Client(apiInference: Class<T>): T{
        return retrofit.create(apiInference)
    }
}