package hackerdudes.com.instagram.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hackerdudes.instagram.R;
import com.hackerdudes.instagram.models.Post;

import java.util.ArrayList;


public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {
    private static final int VIEW_HEADER = 0;
    private static final int VIEW_ROW = 1;

    private Context context;
    private ArrayList<Post> posts;


    private View.OnClickListener onClickListener;

    public SearchListAdapter(Context context, ArrayList<Post> posts, View.OnClickListener onClickListener) {
        this.context = context;
        this.posts = posts;

        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == VIEW_HEADER)
            view = LayoutInflater.from(context).inflate(R.layout.search_list_header, parent, false);
        else if (viewType == VIEW_ROW)
            view = LayoutInflater.from(context).inflate(R.layout.search_list_row, parent, false);

        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == VIEW_HEADER) {
            holder.itemView.setOnClickListener(this.onClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return this.posts.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 0 ? VIEW_HEADER : VIEW_ROW);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPost;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);

            if (viewType == VIEW_ROW)
                imgPost = (ImageView) itemView.findViewById(R.id.imgPost);
        }
    }
}
