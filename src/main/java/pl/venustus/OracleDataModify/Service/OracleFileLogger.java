package pl.venustus.OracleDataModify.Service;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OracleFileLogger {

    @Autowired
    DynamicRollingLogFile2 dynamicRollingLogFile2;

        public void makeLogger(String logType, String logText) {

            dynamicRollingLogFile2.makeLoggerObj().debug(logText);

//            switch (logType) {
//                case "info":
//                    dynamicRollingLogFile2.makeLoggerObj().info(logText);
//                    System.out.println("DRL2 logged info");
//                    break;
//                case "warn":
//                    dynamicRollingLogFile2.makeLoggerObj().warn(logText);
//                    System.out.println("logged warn");
//                    break;
//                case "error":
//                    dynamicRollingLogFile2.makeLoggerObj().error(logText);
//                    System.out.println("logged error");
//                    break;
//            }
        }
    }