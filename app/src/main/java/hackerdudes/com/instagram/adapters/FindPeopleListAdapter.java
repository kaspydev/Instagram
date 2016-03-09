package hackerdudes.com.instagram.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hackerdudes.instagram.R;
import com.hackerdudes.instagram.models.User;

import java.util.ArrayList;


public class FindPeopleListAdapter extends RecyclerView.Adapter<FindPeopleListAdapter.ViewHolder> {

    private ArrayList<User> users;

    public FindPeopleListAdapter(ArrayList<User> users) {
        this.users = users;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private Button btnFollowing;
        private Button btnFollow;
        private Button btnHide;

        public ViewHolder(View itemView) {
            super(itemView);

            btnFollow = (Button) itemView.findViewById(R.id.btnFollow);
            btnFollowing = (Button) itemView.findViewById(R.id.btnFollowing);
            btnHide = (Button) itemView.findViewById(R.id.btnHide);
        }

        public void setItem(User user, int position) {
            if (position % 3 == 0) {
                btnFollow.setVisibility(View.GONE);
                btnHide.setVisibility(View.GONE);
                btnFollowing.setVisibility(View.VISIBLE);
            } else {
                btnFollowing.setVisibility(View.GONE);
                btnFollow.setVisibility(View.VISIBLE);
                btnHide.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_people_list_row, parent, false);
        return new FindPeopleListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(this.users.get(position), position);
    }


    @Override
    public int getItemCount() {
        return this.users.size();
    }
}
