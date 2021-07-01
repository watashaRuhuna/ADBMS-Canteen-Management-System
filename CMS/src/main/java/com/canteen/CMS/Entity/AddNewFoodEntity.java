package com.canteen.CMS.Entity;

import javax.persistence.*;

@Entity
@Table(name = "food_inventory")
public class AddNewFoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer food_id;
    private String category_type;
    private String food_name;
    private Integer food_qty;
    private Float unit_price;

    public Integer getFood_id() {
        return food_id;
    }

    public void setFood_id(Integer food_id) {
        this.food_id = food_id;
    }

    public String getCategory_type() {
        return category_type;
    }

    public void setCategory_type(String category_type) {
        this.category_type = category_type;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public Integer getFood_qty() {
        return food_qty;
    }

    public void setFood_qty(Integer food_qty) {
        this.food_qty = food_qty;
    }

    public Float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Float unit_price) {
        this.unit_price = unit_price;
    }
}
