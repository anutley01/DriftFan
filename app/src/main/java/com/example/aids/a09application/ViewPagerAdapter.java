package com.example.aids.a09application;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Aids on 26/07/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
    private String[] texts= {"DRIFT TALK … WITH MATT CARTER", "DRIFT TALK … WITH JACK SHANAHAN","DRIFT TALK … WITH ALAN HYNES","WESTLAKE TYRES PARTNER THE BDC"};
    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        TextView tv= (TextView) view.findViewById(R.id.myImageViewText);
        imageView.setImageResource(images[position]);

        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < texts.length; i++) {
            strBuilder.append(texts[i]);
        }
        String newString = strBuilder.toString();

        Spannable span = new SpannableString(newString);
        span.setSpan(new BackgroundColorSpan( Color.BLACK), 0, tv.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(span);
        tv.setText(texts[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager)container;
        View view = (View) object;
        vp.removeView(view);



    }
}





