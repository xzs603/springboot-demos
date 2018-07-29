package com.mttsui.baseapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class DateConfig {

    private static SimpleDateFormat DATE_FMT = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat DATE_TIME_FMT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Bean
    public Converter<String, Date> addNewConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                Date date = null;
                try {
                    date = DATE_FMT.parse((String) source);
                } catch (ParseException e) {
                    e.printStackTrace();
                    try {
                        date = DATE_TIME_FMT.parse((String) source);
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                }
                return date;
            }
        };
    }
}
