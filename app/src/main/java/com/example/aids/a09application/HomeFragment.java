package com.example.aids.a09application;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import static android.support.v4.content.ContextCompat.getDrawable;

public class HomeFragment extends Fragment {

    ViewPager viewPager;
    ViewPagerAdapter adapter;
    LinearLayout sliderDotsPanel;
    private int dotsCount;
    private ImageView[] dots;
    Drawable active_dots;
    Drawable nonactive_dots;
    TextView txtView;
    Typeface font;
    WebView webView;
    String url;
    TabLayout tabLayout;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        sliderDotsPanel = (LinearLayout) view.findViewById(R.id.SliderDots);
        active_dots = getDrawable(getActivity().getApplicationContext(), R.drawable.active_dot);
        nonactive_dots = getDrawable(getActivity().getApplicationContext(), R.drawable.nonactive_dot);

        adapter = new ViewPagerAdapter(this.getActivity());
        viewPager.setAdapter(adapter);

        dotsCount = adapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {

            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(nonactive_dots);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);
            sliderDotsPanel.addView(dots[i], params);

        }


        dots[0].setImageDrawable(active_dots);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(nonactive_dots);
                }

                dots[position].setImageDrawable(active_dots);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new myTimerTask(), 4000, 2000);
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        Fragment fragment = (fm.findFragmentById(R.id.map));
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(fragment);
        ft.commit();



}
        public class myTimerTask extends TimerTask {

        @Override
        public void run() {

            if (getActivity() == null) {
                return;

            }
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {


                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem(3);

                    }


                }


            });
        }




        }

    }











