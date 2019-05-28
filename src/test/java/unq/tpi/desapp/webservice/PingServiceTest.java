package unq.tpi.desapp.webservice;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PingService.class)
@AutoConfigureMockMvc
public class PingServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPong() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ping")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
