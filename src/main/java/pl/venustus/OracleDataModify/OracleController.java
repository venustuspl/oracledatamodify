package pl.venustus.OracleDataModify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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


}
