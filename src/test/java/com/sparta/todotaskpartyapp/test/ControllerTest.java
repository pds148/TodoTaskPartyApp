package com.sparta.todotaskpartyapp.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.todotaskpartyapp.security.UserDetailsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ControllerTest implements TodoTaskTest {

    private WebApplicationContext context;


    protected MockMvc mockMvc;


    protected ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

        // Mock 테스트 UserDetails 생성
        UserDetailsImpl testUserDetails = new UserDetailsImpl(TEST_USER);

        // SecurityContext 에 인증된 사용자 설정
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                testUserDetails, testUserDetails.getPassword(), testUserDetails.getAuthorities()));
    }
}