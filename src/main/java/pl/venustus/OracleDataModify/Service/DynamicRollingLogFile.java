package pl.venustus.OracleDataModify.Service;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.stereotype.Service;

@Service
public class DynamicRollingLogFile {

    public Logger makeLogger() {
        // Creates Pattern Layout
        PatternLayout patternLayoutObj = new PatternLayout();
        String conversionPattern = "[%p] %d %c %M - %m%n";
        patternLayoutObj.setConversionPattern(conversionPattern);

        // Create Daily Rolling Log File Appender
        DailyRollingFileAppender rollingAppenderObj = new DailyRollingFileAppender();
        rollingAppenderObj.setFile("OracleApp_");
        rollingAppenderObj.setDatePattern("yyyy-MM-dd'.log'");
        rollingAppenderObj.setLayout(patternLayoutObj);
        rollingAppenderObj.activateOptions();

        //Configure the Root Logger
        Logger rootLoggerObj = Logger.getRootLogger();
        //  rootLoggerObj.setLevel(Level.DEBUG);
        rootLoggerObj.addAppender(rollingAppenderObj);

        // Create a Customer Logger & Logs Messages
        Logger loggerObj = Logger.getLogger(OracleServices.class);
//        loggerObj.debug("This is a debug log message");
//        loggerObj.info("This is an information log message");
//        loggerObj.warn("This is a warning log message");

        return loggerObj;

    }
}
