package com.horrornumber1.horrordepartment.Module;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.horrornumber1.horrordepartment.R;

import java.util.HashMap;

/**
 * Created by 이승헌 on 2017-07-12.
 */
public class ApplicationController extends Application {
    private static final String PROPERTY_ID = "UA-102394902-1";

    public enum TrackerName{
        APP_TRACKER,
        GLOBAL_TRACKER,
        ECOMMERCE_TRACKER,
    }

    HashMap<TrackerName, Tracker> mTrackers = new HashMap<TrackerName, Tracker>();

    synchronized  public Tracker getTracker(TrackerName trackerId){
        if(!mTrackers.containsKey(trackerId)){
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            Tracker t = (trackerId == TrackerName.APP_TRACKER) ? analytics.newTracker(PROPERTY_ID):
                    (trackerId == TrackerName.GLOBAL_TRACKER) ? analytics.newTracker(R.xml.global_tracker):
                            analytics.newTracker(R.xml.ecommerse_tracker);
            mTrackers.put(trackerId, t);
        }
        return mTrackers.get(trackerId);
    }
}
