package com.xl.ye.base;


import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.explore.support.SimpleJobExplorer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.dao.Jackson2ExecutionContextStringSerializer;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@Import(DataSourceConfig.class)
public class BatchConfig extends DefaultBatchConfigurer implements InitializingBean {


    @Bean
    public JobRepository jobRepository( DataSource dataSource, DataSourceTransactionManager dataSourceTransactionManager) throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(dataSourceTransactionManager);
        jobRepositoryFactoryBean.setDatabaseType("mysql");
        return jobRepositoryFactoryBean.getObject();
    }

    /**
     * JobBuilderFactory
     *
     * @param jobRepository JobRepository
     * @return JobBuilderFactory
     */
    @Bean
    JobBuilderFactory jobBuilderFactory(JobRepository jobRepository) {
        return new JobBuilderFactory(jobRepository);
    }

    /**
     * StepBuilderFactory
     *
     * @param jobRepository                jobRepository
     * @param dataSourceTransactionManager dataSourceTransactionManager
     * @return stepBuilderFactory
     */
    @Bean
    StepBuilderFactory stepBuilderFactory(JobRepository jobRepository, DataSourceTransactionManager dataSourceTransactionManager) {
        return new StepBuilderFactory(jobRepository, dataSourceTransactionManager);
    }

    /**
     * 作业调度器
     */
    @Bean
    public SimpleJobLauncher jobLauncher(JobRepository jobRepository) throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return jobLauncher;
    }

    /**
     * 作业注册器
     */
    @Bean
    public MapJobRegistry mapJobRegistry() {
        return new MapJobRegistry();
    }


    /*** JobRegistryBeanPostProcessor
     *
     * @param mapJobRegistry MapJobRegistry
     * @return JobRegistryBeanPostProcessor
     */
    @Bean
    public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(MapJobRegistry mapJobRegistry) {
        JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
        jobRegistryBeanPostProcessor.setJobRegistry(mapJobRegistry);
        return jobRegistryBeanPostProcessor;
    }

    @Bean
    public JobExplorer jobExplorer(DataSource dataSource) throws Exception{
        JobExplorerFactoryBean jobExplorerFactoryBean = new JobExplorerFactoryBean();
        jobExplorerFactoryBean.setDataSource(dataSource);
        jobExplorerFactoryBean.setJdbcOperations(new JdbcTemplate(dataSource));
        jobExplorerFactoryBean.setSerializer(new Jackson2ExecutionContextStringSerializer());
        return jobExplorerFactoryBean.getObject();
    }


    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
