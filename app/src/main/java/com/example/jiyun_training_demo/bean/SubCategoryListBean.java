package com.example.jiyun_training_demo.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class SubCategoryListBean implements Parcelable {

    private int id;
    private String name;
    private String keywords;
    private String front_desc;
    private int parent_id;
    private int sort_order;
    private int show_index;
    private int is_show;
    private String banner_url;
    private String icon_url;
    private String img_url;
    private String wap_banner_url;
    private String level;
    private int type;
    private String front_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getFront_desc() {
        return front_desc;
    }

    public void setFront_desc(String front_desc) {
        this.front_desc = front_desc;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }

    public int getShow_index() {
        return show_index;
    }

    public void setShow_index(int show_index) {
        this.show_index = show_index;
    }

    public int getIs_show() {
        return is_show;
    }

    public void setIs_show(int is_show) {
        this.is_show = is_show;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getWap_banner_url() {
        return wap_banner_url;
    }

    public void setWap_banner_url(String wap_banner_url) {
        this.wap_banner_url = wap_banner_url;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFront_name() {
        return front_name;
    }

    public void setFront_name(String front_name) {
        this.front_name = front_name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.keywords);
        dest.writeString(this.front_desc);
        dest.writeInt(this.parent_id);
        dest.writeInt(this.sort_order);
        dest.writeInt(this.show_index);
        dest.writeInt(this.is_show);
        dest.writeString(this.banner_url);
        dest.writeString(this.icon_url);
        dest.writeString(this.img_url);
        dest.writeString(this.wap_banner_url);
        dest.writeString(this.level);
        dest.writeInt(this.type);
        dest.writeString(this.front_name);
    }

    public SubCategoryListBean() {
    }

    protected SubCategoryListBean(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.keywords = in.readString();
        this.front_desc = in.readString();
        this.parent_id = in.readInt();
        this.sort_order = in.readInt();
        this.show_index = in.readInt();
        this.is_show = in.readInt();
        this.banner_url = in.readString();
        this.icon_url = in.readString();
        this.img_url = in.readString();
        this.wap_banner_url = in.readString();
        this.level = in.readString();
        this.type = in.readInt();
        this.front_name = in.readString();
    }

    public static final Parcelable.Creator<SubCategoryListBean> CREATOR = new Parcelable.Creator<SubCategoryListBean>() {
        @Override
        public SubCategoryListBean createFromParcel(Parcel source) {
            return new SubCategoryListBean(source);
        }

        @Override
        public SubCategoryListBean[] newArray(int size) {
            return new SubCategoryListBean[size];
        }
    };
}
