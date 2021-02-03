package com.xl.ye.base;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * 加载配置
 *
 */
@Configuration
@ImportResource(value = { "classpath*:configJobs/*ApplicationContext.xml"
						})
@PropertySource(value = { "classpath:quartz.properties"
						})
//@EnableAspectJAutoProxy
@MapperScan(basePackages = AppConfig.BASEPACKAGES)
public class AppConfig {
	
	// dao扫描路径
	protected static final String BASEPACKAGES = "com.xl.ye.dao";
	// 数据库属性key值
	protected static final String DATABASETYPE = "database.type";
	protected static final String DATABASEURL = "database.url";
	protected static final String DATABASEDRIVER = "database.driver";
	protected static final String DATABASEUSER = "database.user";
	protected static final String DATABASEPWD = "database.passwd";
	protected static final String DATABASEVQ = "database.validationQuery";
	// 配置初始化大小 最小数 最大数
	protected static final String DATABASEINITIALSIZE = "database.InitialSize";
	protected static final String DATABASEMINIDLE = "database.minIdle";
	protected static final String DATABASEMAXACTIVE = "database.maxActive";

	// mybatis配置
	protected static final String RESOURCEPATH = "classpath*:**/*.mybatis.xml";
	protected static final String MYBATISRESOURCEPATH = "classpath:mybatis-config.xml";

	// 编程式事务
	protected static final String PROPAGATIONREQUIRED = "PROPAGATION_REQUIRED";
	protected static final String ISOLATION_READCOMMITTED = "ISOLATION_REPEATABLE_READ";

	protected static final String STAT = "stat";
	
	/* 加密的配置 */
	protected static final String DECODEKEY = "ff2f10b642ad44aca3c49f8a16c526f4ff2f";
	
	
}
