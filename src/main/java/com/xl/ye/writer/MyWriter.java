package com.xl.ye.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import com.xl.ye.bean.NolSysParam;

public class MyWriter<NolSysParam> implements ItemWriter<NolSysParam> {


    @Override
    public void write(List<? extends NolSysParam> items) throws Exception {
        for(int i=0; i<items.size(); i++){
            System.out.println("======================================"+i);
            NolSysParam nolSysParam = items.get(i);
            System.out.println(nolSysParam.toString());


        }
    }
}
