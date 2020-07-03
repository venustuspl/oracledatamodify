package pl.venustus.OracleDataModify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class OracleController {


    @Autowired
    OracleConnection oracleConnection;

    @RequestMapping(method = RequestMethod.GET, value = "/check")
    public String getDbInfo() throws IOException, SQLException {
        return oracleConnection.makeConnection();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getallfrometaty")
    public String getAllFromEtaty() throws IOException, SQLException {
        return oracleConnection.executeSelectStatement();
    }


}
