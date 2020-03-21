package com.example.jiyun_training_demo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.adapter.CarRlvAdapter;
import com.example.jiyun_training_demo.base.BaseFragment;
import com.example.jiyun_training_demo.bean.CartBean;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.contract.CartContract;
import com.example.jiyun_training_demo.presenter.CartPresenter;

public class CartFragment extends BaseFragment<CartPresenter> implements View.OnClickListener, CartContract.View<CartBean> {

    private RecyclerView car_recycler;
    private CheckBox mCbAllCar;
    private TextView mTvCountPriceCar;
    private Button mBtnCarPressCar;
    private TextView mTvEditStateCar;
    private RelativeLayout mCarLeadRel;
    private CarRlvAdapter carRlvAdapter;

    @Override
    protected void initData() {
        presenter.getCartDataList();
    }

    @Override
    protected CartPresenter initPresenter() {
        return new CartPresenter();
    }

    protected void initView(@NonNull final View itemView) {
        car_recycler = (RecyclerView) itemView.findViewById(R.id.car_recycler);

        car_recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        carRlvAdapter = new CarRlvAdapter(getContext());
        car_recycler.setAdapter(carRlvAdapter);

        mCbAllCar = (CheckBox) itemView.findViewById(R.id.car_cb_all);
        mTvCountPriceCar = (TextView) itemView.findViewById(R.id.car_tv_count_price);
        mBtnCarPressCar = (Button) itemView.findViewById(R.id.car_btn_car_press);
        mBtnCarPressCar.setOnClickListener(this);
        mTvEditStateCar = (TextView) itemView.findViewById(R.id.car_tv_edit_state);
        mCarLeadRel = (RelativeLayout) itemView.findViewById(R.id.rel_car_lead);
    }

    @Override
    protected int getlayout() {
        return R.layout.cart_fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.car_btn_car_press:
                // TODO 20/03/21
                break;
            default:
                break;
        }
    }

    @Override
    public void updateUISuccess(ComonResult<CartBean> results) {

        carRlvAdapter.refrshAdapter(results.getData().getCartList());
    }

    @Override
    public void updateUIFailed(String msg) {

    }

    @Override
    public void showTips(String msg) {

    }
}
