package exam.struts.interceptor;
/**
 * @summary：
 * 		strut2的拦截器，用于完成日志功能
 */
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;




import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LogInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation action) throws Exception {
		ActionContext context = action.getInvocationContext();
		HttpServletRequest request = ServletActionContext.getRequest();
		String uri=request.getRequestURI();
		Long startTime = System.currentTimeMillis();
		Map<String, Object> actionParam = context.getParameters();
		//Map<String, Object> session = context.getSession();
		String result = action.invoke();
		Long endTime = System.currentTimeMillis();
		StringBuffer paramters = new StringBuffer();
		Iterator<Entry<String, Object>> iterator = actionParam.entrySet().iterator();
		Entry<String, Object> entry;
		while(iterator.hasNext()){
			entry =iterator.next();
			paramters.append("&");
			paramters.append(entry.getKey());
			paramters.append("=");
			paramters.append(entry.getValue());
		}
		System.out.println("LogInterceptor::requestInfo > "+uri+"["+(endTime - startTime)+"]::"+paramters.toString());
		return result;
	}

}
