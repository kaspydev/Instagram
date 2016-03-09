package hackerdudes.com.instagram.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int spanCount;
    private int spacing;
    private int offset;

    public GridSpacingItemDecoration(int spanCount, int spacing, int offset) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.offset = offset;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);

        int tempPosition = position - offset;

        int column = tempPosition % spanCount;

        if (tempPosition >= 0) {
            outRect.left = column * spacing / spanCount;

            outRect.right = spacing - (column + 1) * spacing / spanCount;

            if (position >= offset + spanCount)
                outRect.top = spacing;
        }
    }
}
