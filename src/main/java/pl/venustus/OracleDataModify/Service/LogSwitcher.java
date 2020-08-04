package pl.venustus.OracleDataModify.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogSwitcher {

    @Autowired
    private DynamicRollingLogFile dynamicRollingLogFile;

    public void writeLog(String logType, String logText) {
        switch (logType) {
            case "info":
                dynamicRollingLogFile.makeLogger().warn(logText);
                System.out.println("logged info");
                break;
            case "warn":
                dynamicRollingLogFile.makeLogger().warn(logText);
                System.out.println("logged warn");
                break;
            case "error":
                dynamicRollingLogFile.makeLogger().error(logText);
                System.out.println("logged error");
                break;
        }
    }
}
