package ninah.example.my

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>
}


