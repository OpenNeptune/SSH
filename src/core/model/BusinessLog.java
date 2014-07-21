package core.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @summary:
 * 		业务层的日志
 */
public class BusinessLog {
	private static final SimpleDateFormat sdf = new SimpleDateFormat(core.constant.constant.DATE_FORMAT);
	
	@Getter @Setter private Integer id;
	
	@Getter @Setter private String  userName;
	
	@Getter @Setter private String address;

	@Getter @Setter private Date  startTime = new Date();
	
	//地址栏请求的数据的地址(此处可将地址栏请请求参数绑定到同一个字段中，
	//当然可以将他们分开，另外也可以通过uri做很多的判断)
	@Getter @Setter private String uri;
	
	@Getter @Setter private String operationName;
	
	@Getter @Setter private String operationParam;
	
	@Getter @Setter private String result;
	
	@Getter @Setter private String msg;

	@Override
	public String toString() {
		return "BusinessLog [id=" + id + ", userName=" + userName + ", address=" + address + ", startTime=" + sdf.format(startTime) + ", uri=" + uri + ", operationName=" + operationName + ", operationParam=" + operationParam + ", result=" + result + ", msg=" + msg + "]";
	}
	
	
}
