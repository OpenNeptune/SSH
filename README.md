<H3>Summary</H3>
一个整合好的SSH应用。（Spring + Strust + Hibernate）

	Spring:	4.0.2.RELEASE
	
	Struts: 2.3.16.3
	
	Hibernate: 3.6.6
	
	Log4j:1.2.17
	
	JDBC:ojdbc6.jar(Oracle 11g)

<h3>目录结构说明</h3>
<div>
├─conf<br>
│  └─hbm：*.hbm.xml<br>
│  :spring配置文件<br>
│  :strust配置文件<br>
│  :数据源配置文件<br>
│  :log4j配置文件<br>
├─JUnit<br>
│  └─Uint：JUnit测试<br>
├─src<br>
│  └─exam<br>
│      ├─dao：用于DAO<br>
│      ├─model:应用model<br>
│      ├─service:应用Service<br>
│      │  └─impl<br>
│      ├─struts：strust相关的<br>
│      │  └─interceptor<br>
│      └─util：工具类<br>
├─Test<br>
│  └─struts:一些临时的测试类 <br>
└─WebContent<br>
    ├─META-INF<br>
    └─WEB-INF<br>
        └─lib<br>
</div>
<h3>说明</h3>
	在struts中添加了一个默认的请求信息打印的拦截器:
		INFO:URI[相应时间]::参数
