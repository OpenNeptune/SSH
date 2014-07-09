<H3>Summary</H3>
一个整合好的SSH应用。（Spring + Strust + Hibernate）
	Spring:	4.0.2.RELEASE
	Struts: 2.3.16.3
	Hibernate: 3.6.6
	Log4j:1.2.17

	JDBC:ojdbc6.jar(Oracle 11g)

<h3>目录结构说明</h3>
├─conf
│  └─hbm：*.hbm.xml
│  :spring配置文件
│  :strust配置文件
│  :数据源配置文件
│  :log4j配置文件
├─JUnit
│  └─Uint：JUnit测试
├─src
│  └─exam
│      ├─dao：用于DAO
│      ├─model:应用model
│      ├─service:应用Service
│      │  └─impl
│      ├─struts：strust相关的
│      │  └─interceptor
│      └─util：工具类
├─Test
│  └─struts:一些临时的测试类 
└─WebContent
    ├─META-INF
    └─WEB-INF
        └─lib
<h3>说明</h3>
	在struts中添加了一个默认的请求信息打印的拦截器:
		INFO:URI[相应时间]::参数