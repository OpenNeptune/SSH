package core.service.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;

import core.model.User;

import com.opensymphony.xwork2.ActionContext;

import core.model.BusinessLog;
import core.service.BusinessLogService;
import core.util.StringUtil;
/**
 * 利用SpringAOP实现业务层的日志记录
 */
public class ServiceIntercetor {
	
	@Resource(name="businessLogService")
	private BusinessLogService businessLogService;

	public void setBusinessLogService(BusinessLogService businessLogService) {
		this.businessLogService = businessLogService;
	}
	//定义任何方法调用的切入点
	private BusinessLog log = new BusinessLog();
	
    public Object logAop(ProceedingJoinPoint pjp){
		try{
			//操作名称
			String opeationName =pjp.getTarget().getClass().getName()+"::"+pjp.getSignature().getName();
			log.setOperationName(opeationName);
			//操作参数 
			log.setOperationParam(StringUtil.arr2Str(pjp.getArgs()));
			
			//获取session中的数据
			ActionContext context = ActionContext.getContext();
			if(context != null){
				Map<String, Object> session = context.getSession();
				if(session != null){
					User user = (User) session.get("user");
					if(user != null){
						log.setUserName(user.getUsername());
					}
				}
				HttpServletRequest request = ServletActionContext.getRequest();
				if(request != null){
					String uri=request.getRequestURI();
					String address=request.getRemoteAddr();
					log.setAddress(address);
					Map<String, Object> actionParam = context.getParameters();
					StringBuffer paramters = new StringBuffer();
					Iterator<Entry<String, Object>> iterator = actionParam.entrySet().iterator();
					Entry<String, Object> entry;
					while(iterator.hasNext()){
						entry =iterator.next();
						paramters.append("&");
						paramters.append(entry.getKey());
						paramters.append("=");
						paramters.append(StringUtil.arr2Str((String[])entry.getValue()));
					}
					log.setUri(uri+"?"+paramters.toString());
				}
			}
			//调用目标对象的方法
			Object ret = pjp.proceed();
			//设置操作结果
			log.setResult("success");
			//设置结果消息
			if(ret != null){
				log.setMsg(ret.toString());
			}
			return ret ;
		}catch(Throwable e){
			log.setResult("Exception");
			//message只保存2000个字符
			String msg= e.getMessage();
			if(msg.length() > 2000){
				msg = msg.substring(0, 2000);
			}
			log.setMsg(msg);
		}finally{
			businessLogService.save(log);
		}
		return null;
	}
	
}
