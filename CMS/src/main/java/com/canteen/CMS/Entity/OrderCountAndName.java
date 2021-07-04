package com.canteen.CMS.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_count")
public class OrderCountAndName{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String food_name;
    private Integer count;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
