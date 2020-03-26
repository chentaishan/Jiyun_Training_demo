package com.example.jiyun_training_demo;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyun_training_demo.adapter.SearchAdapter;
import com.example.jiyun_training_demo.bean.SearchBean;
import com.example.jiyun_training_demo.service.HomeService;
import com.google.android.material.internal.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity {

    private EditText mSearchEt;
    private TextView mCancelTv;
    private TextView mHistoryTv;
    private TextView mSearchNoResultTv;
    private RecyclerView mSearchResultRv;
//    private FlowLayout mFl;
    private ArrayList<String> historyList;
    private String keyWord;
    private ArrayList<SearchBean.DataBeanX.DataBean> list;
    private SearchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        initData();
    }

    private void initData() {
        mSearchResultRv.setVisibility(View.GONE);
        mSearchNoResultTv.setVisibility(View.GONE);
        if (!TextUtils.isEmpty(keyWord)) {
            mHistoryTv.setVisibility(View.GONE);
//            mFl.setVisibility(View.GONE);

            if (!historyList.contains(keyWord)) {
                historyList.add(keyWord);
                final TextView lable = (TextView) LayoutInflater.from(this).inflate(R.layout.item_fl, null);
                lable.setText(keyWord);

                lable.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mSearchEt.setText(lable.getText().toString());
                    }
                });

//                mFl.addView(lable);
            }

            getNetResponse();
        } else {
            mHistoryTv.setVisibility(View.VISIBLE);
//            mFl.setVisibility(View.VISIBLE);
        }
    }
    private int page = 1, size = 100, categoryId = 0;
    private String keyword, sort = "default", order = "desc";
    private void getNetResponse() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HomeService.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        HomeService apiService = retrofit.create(HomeService.class);
        Flowable<SearchBean> flowable = apiService.getGoodsList(keyWord, page, size, sort, order, categoryId);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResourceSubscriber<SearchBean>() {
                    @Override
                    public void onNext(SearchBean goodListBean) {
                        List<SearchBean.DataBeanX.DataBean> data = goodListBean.getData().getData();
                        if (data.size() > 0) {
                            mSearchResultRv.setVisibility(View.VISIBLE);
                            list.addAll(data);
                            adapter.notifyDataSetChanged();
                        } else {
                            mSearchNoResultTv.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("TAG", "网络请求失败：" + t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView() {
        mSearchEt = (EditText) findViewById(R.id.et_search);
        mCancelTv = (TextView) findViewById(R.id.tv_cancel);
        mHistoryTv = (TextView) findViewById(R.id.tv_history);
        mSearchNoResultTv = (TextView) findViewById(R.id.tv_search_no_result);
        mSearchResultRv = (RecyclerView) findViewById(R.id.rv_search_result);
//        mFl = (FlowLayout) findViewById(R.id.fl);

        mCancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSearchEt.setText("");
            }
        });

        historyList = new ArrayList<>();
        mSearchEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH||actionId==EditorInfo.IME_FLAG_NO_ENTER_ACTION) {
                    //隐藏软键盘
                    hideKeyboard(mSearchEt);

                    //在这里做操作，一般网络请求、数据库查询
                    keyWord = mSearchEt.getText().toString();
                    if (list != null && list.size() > 0) {
                        list.clear();
                    }
                    initData();
                    return true;
                }
                return false;
            }
        });

        mSearchResultRv.setLayoutManager(new GridLayoutManager(this, 2));
        list = new ArrayList<>();
        adapter = new SearchAdapter(this, list);
        mSearchResultRv.setAdapter(adapter);
    }

    public void hideKeyboard(View view) {
        InputMethodManager manager = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
