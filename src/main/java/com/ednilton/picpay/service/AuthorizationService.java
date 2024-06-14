package com.ednilton.picpay.service;

import com.ednilton.picpay.client.AuthorizationClient;
import com.ednilton.picpay.dto.TransferDto;
import com.ednilton.picpay.exception.PicPayException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDto transfer){

        var resp = authorizationClient.isAuthorized();

        if (resp.getStatusCode().isError()){
            throw new PicPayException();
        }

     return resp.getBody().authorized();
    }
}
