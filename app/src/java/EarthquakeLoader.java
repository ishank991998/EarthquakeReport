package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by ishan123 on 11-06-2018.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<DataClass>> {

    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL */
    private String mUrl;

    public EarthquakeLoader(Context context ,String url) {
        super(context);
        mUrl = url;
    }


    @Override
    protected void onStartLoading() {
        forceLoad();
        Log.v(LOG_TAG,"startLoading");
    }

    @Override
    public List<DataClass> loadInBackground() {
        // Don't perform the request if there are no URLs, or the first URL is null.
        if (mUrl == null) {
            return null;
        }

        Log.v(LOG_TAG,"loadInBackground");

        List<DataClass> result = QueryUtils.fetchEarthquakeData(mUrl);
        return result;
    }
}

