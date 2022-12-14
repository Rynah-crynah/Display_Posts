package ninah.example.my

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ninah.example.my.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchPosts()
    }
    fun fetchPosts(){
        val apiClient = API_Client.buildAPI_Client(ApiInterface:: class.java)
        val request = apiClient.getPosts()

        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if(response.isSuccessful){
                    var posts = response.body()
                    Toast.makeText(baseContext, "fetched ${posts!!.size} posts", Toast.LENGTH_LONG).show()

                    binding.rvDisplay.layoutManager=LinearLayoutManager(baseContext)
                    binding.rvDisplay.adapter=displaypostsRvAdapter(posts)
//                    var displayPostsRvAdapter = displaypostsRvAdapter(baseContext,posts)
//                    Log.d("Tag",posts.toString())
//                    binding.rvDisplay.layoutManager = LinearLayoutManager(baseContext)
//                    binding.rvDisplay.adapter = displayPostsRvAdapter
                }

            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {


            }
        })
    }
}