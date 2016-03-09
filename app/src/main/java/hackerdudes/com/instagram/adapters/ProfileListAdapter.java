package hackerdudes.com.instagram.adapters;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hackerdudes.instagram.R;


public class ProfileListAdapter extends RecyclerView.Adapter<ProfileListAdapter.ViewHolder> {

    public static final int HEADER_ROW = 0;
    public static final int TABS_ROW = 1;
    public static final int POSTS_ROW = 2;

    private Context context;

    private TabLayout.OnTabSelectedListener onTabSelectedListener;
    private View.OnClickListener onClickListener;

    public ProfileListAdapter(Context context, TabLayout.OnTabSelectedListener onTabSelectedListener,
                              View.OnClickListener onClickListener) {
        this.context = context;
        this.onTabSelectedListener = onTabSelectedListener;
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        boolean isGrid = (((RecyclerView) parent).getLayoutManager() instanceof GridLayoutManager);

        if (viewType == HEADER_ROW)
            view = LayoutInflater.from(context).inflate(R.layout.profile_list_header, parent, false);
        else if (viewType == TABS_ROW)
            view = LayoutInflater.from(context).inflate(R.layout.profile_list_tabs, parent, false);
        else if (viewType == POSTS_ROW && isGrid)
            view = LayoutInflater.from(context).inflate(R.layout.profile_list_posts, parent, false);
        else if (viewType == POSTS_ROW && !isGrid)
            view = LayoutInflater.from(context).inflate(R.layout.feed_list_row, parent, false);

        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (position == TABS_ROW) {
            if (holder.tabs.getTabCount() == 0) {
                holder.tabs.addTab(holder.tabs.newTab().setIcon(R.drawable.grid_icon));
                holder.tabs.addTab(holder.tabs.newTab().setIcon(R.drawable.list_icon));
                holder.tabs.addTab(holder.tabs.newTab().setIcon(R.drawable.location_icon));
                holder.tabs.addTab(holder.tabs.newTab().setIcon(R.drawable.tagger_icon));

                holder.tabs.setOnTabSelectedListener(this.onTabSelectedListener);
            }
        }

        if (position == HEADER_ROW) {


            holder.llPosts.setOnClickListener(this.onClickListener);
            holder.llFollowers.setOnClickListener(this.onClickListener);
            holder.llFollowings.setOnClickListener(this.onClickListener);
//            holder.llPosts.getParent().
        }
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == HEADER_ROW) return HEADER_ROW;
        else if (position == TABS_ROW) return TABS_ROW;
        else return POSTS_ROW;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ViewPager viewPager;
        TabLayout tabs;

        LinearLayout llPosts;
        LinearLayout llFollowers;
        LinearLayout llFollowings;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);

            if (viewType == TABS_ROW)
                tabs = (TabLayout) itemView.findViewById(R.id.tabs);

            if (viewType == HEADER_ROW) {
                llPosts = (LinearLayout) itemView.findViewById(R.id.llPosts);

                llPosts.setTag(R.id.tagProfile, "posts");
                llFollowers = (LinearLayout) itemView.findViewById(R.id.llFollowers);
                llFollowers.setTag(R.id.tagProfile, "followers");
                llFollowings = (LinearLayout) itemView.findViewById(R.id.llFollowings);
                llFollowings.setTag(R.id.tagProfile, "followings");
            }
        }
    }
}
