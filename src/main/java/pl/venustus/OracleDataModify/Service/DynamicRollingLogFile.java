package pl.venustus.OracleDataModify.Service;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.stereotype.Service;

@Service
public class DynamicRollingLogFile {

    public void makeLogger(String logType, String logText) {
        // Creates Pattern Layout
        // Creates Pattern Layout
        PatternLayout patternLayoutObj = new PatternLayout();
        String conversionPattern = "[%p] %d %c %M - %m%n";
        patternLayoutObj.setConversionPattern(conversionPattern);

        // Create Daily Rolling Log File Appender
        DailyRollingFileAppender rollingAppenderObj = new DailyRollingFileAppender();
        rollingAppenderObj.setFile("bin/OracleApp.log");
        rollingAppenderObj.setDatePattern("yyyy-MM-dd'.log'");
        rollingAppenderObj.setLayout(patternLayoutObj);
        rollingAppenderObj.activateOptions();

        // Configure the Root Logger
        Logger rootLoggerObj = Logger.getRootLogger();
        rootLoggerObj.setLevel(Level.DEBUG);
        rootLoggerObj.addAppender(rollingAppenderObj);

        // Create a Customer Logger & Logs Messages
        Logger loggerObj = Logger.getLogger(DynamicRollingLogFile.class);

        switch (logType) {
            case "info":
                loggerObj.warn(logText);
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
