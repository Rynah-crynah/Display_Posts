package ninah.example.my

import android.content.Context
import ninah.example.my.databinding.PostListItemBinding

//class displaypostsRvAdapterimport android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//import com.example.myposts.databinding.PostListItemBinding

class displaypostsRvAdapter(var context: Context, var displayPost: List<Post>) :
    RecyclerView.Adapter<RetrofitviewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitviewHolder {
        var binding = PostListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RetrofitviewHolder(binding)

    }

    override fun onBindViewHolder(holder: RetrofitviewHolder, position: Int) {
        var currentPosts =displayPost.get(position)
        with(holder.binding){
            tvUserId.text = currentPosts.userId.toString()
            tvId.text = currentPosts.id.toString()
            tvTitle.text = currentPosts.title
            tvBody.text = currentPosts.body
        }
    }

    override fun getItemCount(): Int {
        return displayPost.size
    }
}
class RetrofitviewHolder(val binding: PostListItemBinding): RecyclerView.ViewHolder(binding.root) {
}