//package com.xl.ye.batchJob;
//
//import com.xl.ye.base.BatchConfig;
//import com.xl.ye.tasklet.TestTasklet;
//import com.xl.ye.writer.MyWriter;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.batch.MyBatisCursorItemReader;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//@Configuration
//@Import(BatchConfig.class)
//public class FirstBatchJob {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    protected MyBatisCursorItemReader testReader(SqlSessionFactory sqlSessionFactory){
//        MyBatisCursorItemReader myBatisCursorItemReader = new MyBatisCursorItemReader();
//        myBatisCursorItemReader.setSqlSessionFactory(sqlSessionFactory);
//        myBatisCursorItemReader.setQueryId("com.xl.ye.dao.NolSysParamDao.findBySysId");
//        Map param = new HashMap<String, Object>();
//        param.put("sysId", "nol");
//        myBatisCursorItemReader.setParameterValues(param);
//        return myBatisCursorItemReader;
//
//    }
//
////    @Bean
////    public Job job(Step step1, Step step2) {
////        return jobBuilderFactory.get("xxx").start(step1).next(step2).build();
////    }
//
//    @Bean
//    protected Step step1(MyBatisCursorItemReader testReader) {
//        return stepBuilderFactory.get("step1")
//                .chunk(1)
//                .reader(testReader)
//                .writer(new MyWriter<>())
//                .build();
//    }
//
//    @Bean
//    protected Step step2() {
//        return stepBuilderFactory.get("step2")
//                .tasklet(new TestTasklet())
//                .build();
//    }
//}
