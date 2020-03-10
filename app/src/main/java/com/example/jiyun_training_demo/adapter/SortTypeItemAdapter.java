package com.example.jiyun_training_demo.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.BaseAdapter;
import com.bumptech.glide.Glide;
import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.bean.SortTypeBean;
import com.example.jiyun_training_demo.bean.SortType_Itembean;

import java.util.ArrayList;
import java.util.List;

public class SortTypeItemAdapter extends BaseAdapter  {
    List<SortType_Itembean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = new ArrayList<>();

    Context context;

    public SortTypeItemAdapter(Context context) {
        this.context = context;
    }

    public void setSubCategoryList(List<SortType_Itembean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList) {
        this.subCategoryList.clear();
        this.subCategoryList .addAll(subCategoryList);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return subCategoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return subCategoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root = LayoutInflater.from(context).inflate(R.layout.sorttype_grid_item,null);
        ImageView img  = root.findViewById(R.id.imageView);
        TextView title = root.findViewById(R.id.title);
        SortType_Itembean.DataBean.CurrentCategoryBean.SubCategoryListBean subCategoryListBean = subCategoryList.get(position);
        Glide.with(context).load(subCategoryListBean.getWap_banner_url()).into(img);

        title.setText(subCategoryListBean.getName());
        return root;
    }
}
