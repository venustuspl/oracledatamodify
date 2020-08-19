package pl.venustus.OracleDataModify.Service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OracleServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OracleService oracleService;


    List<String> resultList = new ArrayList();

    @Before
    void setUp() {

    }

    @Test
    void executeSelectStatusByVariable() throws Exception {
        resultList.add("A");
        //Given
        when(oracleService.executeSelectStatusByVariable("A", "2020-01-01", "2021-01-01")).thenReturn(resultList);

        //When & Then
        mockMvc.perform(get("/http://localhost:9091/getnotinvoicedor?name=A&data0=2020-01-01&data1=2021-01-01").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void executeSetStatusByVariable() {
    }

    @Test
    void selectAllUserTables() {
    }

    @Test
    void selectAllcolumsFromTable() {
    }

    @Test
    void getDataFromUserSelect() {
    }

    @Test
    void updateDataFromUserSelect() {
    }
}