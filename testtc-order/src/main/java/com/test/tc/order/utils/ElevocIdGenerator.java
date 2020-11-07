package com.test.tc.order.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ElevocIdGenerator {
    /**
     * 2020 0605 145038 786370525998878720
     *
     * @return
     */
    public static String uuid32(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            return simpleDateFormat.format(new Date(System.currentTimeMillis())) + IdWorkerUtil.getFlowIdWorkerInstance().nextId();
        }catch (Exception e){
            Random random = new Random(System.currentTimeMillis());
            String tmp = "";
            for (int i=0; i<18; i++){
                tmp += random.nextInt(10);
            }
            return simpleDateFormat.format(new Date(System.currentTimeMillis())) + tmp;
        }
    }
}
