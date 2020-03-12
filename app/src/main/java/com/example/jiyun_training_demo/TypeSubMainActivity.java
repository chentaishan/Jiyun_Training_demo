package com.example.jiyun_training_demo;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jiyun_training_demo.base.BaseActivity;
import com.example.jiyun_training_demo.bean.CategoryListBean;
import com.example.jiyun_training_demo.bean.SubCategoryListBean;
import com.example.jiyun_training_demo.bean.TypeList2SubItemListBean;
import com.example.jiyun_training_demo.contract.ITypeSubMainContract;
import com.example.jiyun_training_demo.presenter.TypeSubMainPresenter;
import com.example.jiyun_training_demo.view.Home_CategoryView;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class TypeSubMainActivity extends BaseActivity<TypeSubMainPresenter> implements ITypeSubMainContract.View {


    private TabLayout mTablayout;

    List<SubCategoryListBean> itemList;
    private TextView mTitle;
    private TextView mNameFront;
    private Home_CategoryView mCategorylist;

    int firstId =0;
    @Override
    protected void initData() {
        itemList = getIntent().getParcelableArrayListExtra("itemList");
        // tab
        for (int i = 0; i < itemList.size(); i++) {

            SubCategoryListBean subCategoryListBean = itemList.get(i);
            if (firstId==0){
                firstId = subCategoryListBean.getId();
            }

            mTablayout.addTab(mTablayout.newTab().setText(subCategoryListBean.getName()));
        }

        presenter.getType2ItemList(firstId+"");

    }

    private void setViewDataList(SubCategoryListBean subCategoryListBean) {

        mTitle.setText(subCategoryListBean.getName());
        mNameFront.setText(subCategoryListBean.getFront_name());


        presenter.getType2ItemList(subCategoryListBean.getId()+"");
    }

    @Override
    protected TypeSubMainPresenter initPresenter() {
        return new TypeSubMainPresenter();
    }

    @Override
    protected void initView() {

        mTablayout = (TabLayout) findViewById(R.id.tablayout);

        mTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTitle = (TextView) findViewById(R.id.title);
        mNameFront = (TextView) findViewById(R.id.front_name);
        mCategorylist = (Home_CategoryView) findViewById(R.id.categorylist);
        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                SubCategoryListBean subCategoryListBean = itemList.get(tab.getPosition());
                setViewDataList(subCategoryListBean);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }



    @Override
    protected int getLayout() {
        return R.layout.activity_type_sub_main;
    }

    @Override
    public void updateUISuccess(TypeList2SubItemListBean result) {

        try {
            mCategorylist.initGridList(result.getData().getGoodsList(), new Home_CategoryView.IUpdateUIListener() {
                @Override
                public void setItem(Object o, ImageView img, TextView title, TextView price) {
                    TypeList2SubItemListBean.DataBeanX.GoodsListBean   goodsListBean = (TypeList2SubItemListBean.DataBeanX.GoodsListBean) o;

                    Glide.with(TypeSubMainActivity.this).load(goodsListBean.getList_pic_url()).into(img);
                    title.setText(goodsListBean.getName());
                    price.setText(goodsListBean.getRetail_price() + "元起");

                }

                @Override
                public void itemClick(Object o) {

                }
            });
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUIFailed(String msg) {

    }

    @Override
    public void showTips(String msg) {

    }
}
