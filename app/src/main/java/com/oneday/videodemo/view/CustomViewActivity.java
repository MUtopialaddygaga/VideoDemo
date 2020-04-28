package com.oneday.videodemo.view;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.oneday.videodemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考网址:
 * https://hencoder.com/
 */
public class CustomViewActivity extends AppCompatActivity {
    private static final String TAG = "CustomViewActivity";
    private TabLayout tabLayout;
    private ViewPager pager;

    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.layout_draw_color_view, R.string.title_draw_color, R.layout.layout_draw_color_view));
        pageModels.add(new PageModel(R.layout.layout_draw_circle_view, R.string.title_draw_circle, R.layout.layout_draw_circle_view));
        pageModels.add(new PageModel(R.layout.layout_draw_arc_view, R.string.title_draw_arc, R.layout.layout_draw_arc_view));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        pager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(mPagerAdapter);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(pager);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        private int[] ids = new int[]{
                R.string.title_draw_color,
                R.string.title_draw_circle,
                R.string.title_draw_arc
        };

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            PageModel pageModel = pageModels.get(position);
            switch (position) {
                case 0:
                    return PageFragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);
                case 1:
                    return PageFragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);
                case 2:
                    return PageFragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);
                default:
                    break;
            }
            return null;
        }

        @Override
        public int getCount() {
            return ids.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return getString(ids[position]);
        }
    }

    private class PageModel {
        @LayoutRes
        int sampleLayoutRes;
        @StringRes
        int titleRes;
        @LayoutRes
        int practiceLayoutRes;

        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes,
                  @LayoutRes int practiceLayoutRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
