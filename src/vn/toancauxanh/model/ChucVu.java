package vn.toancauxanh.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="chucvu")
public class ChucVu extends Model<ChucVu>{

    private String tenChucVu;

    public ChucVu() {
        super();
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }
    
}
