package com.mengding.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class HelloWordLog {
    
    public static void main(String[] args) {
        loggerInstance();
        logStatus();
        logLevel();
    }
    
    /**
     * 测试log级别，继承父类的级别
     */
    private static void logLevel(){
        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.foo");
        logger.setLevel(Level.INFO);
        
        Logger barlogger = LoggerFactory.getLogger("com.foo.Bar");

        // This request is enabled, because WARN >= INFO
        logger.warn("Low fuel level.");

        // This request is disabled, because DEBUG < INFO.
        logger.debug("Starting search for nearest gas station.");

        // The logger instance barlogger, named "com.foo.Bar",
        // will inherit its level from the logger named
        // "com.foo" Thus, the following request is enabled
        // because INFO >= INFO.
        barlogger.info("Located nearest gas station.");

        // This request is disabled, because DEBUG < INFO.
        barlogger.debug("Exiting gas station search");
    }
    
    /**
     * 打印日志的内部状态
     */
    private static void logStatus(){
        Logger logger = LoggerFactory.getLogger(HelloWordLog.class);
        logger.debug("hello word!");
        LoggerContext  iLoggerFactory = (LoggerContext)LoggerFactory.getILoggerFactory();
        StatusPrinter.print(iLoggerFactory);
    }
    
    /**
     * 得到log的实例，打印日志
     */
    private static void loggerInstance() {
        Logger logger = LoggerFactory.getLogger(HelloWordLog.class);
        logger.debug("hello word!");
    }
    
}
