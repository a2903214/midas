package com.oscar.midas.util.log;

import org.junit.Test;

public class TestLog4j {
    public static final MidasLogger logger1 = MidasLogManager.getLogger("testlog1");
    public static final MidasLogger logger1_1 = MidasLogManager.getLogger("testlog1");
    public static final MidasLogger logger2 = MidasLogManager.getLogger("testlog2");

    @Test
    public void testLogger() {
        logger1.debug("abc");
    }

    @Test
    public void testPrintAllLogger() {
        for (MidasLogger logger : MidasLogManager.getLoggers().values()) {
            System.out.print(logger.getName() + ":" + logger.getLevel());
            System.out.println();
        }
    }

    @Test
    public void testChangeLevel() {
        logger1.debug("abc");
        MidasLogManager.setLogLevel(logger1.getName(), "ERROR");
        logger1.debug("abc____debug");
        logger1.error("abc____error");
        testPrintAllLogger();

        System.out.println(MidasLogManager.getAppenders());
    }

}
