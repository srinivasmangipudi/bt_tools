package com.browntape.productcategorizer;

/**
 * Created by Srini on 11/8/16.
 */

public class Product {
    public String id;
    public String itemOrder;
    public String title;
    public String sku_code_from_channel;
    public String company_id;
    public String number;
    public String category_id;

    public Product(){}

    public Product(String id, String itemOrder, String title, String sku_code_from_channel, String company_id, String number, String category_id) {
        this.id = id;
        this.itemOrder = itemOrder;

        this.title = title;
        this.sku_code_from_channel = sku_code_from_channel;
        this.company_id = company_id;
        this.number = number;
        this.category_id = category_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(String itemOrder) {
        this.itemOrder = itemOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSku_code_from_channel() {
        return sku_code_from_channel;
    }

    public void setSku_code_from_channel(String sku_code_from_channel) {
        this.sku_code_from_channel = sku_code_from_channel;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String catgory_id) {
        this.category_id = catgory_id;
    }
}
