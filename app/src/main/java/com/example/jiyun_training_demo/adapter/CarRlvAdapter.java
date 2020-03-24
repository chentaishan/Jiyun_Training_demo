package com.example.jiyun_training_demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.bean.CartBean;

import java.util.ArrayList;
import java.util.List;

public class CarRlvAdapter extends RecyclerView.Adapter<CarRlvAdapter.CarHolder> {
    private ArrayList<CartBean.CartListBean> list = new ArrayList<>();
    private ArrayList<Boolean> statusList = new ArrayList<>();

    private Context context;

    public CarRlvAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_item,parent,false);
        return new CarHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CarHolder holder, final int position) {
        CartBean.CartListBean cartListBean = list.get(position);
        Glide.with(context).load(cartListBean.getList_pic_url()).into(holder.car_item_iv);
        holder.car_tv_name.setText(cartListBean.getGoods_name());
        holder.car_tv_price.setText("￥"+cartListBean.getRetail_price());
        holder.car_item_count.setText("X"+cartListBean.getNumber());
        if (statusList.get(position)){

            holder.car_item_cb.setChecked(true);
        }else{
            holder.car_item_cb.setChecked(false);

        }
        holder.car_item_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.car_item_cb.isChecked()){

                    statusList.set(position,true);
                }else{
                    statusList.set(position,false);
                }
                int[] params = computerPrice();
                if (iUpdateListener!=null){

                    iUpdateListener.updatePrice(params);
                }
            }
        });
    }
    public int[] computerPrice(){
        int price = 0;
        int count =0;
        for (int i = 0; i < list.size(); i++) {
            CartBean.CartListBean cartListBean = list.get(i);
            if (statusList.get(i)){
                price+=(cartListBean.getRetail_price()*cartListBean.getNumber());
                count += cartListBean.getNumber();
            }
        }
        return new int[]{price,count};
    }


    public void setSelectAll(boolean selectAll) {
        for (int i = 0; i < statusList.size(); i++) {
            statusList.set(i,selectAll);
        }

        int[] params = computerPrice();
        if (iUpdateListener!=null){

            iUpdateListener.updatePrice(params);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public ArrayList<CartBean.CartListBean> getGetAll() {
        return list;
    }

    class CarHolder extends RecyclerView.ViewHolder{
        public CheckBox car_item_cb;
        public ImageView  car_item_iv;
        public TextView  car_tv_name;
        public TextView  car_tv_price;
        public TextView  car_item_count;
        public TextView  car_item_chose;
        public TextView  car_item_reduce_count;
        public TextView  car_item_show_count;
        public TextView  car_item_add_count;
        public LinearLayout ll_control_add;

        public CarHolder(@NonNull View itemView) {
            super(itemView);
            car_item_cb = itemView.findViewById(R.id.car_item_cb);
            car_item_iv = itemView.findViewById(R.id.car_item_iv);
            car_tv_name = itemView.findViewById(R.id.car_tv_name);
            car_tv_price = itemView.findViewById(R.id.car_tv_price);
            car_item_count = itemView.findViewById(R.id.car_item_count);
            car_item_chose = itemView.findViewById(R.id.car_item_chose);
            car_item_reduce_count = itemView.findViewById(R.id.car_item_reduce_count);

            car_item_show_count = itemView.findViewById(R.id.car_item_show_count);
            car_item_add_count = itemView.findViewById(R.id.car_item_add_count);

            ll_control_add = itemView.findViewById(R.id.ll_control_add);
        }
    }

    public void refrshAdapter(List<CartBean.CartListBean> cartList){
        list.addAll(cartList);
        notifyDataSetChanged();
        for (int i = 0; i < cartList.size(); i++) {
            statusList.add(false);
        }
    }
    IUpdateListener iUpdateListener;

    public void setiUpdateListener(IUpdateListener iUpdateListener) {
        this.iUpdateListener = iUpdateListener;
    }

    public interface IUpdateListener{

        void updatePrice(int[] price);
    }
}
