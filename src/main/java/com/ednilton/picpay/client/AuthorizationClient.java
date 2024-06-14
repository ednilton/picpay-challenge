package com.ednilton.picpay.client;


import com.ednilton.picpay.client.dto.AuthorizationResponse;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "AuthorizationClient",
        url = "${client.authorization-service.url}"
)

public interface AuthorizationClient {

    @GetMapping
    ResponseEntity<AuthorizationResponse> isAuthorized();

}