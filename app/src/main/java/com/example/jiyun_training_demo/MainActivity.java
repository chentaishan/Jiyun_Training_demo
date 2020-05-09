package com.example.jiyun_training_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.jiyun_training_demo.ui.dashboard.TopicFragment;
import com.example.jiyun_training_demo.ui.home.CartFragment;
import com.example.jiyun_training_demo.ui.home.HomeFragment;
import com.example.jiyun_training_demo.ui.home.OwnerFragment;
import com.example.jiyun_training_demo.ui.notifications.TypeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewpager;
    private TabLayout mTablayout;
    private LinearLayout mContainer;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        mContainer = (LinearLayout) findViewById(R.id.container);


        final List<Fragment> fragmentList = new ArrayList<>();

        fragmentList.add(new HomeFragment());
        fragmentList.add(new TopicFragment());
        fragmentList.add(new TypeFragment());
        fragmentList.add(new CartFragment());
        fragmentList.add(new OwnerFragment());
        mViewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });


        mTablayout.setupWithViewPager(mViewpager);

        View home = setCustomView(R.drawable.home_selector, "首页");
        View topic = setCustomView(R.drawable.topic_selector, "专题");
        View type = setCustomView(R.drawable.type_selector, "分类");
        View card = setCustomView(R.drawable.card_selector, "购物车");
        View owner = setCustomView(R.drawable.owner_selector, "我的");

        mTablayout.getTabAt(0).setCustomView(home);
        mTablayout.getTabAt(1).setCustomView(topic);
        mTablayout.getTabAt(2).setCustomView(type);
        mTablayout.getTabAt(3).setCustomView(card);
        mTablayout.getTabAt(4).setCustomView(owner);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("首页");
        setSupportActionBar(mToolbar);



        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();

                String name = ((TextView)customView.findViewById(R.id.tv)).getText().toString();
                mToolbar.setTitle(name);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private View setCustomView(int drawableId, String tabText) {
        View view = View.inflate(this, R.layout.item_tab, null);
        ImageView iv = (ImageView) view.findViewById(R.id.iv);
        TextView tv = (TextView) view.findViewById(R.id.tv);
        iv.setImageResource(drawableId);
        tv.setText(tabText);
        return view;
    }
}
