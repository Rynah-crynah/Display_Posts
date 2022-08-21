package ninah.example.my

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ninah.example.my.databinding.CommentsListItemBinding
import ninah.example.my.databinding.PostListItemBinding

class displaycommentsRvAdapter(var commentList: List<Comment>):
    RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding = CommentsListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment = commentList.get(position)
        with(holder.binding) {
            tvPostIdHolder.text = currentComment.postId.toString()
            tvId2.text = currentComment.id.toString()
            tvNameHolder.text = currentComment.name
            tvEmailHolder.text = currentComment.email
            tvBodyHolder.text = currentComment.body

        }

    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}
class CommentViewHolder(var binding: CommentsListItemBinding): RecyclerView.ViewHolder(binding.root)