package com.horrornumber1.horrordepartment;

import com.horrornumber1.horrordepartment.Widget.ScrollViewExt;


public interface ScrollViewListener {
    void onScrollChanged(ScrollViewExt scrollView,
                         int x, int y, int oldx, int oldy);
}
