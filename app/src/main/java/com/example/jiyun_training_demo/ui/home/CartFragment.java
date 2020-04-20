package com.example.jiyun_training_demo.ui.home;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.adapter.CarRlvAdapter;
import com.example.jiyun_training_demo.base.BaseFragment;
import com.example.jiyun_training_demo.base.BasePresenterFragment;
import com.example.jiyun_training_demo.bean.CartBean;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.contract.CartContract;
import com.example.jiyun_training_demo.presenter.CartPresenter;

public class CartFragment extends BasePresenterFragment<CartPresenter> implements View.OnClickListener, CartContract.View<CartBean> {

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
        super.initView(itemView);
        car_recycler = (RecyclerView) itemView.findViewById(R.id.car_recycler);

        car_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        car_recycler.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        carRlvAdapter = new CarRlvAdapter(getContext());
        car_recycler.setAdapter(carRlvAdapter);

        mCbAllCar = (CheckBox) itemView.findViewById(R.id.car_cb_all);
        mTvCountPriceCar = (TextView) itemView.findViewById(R.id.car_tv_count_price);
        mBtnCarPressCar = (Button) itemView.findViewById(R.id.car_btn_car_press);
        mBtnCarPressCar.setOnClickListener(this);
        mTvEditStateCar = (TextView) itemView.findViewById(R.id.car_tv_edit_state);
        mCarLeadRel = (RelativeLayout) itemView.findViewById(R.id.rel_car_lead);
        mTvEditStateCar.setOnClickListener(this);
        mCbAllCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCbAllCar.isChecked()) {
                    carRlvAdapter.setSelectAll(true);

                } else {
                    carRlvAdapter.setSelectAll(false);

                }

            }
        });

        carRlvAdapter.setiUpdateListener(new CarRlvAdapter.IUpdateListener() {
            @Override
            public void updatePrice(int[] price) {
                setAllPrice(price);
            }
        });

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
//删除数据
                if (carRlvAdapter.isEditMode()) {
                    carRlvAdapter.deleteSelect();
                } else {
//                    下单


                }


                break;
            case R.id.car_tv_edit_state:
                if (carRlvAdapter.isEditMode()) {
                    carRlvAdapter.setEditMode(false);
                    mTvEditStateCar.setText("编辑");
                    mBtnCarPressCar.setText("下单");

                    // 重新计算

                    carRlvAdapter.exitEditMode();

                } else {
                    carRlvAdapter.setEditMode(true);
                    mBtnCarPressCar.setText("删除所选");
                    mTvEditStateCar.setText("完成");
                    // TODO 下单



                }

                break;
            default:
                break;
        }
    }

    private void setAllPrice(int[] price) {

        mTvCountPriceCar.setText("总价：" + price[0] + "元");
        mCbAllCar.setText("全部（" + price[1] + "）");

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
