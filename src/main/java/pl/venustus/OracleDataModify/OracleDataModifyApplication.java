package pl.venustus.OracleDataModify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class OracleDataModifyApplication {
    public static void main(String[] args) {
        SpringApplication.run(OracleDataModifyApplication.class, args);
        SpringApplicationBuilder app = new SpringApplicationBuilder(OracleDataModifyApplication.class)
                .web(WebApplicationType.NONE);
        app.build().addListeners(new ApplicationPidFileWriter("./bin/shutdown.pid"));
        app.run();
    }
}
