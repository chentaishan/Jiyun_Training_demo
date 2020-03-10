package com.example.jiyun_training_demo.ui.notifications;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.adapter.SortTypeItemAdapter;
import com.example.jiyun_training_demo.base.BaseFragment;
import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.SortTypeBean;
import com.example.jiyun_training_demo.bean.SortType_Itembean;
import com.example.jiyun_training_demo.contract.ISortTypeContract;
import com.example.jiyun_training_demo.presenter.SortTypePresenter;

import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class NotificationsFragment extends BaseFragment<SortTypePresenter> implements ISortTypeContract.View<SortTypeBean> {


    private VerticalTabLayout mTablayout;
    private GridView mGridview;
    private SortTypeItemAdapter sortTypeItemAdapter;

    @Override
    protected void initData() {

        presenter.getSortTypeList();
    }

    @Override
    protected SortTypePresenter initPresenter() {
        return new SortTypePresenter();
    }

    @Override
    protected void initView(View itemView) {

        mTablayout = (VerticalTabLayout) itemView.findViewById(R.id.tablayout);
        mGridview = (GridView) itemView.findViewById(R.id.gridview);
    }

    @Override
    protected int getlayout() {
        return R.layout.fragment_notifications;
    }

    private static final String TAG = "NotificationsFragment";
    @Override
    public void updateUISuccess(ComonResult<SortTypeBean>  result) {

        final List<SortTypeBean.CategoryListBean> categoryList = result.getData().getCategoryList();

        mTablayout.addTab(new QTabView(context));
        mTablayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {

                Log.d(TAG, "onTabSelected: "+position);
                presenter.getTypeList(categoryList.get(position).getId()+"");
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

                Log.d(TAG, "onTabReselected: "+position);
            }
        });
        mTablayout.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return categoryList.size();
            }

            @Override
            public TabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public TabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public TabView.TabTitle getTitle(int position) {
//                categoryList.get(position).getName()
                return new TabView.TabTitle.Builder().setContent(categoryList.get(position).getName()).build();
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });

        sortTypeItemAdapter = new SortTypeItemAdapter(getActivity());
        mGridview.setAdapter(sortTypeItemAdapter);
    }

    @Override
    public void updateSubItem(SortType_Itembean sortType) {
        sortTypeItemAdapter.setSubCategoryList(sortType.getData().getCurrentCategory().getSubCategoryList());
    }

    @Override
    public void updateUIFailed(String msg) {

    }

    @Override
    public void showTips(String msg) {

    }
}
