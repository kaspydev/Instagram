package hackerdudes.com.instagram.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackerdudes.instagram.R;
import com.hackerdudes.instagram.models.Notification;

import java.util.ArrayList;


public class NotificationsListAdapter extends RecyclerView.Adapter<NotificationsListAdapter.ViewHolder> {

    private ArrayList<Notification> notifications;

    public NotificationsListAdapter(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setItem(Notification notification, int position) {
            TextView txtSummary = (TextView) itemView.findViewById(R.id.txtSummary);
            ImageButton btnAction = null;
            String text = "";

            if (position == 0) {
                text = "<font color='#004e83'>@hans</font> kjdskjdsjksd <font color='#cccbcd'>10h</font>";
                btnAction = (ImageButton) itemView.findViewById(R.id.btnPost);
            } else if (position == 1) {
                ((ImageView) itemView.findViewById(R.id.imgUser)).setImageResource(R.drawable.user2);
                text = "<font color='#004e83'>@luis</font> kjdjksdjksd <font color='#cccbcd'>23h</font>";
                btnAction = (ImageButton) itemView.findViewById(R.id.btnFollow);
            } else {
                ((ImageView) itemView.findViewById(R.id.imgUser)).setImageResource(R.drawable.user3);
                text = "<font color='#004e83'>@alvaro</font>jkdsjksdjkds <font color='#cccbcd'>5h</font>";
                btnAction = (ImageButton) itemView.findViewById(R.id.btnFollowing);
            }

            btnAction.setVisibility(View.VISIBLE);
            txtSummary.setText(Html.fromHtml(text));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notifications_list_row, parent, false);
        return new NotificationsListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(this.notifications.get(position), position);
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return this.notifications.size();
    }
}
