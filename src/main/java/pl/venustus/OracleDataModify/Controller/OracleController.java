package pl.venustus.OracleDataModify.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.venustus.OracleDataModify.Service.OracleServices;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class OracleController {


    @Autowired
    OracleServices oracleServices;

    @RequestMapping(method = RequestMethod.GET, value = "/getnotinvoicedor")
    public List<String> getPlacaDodForAnyone(@RequestParam("name") String name, @RequestParam("data0") String data0, @RequestParam("data1") String data1) throws IOException, SQLException {
        return oracleServices.executeSelectStatusByVariable(name, data0, data1);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/marknotinvoicedor")
    public String marknotinvoicedor(@RequestParam("name") String name, @RequestParam("data0") String data0, @RequestParam("data1") String data1) throws IOException, SQLException {
        return oracleServices.executeSetStatusByVariable(name, data0, data1);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getallusertables")
    public List<String> getallusertables() throws IOException, SQLException {
        return oracleServices.selectAllUserTables();
    }

}
