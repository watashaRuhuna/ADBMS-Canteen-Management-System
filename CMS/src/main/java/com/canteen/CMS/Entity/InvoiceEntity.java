package com.canteen.CMS.Entity;

import javax.persistence.*;

@Entity
@Table(name = "invoice")
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer invoice_id;
    private Integer order_id;
    private String invoice_pdf;

    public Integer getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getInvoice_pdf() {
        return invoice_pdf;
    }

    public void setInvoice_pdf(String invoice_pdf) {
        this.invoice_pdf = invoice_pdf;
    }
}
