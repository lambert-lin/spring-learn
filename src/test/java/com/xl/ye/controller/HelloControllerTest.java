package com.xl.ye.controller;

import com.xl.ye.bean.NolSysParam;
import com.xl.ye.service.NolSysParamService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;



@SpringBootTest
public class HelloControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private NolSysParamService nolSysParamService;

    @BeforeMethod
    public void setUp() {
    }

    @Test
    public void testHello() {
        List<NolSysParam> params = nolSysParamService.findBySysId("nol");
        System.out.println(params.get(0).toString());
        assertNotNull(params);
    }

    @Test
    public void testRunJob() {
        System.out.println("test job run ");
    }

    @Test
    public void testTrans() {
    }
}