package com.start.diary;

import com.start.diary.controllers.MainController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {
    @Autowired
    MainController mainController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void mainControllerIsExist() throws Exception {
        assertThat(mainController).isNotNull();
    }

    @Test
    public void contextLoads() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Kek")));
    }

    @Test
    public void correctLoginTest() throws Exception {
        this.mockMvc.perform(formLogin().user("A").password("1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/"));
    }

    @Test
    public void badCredentials() throws Exception {
        this.mockMvc.perform(post("/login").param("username", "jonh"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }


}
