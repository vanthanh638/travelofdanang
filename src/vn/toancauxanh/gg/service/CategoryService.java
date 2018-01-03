package vn.toancauxanh.gg.service;

import org.apache.commons.collections.MapUtils;
import org.zkoss.util.resource.Labels;

import com.querydsl.jpa.impl.JPAQuery;

import vn.toancauxanh.gg.model.Category;
import vn.toancauxanh.gg.model.QCategory;
import vn.toancauxanh.service.BasicService;

public class CategoryService extends BasicService<Category>{
    private String img = "/backend/assets/img/edit.png";
    private String hoverImg = "/backend/assets/img/edit_hover.png";
    private String strUpdate = "Thứ tự";
    private boolean update = true;
    private boolean updateThanhCong = true;
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHoverImg() {
        return hoverImg;
    }

    public void setHoverImg(String hoverImg) {
        this.hoverImg = hoverImg;
    }

    public String getStrUpdate() {
        return strUpdate;
    }

    public void setStrUpdate(String strUpdate) {
        this.strUpdate = strUpdate;
    }
    
    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean isUpdateThanhCong() {
        return updateThanhCong;
    }

    public void setUpdateThanhCong(boolean updateThanhCong) {
        this.updateThanhCong = updateThanhCong;
    }
    
    public JPAQuery<Category> getTargetQuery(){
        String paramImage = MapUtils.getString(argDeco(),Labels.getLabel("param.tukhoa"), "").trim();
        String trangThai = MapUtils.getString(argDeco(),Labels.getLabel("param.trangthai"),"");
        JPAQuery<Category> q = find(Category.class)
                .where(QCategory.category.trangThai.ne(core().TT_DA_XOA));
        if (paramImage != null && !paramImage.isEmpty()) {
            String tukhoa = "%" + paramImage + "%";
            q.where(QCategory.category.name.like(tukhoa));
        }
        if (!trangThai.isEmpty()) {
            q.where(QCategory.category.trangThai.eq(trangThai));
        }
        return q.orderBy(QCategory.category.ngaySua.desc());
    }
    
    

}
