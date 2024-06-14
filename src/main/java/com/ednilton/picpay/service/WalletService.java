package com.ednilton.picpay.service;

import com.ednilton.picpay.dto.CreateWalletDto;
import com.ednilton.picpay.entity.Wallet;
import com.ednilton.picpay.exception.WalletDataAlreadyExistsException;
import com.ednilton.picpay.repository.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Service
public class WalletService {

    private final WalletRepository repository;

    public WalletService(WalletRepository repository) {
        this.repository = repository;
    }


    public Wallet createWallet(CreateWalletDto dto) {

        var walletDb = repository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());

        if(walletDb.isPresent()){
            throw new WalletDataAlreadyExistsException("CpfCnpj or Email already exists.");
        }

        return repository.save(dto.toWallet());
    }
}
