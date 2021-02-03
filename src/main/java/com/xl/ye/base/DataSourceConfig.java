package com.xl.ye.base;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据源配置
 */
@Configuration
@ConditionalOnClass(DataSource.class)
@ConditionalOnBean(Environment.class)
@AutoConfigureAfter(AppConfig.class)
public class DataSourceConfig {

	@Bean
	@Primary
	public DataSource dataSource() throws Exception {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUrl(getProperties(AppConfig.DATABASEURL));
		druidDataSource.setDriverClassName(getProperties(AppConfig.DATABASEDRIVER));
		druidDataSource.setUsername(getProperties(AppConfig.DATABASEUSER));
		druidDataSource.setPassword(getProperties(AppConfig.DATABASEPWD));
		// 配置初始化大小、最小、最大
		druidDataSource.setInitialSize(Integer.valueOf(getProperties(AppConfig.DATABASEINITIALSIZE)));
		druidDataSource.setMinIdle(Integer.valueOf(getProperties(AppConfig.DATABASEMINIDLE)));
		druidDataSource.setMaxActive(Integer.valueOf(getProperties(AppConfig.DATABASEMAXACTIVE)));
		// 配置获取连接等待超时的时间
		druidDataSource.setMaxWait(180000l);
		// 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
		druidDataSource.setTimeBetweenEvictionRunsMillis(180000l);
		// 配置一个连接在池中最小生存的时间，单位是毫秒 -->
		druidDataSource.setMinEvictableIdleTimeMillis(300000l);
		druidDataSource.setTestWhileIdle(true);
		druidDataSource.setTestOnBorrow(false);
		druidDataSource.setTestOnReturn(false);
		// 打开PSCache，并且指定每个连接上PSCache的大小
		druidDataSource.setPoolPreparedStatements(true);
		druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
		druidDataSource.setValidationQuery("select 1 from dual");
		// 配置监控统计拦截的filters
		druidDataSource.setFilters(AppConfig.STAT);
		return druidDataSource;
	}

	@Bean
	@Primary
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		// 读取mybatis.xml
		Resource[] mapperLocations = new PathMatchingResourcePatternResolver()
				.getResources(AppConfig.RESOURCEPATH);
		Resource Resource = new DefaultResourceLoader().getResource(AppConfig.MYBATISRESOURCEPATH);
		bean.setMapperLocations(mapperLocations);
		bean.setConfigLocation(Resource);
//		Speed4jVendorDatabaseIdProvider speed4jVendorDatabaseIdProvider = new Speed4jVendorDatabaseIdProvider();
//		speed4jVendorDatabaseIdProvider.setDatabaseType(getProperties(AppConfig.DATABASETYPE));
//		bean.setDatabaseIdProvider(speed4jVendorDatabaseIdProvider);
		return bean.getObject();
	}

	@Bean
	@Primary
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	@Primary
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	// 编程式事务管理
	@Bean
	@Primary
	public DefaultTransactionDefinition defaultTransactionDefinition() {
		DefaultTransactionDefinition dtd = new DefaultTransactionDefinition();
		dtd.setPropagationBehaviorName(AppConfig.PROPAGATIONREQUIRED);
		dtd.setIsolationLevelName(AppConfig.ISOLATION_READCOMMITTED);
		dtd.setTimeout(600);
		return dtd;
	}

	@Autowired
	public Environment env;
	
	/**
	 * 读取Properties值
	 * 
	 * @param key
	 * @return
	 * @throws Exception 
	 */
	private String getProperties(String key) throws Exception {
//		if (AppConfig.DATABASEPWD.equals(key)){
//			String value = AESUtil.decode(env.getProperty(key), AppConfig.DECODEKEY);
//			return value;
//		} 
		return env.getProperty(key);
	}
}