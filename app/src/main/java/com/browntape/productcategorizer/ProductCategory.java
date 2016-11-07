package com.browntape.productcategorizer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Srini on 11/6/16.
 */

public class ProductCategory implements Serializable {

    public String id;
    public String title;
    public String breadcrumb;
    public String parent_id;
    public String tree_code;
    public String is_lead;
    public String parent_name;
    //public SubCategory[] sub_cats;

    public Map<String, SubCategory> sub_cats;

    public ProductCategory(){}

    public ProductCategory(String id,
                           String title,
                           String breadcrumb,
                           String parent_id,
                           String tree_code,
                           String is_lead,
                           Map sub_cats)
    {
        id = id;
        title = title;
        breadcrumb = breadcrumb;
        parent_id = parent_id;
        tree_code = tree_code;
        is_lead = is_lead;
        sub_cats = sub_cats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBreadcrumb() {
        return breadcrumb;
    }

    public void setBreadcrumb(String breadcrumb) {
        this.breadcrumb = breadcrumb;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getTree_code() {
        return tree_code;
    }

    public void setTree_code(String tree_code) {
        this.tree_code = tree_code;
    }

    public String getIs_lead() {
        return is_lead;
    }

    public void setIs_lead(String is_lead) {
        this.is_lead = is_lead;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public Map getSub_Cats() {
        return sub_cats;
    }

    public void setSub_Cats(Map subCategories) {
        this.sub_cats = subCategories;
    }

    //subcategories
    public class SubCategory{
        public String id;
        public String title;
        public String breadcrumb;
        public String parent_id;
        public String tree_code;
        public String is_lead;
        public String parent_name;

        public SubCategory(){}

        public SubCategory(String id,
                               String title,
                               String breadcrumb,
                               String parent_id,
                               String tree_code,
                               String is_lead)
        {
            id = id;
            title = title;
            breadcrumb = breadcrumb;
            parent_id = parent_id;
            tree_code = tree_code;
            is_lead = is_lead;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBreadcrumb() {
            return breadcrumb;
        }

        public void setBreadcrumb(String breadcrumb) {
            this.breadcrumb = breadcrumb;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getTree_code() {
            return tree_code;
        }

        public void setTree_code(String tree_code) {
            this.tree_code = tree_code;
        }

        public String getIs_lead() {
            return is_lead;
        }

        public void setIs_lead(String is_lead) {
            this.is_lead = is_lead;
        }

        public String getParent_name() {
            return parent_name;
        }

        public void setParent_name(String parent_name) {
            this.parent_name = parent_name;
        }
    }
}
