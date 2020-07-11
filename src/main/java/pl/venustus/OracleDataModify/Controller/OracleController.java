package pl.venustus.OracleDataModify.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    //example controller
    @RequestMapping(method = RequestMethod.GET, value = "/getrowwithfulfilled")
    public String getPlacaDodForAnyone(@RequestParam("name") String name, @RequestParam("data0") String data0, @RequestParam("data1") String data1) throws IOException, SQLException  {
        return oracleServices.executeSelectStatusByVariable(name, data0, data1);
    }
    //example controller
    @RequestMapping(method = RequestMethod.GET, value = "/setplacadodforanyone")
    public String setPlacaDodForAnyone(@RequestParam("name") String name, @RequestParam("data0") String data0, @RequestParam("data1") String data1) throws IOException, SQLException  {
        return oracleServices.executeSetStatusByVariable(name, data0, data1);
    }

}
