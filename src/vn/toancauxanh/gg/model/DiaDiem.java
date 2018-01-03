package vn.toancauxanh.gg.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import vn.toancauxanh.model.Model;

@Entity
@Table(name = "diadiem")
public class DiaDiem extends Model<DiaDiem>{
    public static transient final Logger LOG = LogManager.getLogger(DiaDiem.class.getName());
    
    private String name;
    private Category category;
    private Image picture;
    private String description;
    private String detail;
    private String address;
    private boolean isNoiBat = false;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    @ManyToOne
    public Image getPicture() {
        return picture;
    }
    public void setPicture(Image picture) {
        this.picture = picture;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public boolean isNoiBat() {
        return isNoiBat;
    }
    public void setNoiBat(boolean isNoiBat) {
        this.isNoiBat = isNoiBat;
    }
    
    
}
