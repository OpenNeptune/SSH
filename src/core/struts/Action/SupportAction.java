package core.struts.Action;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public abstract class SupportAction<T> extends ActionSupport implements ModelDriven<T>, Preparable {
	
	private static final long serialVersionUID = 242674155545473749L;
	
	public T model;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SupportAction(){
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class clazz = (Class) type.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public T getModel(){
		return model;
	};
	
	public void setModel(T model){
		this.model = model;
	}

	@Override
	public void prepare() throws Exception {	}
	
	
}
