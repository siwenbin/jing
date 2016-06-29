package com.mengding.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mengding.log.log1.WebLog1;

public class WebLog {
    
    private static Logger logger = LoggerFactory.getLogger(WebLog.class);
    
    public static void main(String[] args) {
        WebLog1.print();
        logger.error("==========webLog=====================");
        
    }
    
}
