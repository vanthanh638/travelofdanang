package vn.toancauxanh.gg.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDiaDiem is a Querydsl query type for DiaDiem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDiaDiem extends EntityPathBase<DiaDiem> {

    private static final long serialVersionUID = 778831912L;

    private static final PathInits INITS = new PathInits("*", "nguoiSua.*.*.*.*", "nguoiTao.*.*.*.*");

    public static final QDiaDiem diaDiem = new QDiaDiem("diaDiem");

    public final vn.toancauxanh.model.QModel _super;

    public final StringPath address = createString("address");

    public final QCategory category;

    //inherited
    public final BooleanPath daXoa;

    public final StringPath description = createString("description");

    public final StringPath detail = createString("detail");

    //inherited
    public final NumberPath<Long> id;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.util.Date> ngaySua;

    //inherited
    public final DateTimePath<java.util.Date> ngayTao;

    // inherited
    public final vn.toancauxanh.model.QNhanVien nguoiSua;

    // inherited
    public final vn.toancauxanh.model.QNhanVien nguoiTao;

    public final BooleanPath noiBat = createBoolean("noiBat");

    public final QImage picture;

    //inherited
    public final StringPath trangThai;

    public QDiaDiem(String variable) {
        this(DiaDiem.class, forVariable(variable), INITS);
    }

    public QDiaDiem(Path<? extends DiaDiem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDiaDiem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDiaDiem(PathMetadata metadata, PathInits inits) {
        this(DiaDiem.class, metadata, inits);
    }

    public QDiaDiem(Class<? extends DiaDiem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new vn.toancauxanh.model.QModel(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategory(forProperty("category"), inits.get("category")) : null;
        this.daXoa = _super.daXoa;
        this.id = _super.id;
        this.ngaySua = _super.ngaySua;
        this.ngayTao = _super.ngayTao;
        this.nguoiSua = _super.nguoiSua;
        this.nguoiTao = _super.nguoiTao;
        this.picture = inits.isInitialized("picture") ? new QImage(forProperty("picture"), inits.get("picture")) : null;
        this.trangThai = _super.trangThai;
    }

}

