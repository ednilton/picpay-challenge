package com.ednilton.picpay.controller;

import com.ednilton.picpay.dto.TransferDto;
import com.ednilton.picpay.entity.Transfer;
import com.ednilton.picpay.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer (@RequestBody @Valid TransferDto transferDto){
        var resp = transferService.transfer(transferDto);

        return ResponseEntity.ok(resp);
    }
}
