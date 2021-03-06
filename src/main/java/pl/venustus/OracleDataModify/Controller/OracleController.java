package pl.venustus.OracleDataModify.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.venustus.OracleDataModify.Service.OracleService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class OracleController {


    @Autowired
    OracleService oracleService;

    @RequestMapping(method = RequestMethod.GET, value = "/getnotinvoicedor")
    public List<String> getNotInvoicedOr(@RequestParam("name") String name, @RequestParam("data0") String data0, @RequestParam("data1") String data1) throws IOException, SQLException {
        return oracleService.executeSelectStatusByVariable(name, data0, data1);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/marknotinvoicedor")
    public String markNotInvoicedOr(@RequestParam("name") String name, @RequestParam("data0") String data0, @RequestParam("data1") String data1, @RequestParam("iscorrection") Boolean iscorrection) throws IOException, SQLException {
        return oracleService.executeSetStatusByVariable(name, data0, data1, iscorrection);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getallusertables")
    public List<String> getAllUserTables() throws IOException, SQLException {
        return oracleService.selectAllUserTables();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getalltablecolums")
    public List<String> getAllTableColumns(@RequestParam("tablename") String tablename) throws SQLException {
        return oracleService.selectAllColumsFromTable(tablename);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userqueryresult")
    public List<String> getDataFromUserQuery(@RequestParam("tablename") String tablename,
                                             @RequestParam("columnname") String columnname,
                                             @RequestParam("columnvalue") String columnvalue)
            throws SQLException {
        return oracleService.getDataFromUserSelect(tablename, columnname, columnvalue);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/updateuserqueryresult")
    public String updateDataFromUserQuery(@RequestParam("tablename") String tablename,
                                          @RequestParam("columnname") String columnname,
                                          @RequestParam("oldcolumnvalue") String oldcolumnvalue,
                                          @RequestParam("newcolumnvalue") String newcolumnvalue)
            throws SQLException {
        return oracleService.updateDataFromUserSelect(tablename, columnname, oldcolumnvalue, newcolumnvalue);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getcounteddatafromuserselect")
    public String getCountedDataFromUserQuery(@RequestParam("tablename") String tablename,
                                              @RequestParam("columnname") String columnname,
                                              @RequestParam("columnvalue") String columnvalue)
            throws SQLException {
        return oracleService.getCountedDataFromUserSelect(tablename, columnname, columnvalue);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getconnectioninfo")
    public String getConnectionInvo() {
        return oracleService.getConnectionInfo();
    }
}
