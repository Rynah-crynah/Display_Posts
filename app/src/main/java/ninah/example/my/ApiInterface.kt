package ninah.example.my

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    @GET("/posts/{postId}")
    fun getPostById(@Path("postId") postId: Int):Call<Post>


    @GET("/comments")
    fun getComment(): Call<List<Comment>>


}


