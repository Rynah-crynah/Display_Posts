package ninah.example.my

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ninah.example.my.databinding.ActivityCommentBinding
import ninah.example.my.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response

class Comment_Activity : AppCompatActivity() {
    var postId = 0
    lateinit var binding: ActivityCommentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPostId()
//        setupToolBar()


    }

    fun obtainPostId() {
        postId = intent.extras?.getInt("POST_ID") ?: 0

    }

    fun fetchPostId() {
        val apiClient = API_Client.buildAPI_Client(ApiInterface::class.java)
        val request = apiClient.getPostById(postId)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    var post = response.body()
                    if (post != null) {
                        binding.tvPostTitle.text = post.title
                    }
                    if (post != null) {
                        binding.tvPostBody.text = post.body
                    }
                }

            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

        })

    }

//    fun setupToolBar() {
//        setSupportActionBar(binding.toolbarComment)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//    }
}