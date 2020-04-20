package com.example.jiyun_training_demo.ui.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.jiyun_training_demo.LoginActivity;
import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.base.BaseFragment;
import com.example.jiyun_training_demo.base.BasePresenterFragment;
import com.example.jiyun_training_demo.base.IBasePresenter;

public class OwnerFragment extends BasePresenterFragment implements View.OnClickListener {


    private ImageView mImgUser;
    private TextView mB;
    private GridView mGridview;

    String[] titles = {"我的订单", "优惠卷", "礼品卡", "我的收藏", "我的足迹", "会员福利"};
    private RelativeLayout mLayoutLogin;

    @Override
    protected void initData() {

    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView(View itemView) {
        super.initView(itemView);
        mImgUser = (ImageView) itemView.findViewById(R.id.user_img);
        mB = (TextView) itemView.findViewById(R.id.login_text);
        mGridview = (GridView) itemView.findViewById(R.id.gridview);
        mGridview.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public Object getItem(int position) {
                return titles[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View root = LayoutInflater.from(getActivity()).inflate(R.layout.owner_item, null);
                TextView title = root.findViewById(R.id.title);
                title.setText(titles[position]);
                return root;
            }
        });
        mLayoutLogin = (RelativeLayout) itemView.findViewById(R.id.login_layout);
        mLayoutLogin.setOnClickListener(this);
    }

    @Override
    protected int getlayout() {
        return R.layout.owner_fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_layout:
                // TODO 20/03/21
                Intent intent = new Intent(getActivity(), LoginActivity.class);

                startActivityForResult(intent,99);
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==99){

            String name = data.getStringExtra("name");

            mB.setText(name);
        }
    }
}
