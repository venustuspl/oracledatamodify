package pl.venustus.OracleDataModify.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.venustus.OracleDataModify.Service.OracleServices;

import java.io.IOException;
import java.sql.SQLException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class OracleController {


    @Autowired
    OracleServices oracleServices;

    @RequestMapping(method = RequestMethod.GET, value = "/check")
    public String getDbInfo() throws IOException, SQLException {
        return "test"; //oracleConnection.makeConnection();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getallfrometaty")
    public String getAllFromEtaty() throws IOException, SQLException {
        return oracleServices.executeSlectStatement();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/setplacaminformechanics")
    public String setPlacaMinForMechanics() throws IOException, SQLException {
        return oracleServices.executeSetStatus();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/setplacadodforanyone")
    public String setPlacaDodForAnyone() throws IOException, SQLException {
        return oracleServices.executeSetStatusByVariable();
    }

}
