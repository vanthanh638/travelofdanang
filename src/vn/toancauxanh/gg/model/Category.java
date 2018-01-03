package vn.toancauxanh.gg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zul.Window;

import com.google.common.base.Strings;

import vn.toancauxanh.model.Model;

@Entity
@Table(name = "category")
public class Category extends Model<Category>{
    public static transient final Logger LOG = LogManager.getLogger(Category.class.getName());
    
    private String name;
    private String description;

    public Category() {
    }
    
    @Column(length = 150)
    public String getName() {
        return this.name;
    }
    public void setName( String name) {
        this.name = Strings.nullToEmpty(name);
    }
    @Column(length = 255)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Command
    public void saveDanhMuc(@BindingParam("list") final Object listObject,
            @BindingParam("attr") final String attr,
            @BindingParam("wdn") final Window wdn) {
        save();
        wdn.detach();
        BindUtils.postNotifyChange(null, null, listObject, attr);
    }
}
