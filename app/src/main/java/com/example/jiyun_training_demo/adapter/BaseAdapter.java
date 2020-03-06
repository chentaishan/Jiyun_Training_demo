package com.example.jiyun_training_demo.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyun_training_demo.R;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter {

    Context context;
    List<T> datalist = new ArrayList<>();

    public BaseAdapter(Context context) {
        this.context = context;
    }

    public void resetDataList(List<T> datalist) {
        this.datalist.clear();
        this.datalist.addAll(datalist);
        notifyDataSetChanged();
    }

    public void addDataList(List<T> datalist) {
        this.datalist.addAll(datalist);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(getLayout(),parent,false);

        return new BaseViewHolder(root);
    }

    protected abstract int getLayout();

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final BaseViewHolder baseViewHolder = (BaseViewHolder) holder;

        bindData(baseViewHolder,datalist.get(position));

        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iOnClickItem!=null){
                    iOnClickItem.clickItem(baseViewHolder,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    protected abstract void bindData(BaseViewHolder baseViewHolder, T t);

    static class BaseViewHolder extends RecyclerView.ViewHolder {

        SparseArray<View>  views;
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            if (views==null){

                views = new SparseArray<>();

            }
        }

        public View getViewById(int id){

            View view = views.get(id);

            if (view==null){
                view = itemView.findViewById(id);
                views.append(id,view);
            }
            return view;
        }
    }


    IOnClickItem iOnClickItem;

    public void setiOnClickItem(IOnClickItem iOnClickItem) {
        this.iOnClickItem = iOnClickItem;
    }

    interface IOnClickItem{
        void clickItem(BaseViewHolder viewHolder,int pos);
    }
}
