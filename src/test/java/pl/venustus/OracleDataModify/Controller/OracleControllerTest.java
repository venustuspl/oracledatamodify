package pl.venustus.OracleDataModify.Controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.venustus.OracleDataModify.Config.OracleConnection;
import pl.venustus.OracleDataModify.Service.OracleServices;

import java.sql.Statement;
import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(OracleController.class)
class OracleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OracleServices oracleServices;

    @MockBean
    OracleConnection oracleConnection;

    @Test
    void getNotInvoicedOr() throws Exception {
        ArrayList list = new ArrayList();
        String name = "A", data0 = "1980-08-01", data1 = "2020-08-01";

        when(oracleConnection.makeConnection().createStatement()).thenReturn((Statement) list);
        when(oracleServices.executeSelectStatusByVariable(name, data0, data1)).thenReturn(list);

        mockMvc.perform(get("/getnotinvoicedor").param(name, data0, data1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void markNotInvoicedOr() {
    }

    @Test
    void getAllUserTables() {
    }

    @Test
    void getAllTableColumns() {
    }

    @Test
    void getDataFromUserQuery() {
    }

    @Test
    void updateDataFromUserQuery() {
    }
}