package com.pwfz.service.Impl;

import com.pwfz.service.Producename;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Random;

@Service
public class ProducenameImp implements Producename {
    @Override
    public String producename() {
        String RandomFilename = "";
        Random rand = new Random();//生成随机数
        int random = rand.nextInt();
        Calendar calCurrent = Calendar.getInstance();
        int intDay = calCurrent.get(Calendar.DATE);
        int intMonth = calCurrent.get(Calendar.MONTH) + 1;
        int intYear = calCurrent.get(Calendar.YEAR);
        String now = String.valueOf(intYear) + "_" + String.valueOf(intMonth) + "_" +
                String.valueOf(intDay) + "_";
        RandomFilename = now + String.valueOf(random > 0 ? random : ( -1) * random) + ".";
        return RandomFilename;
    }
}
