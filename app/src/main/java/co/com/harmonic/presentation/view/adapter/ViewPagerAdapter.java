package co.com.harmonic.presentation.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import co.com.harmonic.R;

/**
 * Created by Rodolhan on 16/12/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<String> listImages = new ArrayList<>();

    public ViewPagerAdapter(Context context) {
        this.context = context;
        listImages.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgreYtRdxF6slh5lGgxNlUa-uem4BW9qpEPDYMgteT_Zwf6bya_Q");
        listImages.add("https://data.whicdn.com/images/48389311/original.jpg");
    }

    @Override
    public int getCount() {
        return listImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.view_image_item, null);
        ImageView imageView = view.findViewById(R.id.imageitem);
        Glide.with(view).load(listImages.get(position))
                .into(imageView);
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
