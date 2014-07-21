<H3>Summary</H3>
一个整合好的SSH应用。（Spring + Strust + Hibernate）

	Spring:	4.0.2.RELEASE
	
	Struts: 2.3.16.3
	
	Hibernate: 3.6.6
	
	Log4j:1.2.17
	
	JDBC:ojdbc6.jar(Oracle 11g)
<h3>编码规范</h3>
	包结构
    ├─constant        一些常量和静态方法
    ├─dao            dao层的接口（Spring的@Repository层）ModelDao命名
    │  └─impl		   DAO实现层ModelDaoImpl命名
    ├─model          业务Model类的定义（Model命名首字母大写）
    ├─service          Service层的接口(Spring的@Service层) ModelService命名
    │  ├─impl        Service层的实现ModelServiceImple
    │  └─interceptor   Service的Filter(Spring的AOP)operationInterceptor命名
    ├─struts           控制层的接口(Spring的@Controller) 
    │  ├─Action      控制层是实现及action实现operationAction命名
    │  └─interceptor  控制层的Filter（Struts2的拦截器）operationInterceptor命名
	└─util             工具类
<h4>DAO层的方法定义</h4>
	<div>
		Dao层通过Hibernate实现ORM映射，完成数据库到JAVA对象的映射，数据库链接又通过Spring管理。
		同事事务在Service层又Spring以AOP的思想实现同一的控制.
		DAO层的方法应以如下规则命名:
		命名规则: CURDEntry() 	注CURD代表操作方式（通过Entry表明該操作属于DAO层）
		//保存实体
		public void saveEntry(T t);
		
		//更新实体
		public void updateEntry(T t);
		
		//保存或更新
		public void saveOrUpdateEntry(T t);
		
		//删除实体
		public void deleteEntry(T t);
		
		//加载实体
		public T loadEntry(String id);
		
		//加载实体
		public T getEntry(String id);
		
		//以HQL方式批量操作
		public int batchEntry (String hql,Object ...objects);
		
		//通过HQL获得实体列表
		public List<T> getEntryListByHQL(String hql,Object ...objects);
		
		//通过SQL获得提示列表
		public List<T> getEntryListBySQL(String sql,Object ...objects);
	
		public List<T> findEntryByHQL(String hql, Object[] objects);
		
		//以分页的方式获得实体
		public EntryPage queryPageEntry(final String hql, int page, final int size);
	</div>
	
<h4>Service层的方法定义</h4>
	<div>
	Service是J2EE软件的核心部分，主要涉及到软件的业务功能，它通过控制层将客户端请求分装传递到业务层，
	业务层根据具体的情况做成相应的操作，例如调用DAO层的方式实现对业务实体的控制.
	一般的设计原则是在业务层提供一套和DAO层统一的API接口。但为了明显的区分該方法调用是Service层的而
	不是DAO层的，对Service层的方法做如下规定:

	命名规则: CURD() 	注CURD代表操作方式（通非Entry表明該操作属于Service层）
		//保存实体
		public void save (T t);
		//更新实体
		public void update (T t);	
		//保存或更新
		public void saveOrUpdate (T t);
		//删除实体
		public void delete (T t);
		//加载实体
		public T load(String id);
		//加载实体
		public T get(String id);
		//以HQL方式批量操作
		public int batch(String hql,Object ...objects);
		//通过HQL获得实体列表
		public List<T> getListByHQL(String hql,Object ...objects);
		//通过SQL获得提示列表
		public List<T> getListBySQL(String sql,Object ...objects);
		public List<T> findByHQL(String hql, Object[] objects);
		//以分页的方式获得实体
		public EntryPage queryPage(final String hql, int page, final int size);
		</div>
<h4>控制层Action的方法定义</h4>
	<div>
	该层有struts2实现，在此处层有一个简单的设计原则，及所以的非静态资源都应该有Action进行跳转，
	及链接中要直接出现*.JSP等。
	
	方法定义:
	对应Action的action的方法，应当有统一的前缀或后缀，此处使用前缀及:execActionName()
	另外如果实现了ModelDriven拦截器、Preparable拦截器、Validateable拦截器
	其Action怎还用实现
	如下俩个方法：
		getModel():提供Model对象
		prepareExecActionName ()：在调用execActionName方法前提供一个Model对象
		validateExecActionName():在调用execActionName前做输入校验

	另外如果是实现Preparabel拦截器的话，就应当使用paramsPrepareParamsStack拦截器栈
	Struts 2.0的设计上要求 modelDriven 在 params 之前调用，而业务中prepare要负责准备model，
	准备model又需要参数，这就需要在 prepare之前运行params拦截器设置相关参数，
	这个也就是创建paramsPrepareParamsStack的原因。(在struts.xml文件中定义了一个curdstack拦截器栈)
	</div>
	

	
<h3>以实现说明</h3>
	<div>
	在struts中添加了一个默认的请求信息打印的拦截器:
		INFO:URI[相应时间]::参数

	并且有一个JSP->STRUTS->SPRING->HIBERNATE->DB的具体实例
	
	实现了一个业务层的操作日志记录的拦截器（SpringAOP）
	
	实现了spring从业务层管理Hibernate的事务机制
	
	另外实现了一个常见的CURD操作。
	</div>
	
<h3>说明</h3>
<div>
由于本项目中使用Lombox来简化代码
所以使用实现请在eclipse.ini中做如下配置：
	1. 双击下载下来的 JAR 包安装 lombok
    我选择这种方式安装的时候提示没有发现任何 IDE，所以我没安装成功，我是手动安装的。如果你想以这种方式安装，请参考官网的视频。

2.eclipse / myeclipse 手动安装 lombok
    1. 将 lombok.jar 复制到 myeclipse.ini / eclipse.ini 所在的文件夹目录下
    2. 打开 eclipse.ini / myeclipse.ini，在最后面插入以下两行并保存：
        -Xbootclasspath/a:lombok.jar
        -javaagent:lombok.jar
    3.重启 eclipse / myeclipse

lombok 注解：
    lombok 提供的注解不多，可以参考官方视频的讲解和官方文档。
    Lombok 注解在线帮助文档：http://projectlombok.org/features/index.
    下面介绍几个我常用的 lombok 注解：
        @Data   ：注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
        @Setter：注解在属性上；为属性提供 setting 方法
        @Getter：注解在属性上；为属性提供 getting 方法
        @Log4j ：注解在类上；为类提供一个 属性名为log 的 log4j 日志对象
        @NoArgsConstructor：注解在类上；为类提供一个无参的构造方法
        @AllArgsConstructor：注解在类上；为类提供一个全参的构造方法	
</div>