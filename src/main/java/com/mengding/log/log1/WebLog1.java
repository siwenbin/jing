package com.mengding.log.log1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebLog1 {
    
    private static Logger logger = LoggerFactory.getLogger(WebLog1.class);
    
    public static void print(){
        logger.info("===========WebLog1=============");
    }
    
    
}
