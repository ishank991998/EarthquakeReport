package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ishan123 on 18-02-2018.
 */

public class DataClassAdapter extends ArrayAdapter<DataClass> {
    public DataClassAdapter(Context context, ArrayList<DataClass> data){
        super(context,0,data);
    }

    String mUrl;


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        DataClass dataClass = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.word_list,parent,false);
        }

        TextView mMag = (TextView) convertView.findViewById(R.id.magLayout);
        double output = dataClass.getMag();
        DecimalFormat formatter = new DecimalFormat("0.0");
        String magnitude = formatter.format(output);

        TextView magnitudeView = (TextView)convertView.findViewById(R.id.magLayout);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(dataClass.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        mMag.setText(magnitude);

        String primaryString = dataClass.getCity();
        int index  = primaryString.indexOf("of");

        if (index != -1) {
            String offset = primaryString.substring(index + 2);
            TextView mOffset = (TextView) convertView.findViewById(R.id.offsetLayout);

            String primary = primaryString.substring(0, index + 2);
            TextView mCity = (TextView) convertView.findViewById(R.id.primaryLayout);
            mOffset.setText(primary);
            mCity.setText(offset);
        }
        else{
            TextView mOffset = (TextView) convertView.findViewById(R.id.offsetLayout);

            TextView mCity = (TextView) convertView.findViewById(R.id.primaryLayout);
            mOffset.setText(R.string.near_the);
            mCity.setText(primaryString);
        }

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(dataClass.getTime());

       // Find the TextView with view ID date
        TextView dateView = (TextView) convertView.findViewById(R.id.dateLayout);

        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        // Format the time string (i.e. "4:30PM")
        TextView timeView = (TextView) convertView.findViewById(R.id.timeLayout);
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);
        //mTime.setText(dataClass.getTime());

        return convertView;
    }

    private int getMagnitudeColor(double mag) {
        int color;
        int magnitiude = (int) Math.floor(mag);
        switch (magnitiude){
            case 1:
                color = R.color.magnitude1;
                break;

            case 2:
                color = R.color.magnitude2;
                break;

            case 3:
                color = R.color.magnitude3;
                break;

            case 4:
                color = R.color.magnitude4;
                break;

            case 5:
                color = R.color.magnitude5;
                break;

            case 6:
                color = R.color.magnitude6;
                break;

            case 7:
                color = R.color.magnitude7;
                break;

            case 8:
                color = R.color.magnitude8;
                break;

            case 9:
                color = R.color.magnitude9;
                break;

            default:
                color = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(),color);
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    public String Url(String url){
        this.mUrl = url;
        return mUrl;
    }
}
