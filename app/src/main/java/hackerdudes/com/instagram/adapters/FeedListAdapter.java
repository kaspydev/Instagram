package hackerdudes.com.instagram.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hackerdudes.instagram.R;
import com.hackerdudes.instagram.models.Post;

import java.util.ArrayList;


public class FeedListAdapter extends RecyclerView.Adapter<FeedListAdapter.ViewHolder> {

    private ArrayList<Post> posts;

    public FeedListAdapter(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView heart;

        public ViewHolder(View itemView) {
            super(itemView);

            heart = (ImageView) itemView.findViewById(R.id.imgHeart);

//            heart.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.i("CLICK", "hola");
//                }
//            });
        }

        public void setItem(Post post) {
//            TextView username = (TextView) itemView.findViewById(R.id.txtUsername);

            TextView comment1 = (TextView) ((LinearLayout) itemView.findViewById(R.id.txtComment1)).getChildAt(0);
            TextView comment2 = (TextView) ((LinearLayout) itemView.findViewById(R.id.txtComment2)).getChildAt(0);
            TextView comment3 = (TextView) ((LinearLayout) itemView.findViewById(R.id.txtComment3)).getChildAt(0);
//
            String text = "<font color='#004e83'>@hackspace</font> Hola Hackspace";
            String text2 = "<font color='#004e83'>@hanshavin</font> yeeeeah it's happening yeppp";
            String text3 = "<font color='#004e83'>@juliocanares</font> amiguito amiguito amiguito amiguito amiguito amiguito amiguito";

            comment1.setText(Html.fromHtml(text));

            comment2.setText(Html.fromHtml(text2));
            comment3.setText(Html.fromHtml(text3));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_list_row, parent, false);
        return new FeedListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(this.posts.get(position));
    }

    @Override
    public int getItemCount() {
        return this.posts.size();
    }
}
