package pl.venustus.OracleDataModify.Service;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class OracleFileLogger {
    @Service
    public class DynamicRollingLogFile2 {

    @Autowired
    DynamicRollingLogFile2 dynamicRollingLogFile2;

        public void makeLogger(String logType, String logText) {

            switch (logType) {
                case "info":
                    dynamicRollingLogFile2 .warn(logText);
                    System.out.println("logged info");
                    break;
                case "warn":
                    loggerObj.warn(logText);
                    System.out.println("logged warn");
                    break;
                case "error":
                    loggerObj.error(logText);
                    System.out.println("logged error");
                    break;
            }
        }
    }