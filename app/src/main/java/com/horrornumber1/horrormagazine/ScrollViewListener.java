package com.horrornumber1.horrormagazine;

import com.horrornumber1.horrormagazine.Widget.ScrollViewExt;

/**
 * Created by KIMTAEHO on 2017-01-22.
 */

public interface ScrollViewListener {
    void onScrollChanged(ScrollViewExt scrollView,
                         int x, int y, int oldx, int oldy);
}
