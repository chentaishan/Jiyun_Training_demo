package com.example.jiyun_training_demo.ui.notifications;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.base.BaseFragment;
import com.example.jiyun_training_demo.bean.CataLogItemBean;
import com.example.jiyun_training_demo.bean.CatalogBean;
import com.example.jiyun_training_demo.bean.SortTypeBean;
import com.example.jiyun_training_demo.contract.ISortTypeContract;
import com.example.jiyun_training_demo.presenter.SortTypePresenter;
import com.example.jiyun_training_demo.view.MySelftGridView;

import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class NotificationsFragment extends BaseFragment<SortTypePresenter> implements ISortTypeContract.View<SortTypeBean> {


    private VerticalTabLayout mTablayout;

    private ImageView mImageTop;
    private TextView mTitle;
    private TextView mTitleType;
    private LinearLayout mContent;
    private List<CatalogBean.DataBean.CategoryListBean> categoryList;
    private MySelftGridView mySelftGridView;

    @Override
    protected void initData() {

        presenter.getSortTypeList();
        presenter.getTypeList("1005000");
    }

    @Override
    protected SortTypePresenter initPresenter() {
        return new SortTypePresenter();
    }

    @Override
    protected void initView(View itemView) {


        mTablayout = (VerticalTabLayout) itemView.findViewById(R.id.tablayout);
        mImageTop = (ImageView) itemView.findViewById(R.id.top_image);
        mTitle = (TextView) itemView.findViewById(R.id.title);
        mTitleType = (TextView) itemView.findViewById(R.id.type_title);
        mContent = (LinearLayout) itemView.findViewById(R.id.content);

        mTablayout.addTab(new QTabView(getActivity()));
        mTablayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {

                CatalogBean.DataBean.CategoryListBean categoryListBean = categoryList.get(position);
                presenter.getTypeList(categoryListBean.getId() + "");
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });
    }

    @Override
    protected int getlayout() {
        return R.layout.fragment_notifications;
    }

    private static final String TAG = "NotificationsFragment";

    @Override
    public void updateUISuccess(CatalogBean result) {

        categoryList = result.getData().getCategoryList();


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
                return new TabView.TabTitle.Builder().setContent(categoryList.get(position).getName()).build();
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });


    }

    @Override
    public void updateSubItem(CataLogItemBean cataLogItemBean) {

        if (mySelftGridView != null) {
            mContent.removeView(mySelftGridView);
        }

        CataLogItemBean.DataBean.CurrentCategoryBean currentCategory = cataLogItemBean.getData().getCurrentCategory();

        Glide.with(getActivity()).load(currentCategory.getWap_banner_url()).into(mImageTop);
        mTitle.setText(currentCategory.getFront_name());
        mTitleType.setText(cataLogItemBean.getData().getCurrentCategory().getName());

        mySelftGridView = new MySelftGridView(getActivity());
        mySelftGridView.initMyGridView(cataLogItemBean.getData().getCurrentCategory().getSubCategoryList());

        mContent.addView(mySelftGridView);

    }

    @Override
    public void updateUIFailed(String msg) {

    }

    @Override
    public void showTips(String msg) {

    }
}
