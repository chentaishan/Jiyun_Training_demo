package com.example.jiyun_training_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jiyun_training_demo.base.BaseActivity;
import com.example.jiyun_training_demo.bean.AddCartBean;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.DetailsBean;
import com.example.jiyun_training_demo.contract.IDetailsGoodsContract;
import com.example.jiyun_training_demo.presenter.DetailsPresenter;
import com.example.jiyun_training_demo.view.MySelftGridView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

public class DetailsGoodsActivity extends BaseActivity<DetailsPresenter> implements IDetailsGoodsContract.View<DetailsBean>, View.OnClickListener {


    private Banner mBanner;
    private WebView mWebview;
    private TextView mTitleTxt;
    private TextView mDesTxt;
    private TextView mPriceTxt;
    private TextView mNumsTxt;
    private ConstraintLayout mNumsLayout;
    private TextView mParamTxt;
    private TextView mMetarialTxt;
    private ConstraintLayout mMetarialLayout;
    private TextView mSizeTxt;
    private ConstraintLayout mSizeLayout;
    private TextView mColorTxt;
    private ConstraintLayout mColorLayout;
    private TextView mNormTxt;
    private ConstraintLayout mNormLayout;
    private TextView mPlaceTxt;
    private LinearLayout mQuestionTxt;
    private RecyclerView mRecyclerView;
    private TextView mCollectTxt;
    private ImageView mCartTxt;
    private TextView mBuyTxt;
    private TextView mAddCartTxt;
    private MySelftGridView mSelfview;
    private LinearLayout mLayoutAttribute;

    private ImageView mImg;
    private TextView mPrice;
    private ImageView mClose;
    private LinearLayout mCartLayoutAdd;
    private DetailsBean.InfoBean infoBean;

    int productId;

    @Override
    protected void initData() {

        int id = getIntent().getIntExtra("id", -1);
        presenter.getDetailsBean(id + "");
    }

    @Override
    protected DetailsPresenter initPresenter() {
        return new DetailsPresenter();
    }

    @Override
    protected void initView() {

        mBanner = (Banner) findViewById(R.id.banner);
        mWebview = (WebView) findViewById(R.id.webview);
        mTitleTxt = (TextView) findViewById(R.id.txt_title);
        mDesTxt = (TextView) findViewById(R.id.txt_des);
        mPriceTxt = (TextView) findViewById(R.id.txt_price);
        mNumsTxt = (TextView) findViewById(R.id.txt_nums);
        mNumsLayout = (ConstraintLayout) findViewById(R.id.layout_nums);
        mParamTxt = (TextView) findViewById(R.id.txt_param);


        mCollectTxt = (TextView) findViewById(R.id.txt_collect);
        mCartTxt = (ImageView) findViewById(R.id.txt_cart);
        mBuyTxt = (TextView) findViewById(R.id.txt_buy);
        mAddCartTxt = (TextView) findViewById(R.id.txt_addCart);
        mQuestionTxt = (LinearLayout) findViewById(R.id.txt_question);
        mSelfview = (MySelftGridView) findViewById(R.id.selfview);
        mLayoutAttribute = (LinearLayout) findViewById(R.id.attribute_layout);
        mAddCartTxt.setOnClickListener(this);


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

        if (results.getData().getProductList().size() > 0) {

            productId = results.getData().getProductList().get(0).getId();
        }
        // banner 处理
        mBanner.setImages(results.getData().getGallery()).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                DetailsBean.GalleryBean galleryBean = (DetailsBean.GalleryBean) path;
                Glide.with(DetailsGoodsActivity.this).load(galleryBean.getImg_url()).into(imageView);

            }
        }).start();

        mTitleTxt.setText(results.getData().getInfo().getName());
        mDesTxt.setText(results.getData().getInfo().getGoods_brief());
        mPriceTxt.setText("￥" + results.getData().getInfo().getRetail_price());

        //商品参数
        List<DetailsBean.AttributeBean> attribute = results.getData().getAttribute();
        for (int i = 0; i < attribute.size(); i++) {

            View root = LayoutInflater.from(this).inflate(R.layout.attribute_item, null);
            TextView title = root.findViewById(R.id.title);
            TextView content = root.findViewById(R.id.content);

            DetailsBean.AttributeBean attributeBean = results.getData().getAttribute().get(i);
            title.setText(attributeBean.getName());
            content.setText(attributeBean.getValue());

            mLayoutAttribute.addView(root);
        }

        //网页处理
        updateWebView(results.getData().getInfo());

        //常见问题
        List<DetailsBean.IssueBean> issue = results.getData().getIssue();
        for (int i = 0; i < issue.size(); i++) {
            View root = LayoutInflater.from(this).inflate(R.layout.issu_item, null);
            TextView title = root.findViewById(R.id.title);
            TextView content = root.findViewById(R.id.content);

            mQuestionTxt.addView(root);

            title.setText(issue.get(i).getQuestion());
            content.setText(issue.get(i).getAnswer());
        }
        //大家都在看
//        results.getData().get();
//        mSelfview.initMyGridView();


    }

    @Override
    public void addCartSuccess(ComonResult  results) {
        AddCartBean data = (AddCartBean) results.getData();

        Toast.makeText(this, "添加购物车成功", Toast.LENGTH_SHORT).show();
        mCartLayoutAdd.setVisibility(View.GONE);
    }

    @Override
    public void updateUIFailed(String msg) {

    }


    //商品介绍描述信息
    private void updateWebView(DetailsBean.InfoBean infoBean) {

        this.infoBean = infoBean;
        String css_str = getResources().getString(R.string.css_goods);
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head>");
        sb.append("<style>" + css_str + "</style></head><body>");
        sb.append(infoBean.getGoods_desc() + "</body></html>");
        mWebview.loadData(sb.toString(), "text/html", "utf-8");

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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_addCart:
                if (mCartLayoutAdd != null && mCartLayoutAdd.getVisibility() == View.VISIBLE) {

                    presenter.addGoodsToCart(infoBean.getId() + "", currCartPopNums + "", productId + "");

                } else {
                    initAddCartPop();

                }
                break;
        }
    }

    int currCartPopNums = 1;

    /**
     * 弹出添加购物车的弹窗
     */
    private void initAddCartPop() {

        mCartLayoutAdd = (LinearLayout) findViewById(R.id.add_cart_layout);
        mCartLayoutAdd.setVisibility(View.VISIBLE);
        mImg = (ImageView) findViewById(R.id.img);
        mPrice = (TextView) findViewById(R.id.price);
        TextView jianBtn = (TextView) findViewById(R.id.jian);
        final TextView numsTv = (TextView) findViewById(R.id.nums);
        TextView addBtn = (TextView) findViewById(R.id.add);
        mClose = (ImageView) findViewById(R.id.close);

        if (this.infoBean != null) {
            String url = infoBean.getPrimary_pic_url();
            Glide.with(this).load(url).into(mImg);
            mPrice.setText("价格：￥ : " + infoBean.getRetail_price());
        }
        mClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCartLayoutAdd.setVisibility(View.GONE);
            }
        });
        jianBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currCartPopNums > 1) {
                    currCartPopNums--;
                    numsTv.setText(currCartPopNums + "");
                }
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currCartPopNums++;
                numsTv.setText(currCartPopNums + "");
            }
        });
    }
}
