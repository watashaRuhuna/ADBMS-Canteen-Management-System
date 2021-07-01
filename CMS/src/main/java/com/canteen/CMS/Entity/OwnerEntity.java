package com.canteen.CMS.Entity;

import javax.persistence.*;

@Entity
@Table(name = "canteen_owner")
public class OwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ow_id;
    private String ow_name;
    private String email;
    private String ow_mobile;
    private String password;

    public Integer getOw_id() {
        return ow_id;
    }

    public void setOw_id(Integer ow_id) {
        this.ow_id = ow_id;
    }

    public String getOw_name() {
        return ow_name;
    }

    public void setOw_name(String ow_name) {
        this.ow_name = ow_name;
    }

    public String getOw_email() {
        return email;
    }

    public void setOw_email(String ow_email) {
        this.email = ow_email;
    }

    public String getOw_mobile() {
        return ow_mobile;
    }

    public void setOw_mobile(String ow_mobile) {
        this.ow_mobile = ow_mobile;
    }

    public String getOw_pwd() {
        return password;
    }

    public void setOw_pwd(String ow_pwd) {
        this.password = ow_pwd;
    }
}
