package com.savingfootprints.savingfootprints.controllers.service.user;

import com.fasterxml.jackson.databind.JsonNode;
import com.savingfootprints.controllers.service.ValidatorHandler;
import com.savingfootprints.controllers.service.user.UserController;
import com.savingfootprints.controllers.service.user.UserDTO;
import com.savingfootprints.model.User;
import com.savingfootprints.savingfootprints.controllers.service.BaseIntegration;
import com.savingfootprints.usecase.UserUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        ValidatorHandler.class,
        UserController.class
})
class UserControllerTest extends BaseIntegration {
    @MockBean
    private UserDTO userDTO;
    @MockBean
    private UserUseCase useCase;
    private String request;
    private User user = new User();
    private static final String url = "/user/";


    @BeforeEach
    void init() {
        request = loadFileConfig("user.json", String.class);
    }

    @Test
    void postUserTestSuccess() {
        when(useCase.saveUser(any()))
                .thenReturn(Mono.just(user));

        statusAssertionsWebClientPost(url, request)
                .isOk()
                .expectBody(JsonNode.class)
                .returnResult();
        verify(useCase).saveUser(any());
    }

    @Test
    void getAllUsers() {
        when(useCase.getAllUsers())
                .thenReturn(Mono.just(List.of(user)));

        final WebTestClient.ResponseSpec spec = webTestClient.get()
                .uri(url).exchange();
        spec.expectStatus().isOk();

        verify(useCase).getAllUsers();
    }

    @Test
    void getById() {
        when(useCase.getById(any()))
                .thenReturn(Mono.just(user));

        final WebTestClient.ResponseSpec spec = webTestClient.get()
                .uri(url + "1").exchange();
        spec.expectStatus().isOk();

        verify(useCase).getById(any());
    }
}
