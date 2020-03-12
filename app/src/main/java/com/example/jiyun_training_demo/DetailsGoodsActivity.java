package com.example.jiyun_training_demo;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.jiyun_training_demo.base.BaseActivity;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.DetailsBean;
import com.example.jiyun_training_demo.contract.IDetailsGoodsContract;
import com.example.jiyun_training_demo.presenter.DetailsPresenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class DetailsGoodsActivity extends BaseActivity<DetailsPresenter> implements IDetailsGoodsContract.View<DetailsBean> {


    private Banner mBanner;
    private WebView mWebview;

    @Override
    protected void initData() {

        int id = getIntent().getIntExtra("id",-1);
        presenter.getDetailsBean(id+"");
    }

    @Override
    protected DetailsPresenter initPresenter() {
        return new DetailsPresenter();
    }

    @Override
    protected void initView() {

        mBanner = (Banner) findViewById(R.id.banner);
        mWebview = (WebView) findViewById(R.id.webview);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_details_goods;
    }

    @Override
    public void showTips(String msg) {

    }

    @Override
    public void updateUISuccess(ComonResult<DetailsBean> results) {

        // banner 处理
        mBanner.setImages(results.getData().getGallery()).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                DetailsBean.GalleryBean galleryBean = (DetailsBean.GalleryBean) path;
                Glide.with(DetailsGoodsActivity.this).load(galleryBean.getImg_url()).into(imageView);

            }
        }).start();

//        网页处理
        updateWebView(results.getData().getInfo());

    }

    @Override
    public void updateUIFailed(String msg) {

    }


    //商品介绍描述信息
    private void updateWebView(DetailsBean.InfoBean infoBean){

        String css_str = getResources().getString(R.string.css_goods);
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head>");
        sb.append("<style>"+css_str+"</style></head><body>");
        sb.append(infoBean.getGoods_desc()+"</body></html>");
        mWebview.loadData(sb.toString(),"text/html","utf-8");

//        List<String> urlList = new ArrayList<>();
//        String[] arr = infoBean.getGoods_desc().split("<p>");
//        String head = "<img src=\"";
//        String foot = ".jpg";
//        for(int i=0; i<arr.length; i++){
//            if(TextUtils.isEmpty(arr[i])) continue;
//            int start = arr[i].indexOf(head)+head.length();
//            if(start == -1) continue;
//            int end = arr[i].indexOf(foot)+foot.length();
//            String url = arr[i].substring(start,end);
//            urlList.add(url);
//            Log.i("url",url);
//        }
    }
}
