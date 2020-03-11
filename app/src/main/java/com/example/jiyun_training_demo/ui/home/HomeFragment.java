package com.example.jiyun_training_demo.ui.home;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.base.BaseFragment;
import com.example.jiyun_training_demo.bean.CategoryListBean;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.HomeBean;
import com.example.jiyun_training_demo.contract.HomeContract;
import com.example.jiyun_training_demo.presenter.HomePresenter;
import com.example.jiyun_training_demo.view.Home_Type;
import com.example.jiyun_training_demo.view.Home_Brand;
import com.example.jiyun_training_demo.view.Home_CategoryView;
import com.example.jiyun_training_demo.view.Home_HotGoods;
import com.example.jiyun_training_demo.view.Home_NewGoods;
import com.example.jiyun_training_demo.view.Home_TopicGoods;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View<HomeBean> {

    Banner banner;
    Home_Type homeType;
    Home_Brand homeBrand;
    Home_NewGoods mNewGoodsHome;
    private Home_HotGoods mHotGoodsHome;
    private Home_TopicGoods mHotTopicHome;
    private LinearLayout mCategorylist;

    @Override
    protected void initData() {

        presenter.getHomeData();
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView(View view) {

        banner = view.findViewById(R.id.banner);
        homeType = view.findViewById(R.id.home_one_layout);
        homeBrand = view.findViewById(R.id.home_two_layout);

        mNewGoodsHome = view.findViewById(R.id.home_new_goods);
        mHotGoodsHome = view.findViewById(R.id.home_hot_goods);
        mHotTopicHome = view.findViewById(R.id.home_topic_goods);
        mCategorylist = (LinearLayout)view.findViewById(R.id.categorylist);
    }

    @Override
    protected int getlayout() {
        return R.layout.home_fragment;
    }

    @Override
    public void showTips(String msg) {

    }

    @Override
    public void updateUISuccess(ComonResult<HomeBean> results) {

        banner.setImages(results.getData().getBanner()).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {

                HomeBean.BannerBean bannerBean = (HomeBean.BannerBean) path;
                Glide.with(getActivity()).load(bannerBean.getImage_url()).into(imageView);
            }
        }).start();

        homeType.addItem(results.getData().getChannel());

        homeBrand.initGird(results.getData().getBrandList());

        mNewGoodsHome.initGird(results.getData().getNewGoodsList());

        mHotGoodsHome.initList(results.getData().getHotGoodsList());

        mHotTopicHome.initList(results.getData().getTopicList());


        List<CategoryListBean> categoryList = results.getData().getCategoryList();

        for (int i = 0; i < categoryList.size(); i++) {

            Home_CategoryView home_categoryView = new Home_CategoryView(getContext());

            home_categoryView.initTitleView(categoryList.get(i).getName());
            home_categoryView.initGridList(categoryList.get(i).getGoodsList(), new Home_CategoryView.IUpdateUIListener() {
                @Override
                public void setItem(Object o, ImageView img, TextView title, TextView price) {
//                    List<CategoryListBean.GoodsListBean> goodsList = categoryList.get(i).getGoodsList();
                    CategoryListBean.GoodsListBean goodsListBean = (CategoryListBean.GoodsListBean) o;

                    Glide.with(getContext()).load(goodsListBean.getList_pic_url()).into(img);
                    title.setText(goodsListBean.getName());
                    price.setText(goodsListBean.getRetail_price() + "元起");

                }
            });

            mCategorylist.addView(home_categoryView);

        }

        Log.d(TAG, "updateUISuccess: " + results.getData().toString());
    }

    @Override
    public void updateUIFailed(String msg) {

    }

    private static final String TAG = "HomeFragment";


}
