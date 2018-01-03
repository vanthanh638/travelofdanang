
package vn.toancauxanh.service;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.zkoss.util.resource.Labels;
import org.zkoss.zhtml.Object;

import vn.toancauxanh.gg.service.CategoryService;
import vn.toancauxanh.model.VaiTro;

@Configuration
@Controller
public class Entry extends BaseObject<Object> {
	static Entry instance;

	@Value("${trangthai.apdung}")
	public String TT_AP_DUNG = "";
	@Value("${trangthai.daxoa}")
	public String TT_DA_XOA = "";
	@Value("${trangthai.khongapdung}")
	public String TT_KHONG_AP_DUNG = "";

	// No image url
	public String URL_M_NOIMAGE = "/assetsfe/images/lg_noimage.png";
	public String URL_S_NOIMAGE = "/assetsfe/images/sm_noimage.png";
	
	//trang thai bai viet
	@Value("${trangthaisoan.daduyet}")
	public String TTS_DA_DUYET = "";
	@Value("${trangthaisoan.dangsoan}")
	public String TTS_DANG_SOAN = "";
	@Value("${trangthaisoan.choduyet}")
	public String TTS_CHO_DUYET = "";
	@Value("${trangthaisoan.tuchoi}")
	public String TTS_TU_CHOI = "";
	@Value("${trangthaihienthi.tieudiemchinh}")
	public String TT_TIEU_DIEM_CHINH = "";
	@Value("${trangthaihienthi.noibat}")
	public boolean TT_NOI_BAT = true;
	
	@Value("${action.xem}")
	public String XEM = ""; // duoc xem bat ky
	@Value("${action.list}")
	public String LIST = ""; // duoc vao trang list search url
	@Value("${action.sua}")
	public String SUA = ""; // duoc sua bat ky
	@Value("${action.xoa}")
	public String XOA = ""; // duoc xoa bat ky
	@Value("${action.them}")
	public String THEM = ""; // duoc them
	@Value("${action.xuatban}")
	public String XUATBAN = ""; // duoc duyet va xuat ban
	@Value("${action.lichsucapnhat}")
	public String LICHSUCAPNHAT = ""; // duoc them
	@Value("${action.lichsu}")
	public String LICHSU = "";

	@Value("${url.nguoidung}")
	public String NGUOIDUNG = "";
	@Value("${url.vaitro}")
	public String VAITRO = "";
	@Value("${url.donvi}")
	public String DONVI = "";
	@Value("${url.donvihanhchinh}")
	public String DONVIHANHCHINH = "";
	@Value("${url.category}")
	public String CATEGORY = "";
	
	//
	@Value("${url.diadiem}")
	public String DIADIEM = "";
	// uend
	public char CHAR_CACH = ':';
	public String CACH = CHAR_CACH + "";

	@Value("${url.vaitro}" + ":" + "${action.xem}")
	public String VAITROXEM;
	@Value("${url.vaitro}" + ":" + "${action.them}")
	public String VAITROTHEM = "";
	@Value("${url.vaitro}" + ":" + "${action.list}")
	public String VAITROLIST = "";
	@Value("${url.vaitro}" + ":" + "${action.xoa}")
	public String VAITROXOA = "";
	@Value("${url.vaitro}" + ":" + "${action.sua}")
	public String VAITROSUA = "";

	@Value("${url.nguoidung}" + ":" + "${action.xem}")
	public String NGUOIDUNGXEM = "";
	@Value("${url.nguoidung}" + ":" + "${action.them}")
	public String NGUOIDUNGTHEM = "";
	@Value("${url.nguoidung}" + ":" + "${action.list}")
	public String NGUOIDUNGLIST = "";
	@Value("${url.nguoidung}" + ":" + "${action.xoa}")
	public String NGUOIDUNGXOA = "";
	@Value("${url.nguoidung}" + ":" + "${action.sua}")
	public String NGUOIDUNGSUA = "";

	@Value("${url.donvi}" + ":" + "${action.xem}")
	public String DONVIXEM = "";
	@Value("${url.donvi}" + ":" + "${action.them}")
	public String DONVITHEM = "";
	@Value("${url.donvi}" + ":" + "${action.list}")
	public String DONVILIST = "";
	@Value("${url.donvi}" + ":" + "${action.xoa}")
	public String DONVIXOA = "";
	@Value("${url.donvi}" + ":" + "${action.sua}")
	public String DONVISUA = "";

	@Value("${url.donvihanhchinh}" + ":" + "${action.xem}")
	public String DONVIHANHCHINHXEM = "";
	@Value("${url.donvihanhchinh}" + ":" + "${action.them}")
	public String DONVIHANHCHINHTHEM = "";
	@Value("${url.donvihanhchinh}" + ":" + "${action.list}")
	public String DONVIHANHCHINHLIST = "";
	@Value("${url.donvihanhchinh}" + ":" + "${action.xoa}")
	public String DONVIHANHCHINHXOA = "";
	@Value("${url.donvihanhchinh}" + ":" + "${action.sua}")
	public String DONVIHANHCHINHSUA = "";

	@Value("${url.quantrihethong}" + ":" + "${action.list}")
	public String QUANTRIHETHONGLIST = "";

	// Hệ thống active
	@Value("${url.hethong}" + ":" + "${action.xem}")
	public String HETHONGXEM = "";
	@Value("${url.hethong}" + ":" + "${action.sua}")
	public String HETHONGSUA = "";

	@Value("${url.category}" + ":" + "${action.xem}")
	public String CATEGORYXEM = "";
	@Value("${url.category}" + ":" + "${action.them}")
	public String CATEGORYTHEM = "";
	@Value("${url.category}" + ":" + "${action.list}")
	public String CATEGORYLIST = "";
	@Value("${url.category}" + ":" + "${action.xoa}")
	public String CATEGORYXOA = "";
	@Value("${url.category}" + ":" + "${action.sua}")
	public String CATEGORYSUA = "";
	
	@Value("${url.diadiem}" + ":" + "${action.xem}")
    public String DIADIEMXEM = "";
	@Value("${url.diadiem}" + ":" + "${action.list}")
	public String DIADIEMLIST = "";

	@Value("${url.thongke}" + ":" + "${action.list}")
	public String THONGKELIST = "";

	// aend
	public String[] getRESOURCES() {
		return new String[] { NGUOIDUNG, VAITRO, DONVI, CATEGORY, DIADIEM};
	}

	public String[] getACTIONS() {
		return new String[] { LIST, XEM, THEM, SUA, XOA, XUATBAN, LICHSUCAPNHAT, LICHSU };
	}

	static {
		File file = new File(Labels.getLabel("filestore.root") + File.separator + Labels.getLabel("filestore.folder"));
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory mis is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
	}
	@Autowired
	public Environment env;

	@Autowired
	DataSource dataSource;

	public Entry() {
		super();
		setCore();
		instance = this;
	}

	@Bean
	public FilterRegistrationBean cacheFilter() {
		FilterRegistrationBean rs = new FilterRegistrationBean(new CacheFilter());
		rs.addUrlPatterns("*.css");
		rs.addUrlPatterns("*.js");
		rs.addUrlPatterns("*.wpd");
		rs.addUrlPatterns("*.wcs");
		rs.addUrlPatterns("*.jpg");
		rs.addUrlPatterns("*.jpeg");
		rs.addUrlPatterns("*.png");
		rs.addUrlPatterns("*.svg");
		rs.addUrlPatterns("*.gif");
		return rs;
	}

	/* @Bean
	 public FilterRegistrationBean loginFilter() {
	 FilterRegistrationBean rs = new FilterRegistrationBean(new
	 LoginFilter());
	 rs.addUrlPatterns("/cp*");
	 return rs;
	 }*/

	Map<String, String> pathMap = new HashMap<>();
	{
		MapUtils.putAll(pathMap,
				new String[] { "doanhnghiep", "doanhnghiep", "gioithieu", "gioithieu", "cosophaply", "cosophaply" });
	}

	@RequestMapping(value = "/")
	public String home() {
		return "forward:/frontend/index.zhtml?&file=/frontend/home/home.zhtml";
	}
	
	@RequestMapping(value = "/{path:.+$}/{cat:\\d+}/id/{id:\\d+}")
	public String newDetail(@PathVariable String path, @PathVariable Long cat, @PathVariable Long id) {
		return "forward:/frontend/index.zhtml?resource="+path+"&file=/frontend/kyhop/newdetail.zhtml&cat="+cat+"&id="+ id;
	}
	
	@RequestMapping(value = "/{path:.+$}/{cat:\\d+}")
	public String newDetail(@PathVariable String path, @PathVariable Long cat) {
		return "forward:/frontend/index.zhtml?resource="+path+"&file=/frontend/kyhop/newslist.zhtml&cat="
				+ cat;
	}
	
	// BE
	@RequestMapping(value = "/cp")
	public String cp() {
		return "forward:/WEB-INF/zul/home.zul?resource=diadiem&action=lietke&file=/WEB-INF/zul/diadiem/list.zul&macdinh=home";
	}
	
	@RequestMapping(value = "/cp/{path:.+$}")
	public String cp(@PathVariable String path) {
		return "forward:/WEB-INF/zul/home.zul?resource=" + path + "&action=lietke&file=/WEB-INF/zul/" + path
				+ "/list.zul";
	}

	@RequestMapping(value = "/login")
	public String dangNhapBackend() {
		return "forward:/WEB-INF/zul/login.zul";
	}
	
	public final Quyen getQuyen() {
		return getNhanVien().getTatCaQuyen();
	}
	public final VaiTroService getVaiTros() {
		return new VaiTroService();
	}
	
	public final CategoryService getCategories() {
		return new CategoryService();
	}
	

	public final List<String> getNoiDungActive() {
		return Arrays.asList("category", "baiviet", "video", "gallery", "linhvuchoidap", "hoidaptructuyen", "faqcategory",
				"faq");
	}
	
	public boolean checkVaiTro(String vaiTro) {
		if (vaiTro == null || vaiTro.isEmpty()) {
			return false;
		}
		boolean rs = false;
		for (VaiTro vt : getNhanVien().getVaiTros()) {
			if (vaiTro.equals(vt.getAlias())) {
				rs = true;
				break;
			}
		}
		return rs;// || getQuyen().get(vaiTro);
	}
	
	@Configuration
	@EnableWebMvc
	public static class MvcConfig extends WebMvcConfigurerAdapter {
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    	registry
	          .addResourceHandler("/files/**")
	          .addResourceLocations("file:/home/hdndhoavangdata/hdndfiles/");
	        registry
	          .addResourceHandler("/assetsfe/**")
	          .addResourceLocations("/assetsfe/");
	        registry
	          .addResourceHandler("/backend/**")
	          .addResourceLocations("/backend/");
	        registry
            .addResourceHandler("/frontend/**")
            .addResourceLocations("/frontend/");
	        registry
	          .addResourceHandler("/img/**")
	          .addResourceLocations("/img/");
	        registry
	          .addResourceHandler("/login/**")
	          .addResourceLocations("/login/");
	    }
	    
	    @Override
	    public void configureViewResolvers(final ViewResolverRegistry registry) {
	        registry.jsp("/WEB-INF/", "*");
	    }
	    @ExceptionHandler(ResourceNotFoundException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public String handleResourceNotFoundException() {
	        return "forward:/WEB-INF/zul/notfound.zul";
	    }
	}

}