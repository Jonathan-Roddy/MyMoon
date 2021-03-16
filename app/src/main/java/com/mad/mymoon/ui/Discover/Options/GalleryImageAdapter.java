package com.mad.mymoon.ui.Discover.Options;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.mad.mymoon.R;

public class GalleryImageAdapter extends BaseAdapter{
    private Context mContext;

    public GalleryImageAdapter(Context context)
    {
        mContext = context;
    }

    public int getCount() {
        return mImageIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }


    // Override this method according to your need
    public View getView(int index, View view, ViewGroup viewGroup)
    {
        // TODO Auto-generated method stub
        ImageView i = new ImageView(mContext);

        i.setImageResource(mImageIds[index]);
        i.setLayoutParams(new Gallery.LayoutParams(200, 200));

        i.setScaleType(ImageView.ScaleType.FIT_XY);

        return i;
    }

    public Integer[] mImageIds = {
            R.drawable.a_moon_earthside_map,
            R.drawable.a_moon_farside_map,
            R.drawable.a_moon_polar_map,
            R.drawable.red_moon,
            R.drawable.how_does_redmoon,
            R.drawable.how_eclipse_works,
            R.drawable.how_tide_works,
            R.drawable.moonflag,
            R.drawable.moonmission,
            R.drawable.moon_northsouth,
            R.drawable.moon_yopography
    };

}