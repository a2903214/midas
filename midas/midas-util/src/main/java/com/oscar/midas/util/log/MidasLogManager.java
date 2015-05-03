package com.oscar.midas.util.log;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Configurator;

public class MidasLogManager {
    private static Map<String, MidasLogger> loggerMap = new HashMap<String, MidasLogger>();
    private static Lock mapLock = new ReentrantLock();

    private static final String defaultConfigName = MidasLogManager.class.getName();

    private static LoggerContext loggerConfig;

    private static Configuration configuration;

    public static void initLoggerConfig() {
        initLoggerConfig("log4j2.xml");
    }

    public static void initLoggerConfig(String logConfigPath) {
        loggerConfig = Configurator.initialize(defaultConfigName, logConfigPath);
        configuration = loggerConfig.getConfiguration();
    }

    public static MidasLogger getLogger(String name) {
        if (null == loggerConfig) {
            synchronized (MidasLogManager.class) {
                if (null == loggerConfig) {
                    initLoggerConfig();
                }
            }
        }
        MidasLogger logger = loggerMap.get(name);
        if (null == logger) {
            mapLock.lock();
            try {
                logger = loggerMap.get(name);
                if (null == logger) {
                    logger = new MidasLogger(name, loggerConfig);
                    loggerMap.put(name, logger);
                }
            } finally {
                mapLock.unlock();
            }
        }
        return logger;
    }

    public static Map<String, MidasLogger> getLoggers() {
        return Collections.unmodifiableMap(loggerMap);
    }

    public static void setLogLevel(String name, String level) {
        getLogger(name).getLogger().setLevel(Level.getLevel(level));
    }

    public static Map<String, String> getAppenders() {
        Map<String, String> ret = new HashMap<String, String>();
        for (String appenderName : configuration.getAppenders().keySet()) {
            ret.put(appenderName, configuration.getAppender(appenderName).getClass().toString());
        }
        return ret;
    }
}
