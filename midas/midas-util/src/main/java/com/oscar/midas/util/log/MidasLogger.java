package com.oscar.midas.util.log;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;

public class MidasLogger {
    private Logger logger;

    public MidasLogger(String logger, LoggerContext loggerContext) {
        this.logger = loggerContext.getLogger(logger);
    }

    Logger getLogger() {
        return logger;
    }

    public void debug(Object message) {
        logger.debug(message);
    }

    public void debug(Object message, Throwable t) {
        logger.debug(message, t);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void debug(String message, Object... params) {
        logger.debug(message, params);
    }

    public void debug(String message, Throwable t) {
        logger.debug(message, t);
    }

    public void entry() {
        logger.entry();
    }

    public void entry(Object... params) {
        logger.entry(params);
    }

    public void error(Object message) {
        logger.error(message);
    }

    public void error(Object message, Throwable t) {
        logger.error(message, t);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void error(String message, Object... params) {
        logger.error(message, params);
    }

    public void error(String message, Throwable t) {
        logger.error(message, t);
    }

    public void exit() {
        logger.exit();
    }

    public <R> R exit(R result) {
        return logger.exit(result);
    }

    public void fatal(Object message) {
        logger.fatal(message);
    }

    public void fatal(Object message, Throwable t) {
        logger.fatal(message, t);
    }

    public void fatal(String message) {
        logger.fatal(message);
    }

    public void fatal(String message, Object... params) {
        logger.fatal(message, params);
    }

    public void fatal(String message, Throwable t) {
        logger.fatal(message, t);
    }

    public String getLevel() {
        return logger.getLevel().toString();
    }

    public String getName() {
        return logger.getName();
    }

    public void info(Object message) {
        logger.info(message);
    }

    public void info(Object message, Throwable t) {
        logger.info(message, t);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void info(String message, Object... params) {
        logger.info(message, params);
    }

    public void info(String message, Throwable t) {
        logger.info(message, t);
    }

    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    public boolean isFatalEnabled() {
        return logger.isFatalEnabled();
    }

    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    public <T extends Throwable> T throwing(T t) {
        return logger.throwing(t);
    }

    public void trace(Object message) {
        logger.trace(message);
    }

    public void trace(Object message, Throwable t) {
        logger.trace(message, t);
    }

    public void trace(String message) {
        logger.trace(message);
    }

    public void trace(String message, Object... params) {
        logger.trace(message, params);
    }

    public void trace(String message, Throwable t) {
        logger.trace(message, t);
    }

    public void warn(Object message) {
        logger.warn(message);
    }

    public void warn(Object message, Throwable t) {
        logger.warn(message, t);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void warn(String message, Object... params) {
        logger.warn(message, params);
    }

    public void warn(String message, Throwable t) {
        logger.warn(message, t);
    }

    public String toString() {
        return this.logger.toString();
    }

    public int hashCode() {
        return this.logger.hashCode();
    }

    public boolean equals(Object obj) {
        if (MidasLogger.class.isInstance(obj)) {
            return this.logger.equals(MidasLogger.class.cast(obj).logger);
        } else {
            return false;
        }
    }

}
