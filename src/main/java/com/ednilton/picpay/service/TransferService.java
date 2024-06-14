package com.ednilton.picpay.service;

import com.ednilton.picpay.dto.TransferDto;
import com.ednilton.picpay.entity.Transfer;
import com.ednilton.picpay.entity.Wallet;
import com.ednilton.picpay.exception.InsufficentBalanceException;
import com.ednilton.picpay.exception.TransferNotAllowedForWalletTypeException;
import com.ednilton.picpay.exception.TransferNotAuthorizedException;
import com.ednilton.picpay.exception.WalletNotFoundException;
import com.ednilton.picpay.repository.TransferRepository;
import com.ednilton.picpay.repository.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TransferService {

    private final TransferRepository transferRepository;
    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;
    private final WalletRepository walletRepository;

    public TransferService(TransferRepository transferRepository, AuthorizationService authorizationService, NotificationService notificationService, WalletRepository walletRepository) {
        this.transferRepository = transferRepository;
        this.authorizationService = authorizationService;
        this.notificationService = notificationService;
        this.walletRepository = walletRepository;
    }


    @Transactional
    public Transfer transfer(TransferDto transferDto) {

       var sender = walletRepository.findById(transferDto.payer())
                .orElseThrow( () -> new WalletNotFoundException(transferDto.payer()));

       var receiver = walletRepository.findById(transferDto.payee())
                .orElseThrow( () -> new WalletNotFoundException(transferDto.payee()));


       validateTransfer(transferDto, sender);

       sender.debit(transferDto.value());
       receiver.credit(transferDto.value());

       var transfer = new Transfer(sender, receiver, transferDto.value());

        walletRepository.save(sender);
        walletRepository.save(receiver);
        var transferResult = transferRepository.save(transfer);

        CompletableFuture.runAsync(() -> notificationService.sentNotification(transferResult));

       return transferResult;

    }

    private void validateTransfer(TransferDto transferDto, Wallet sender) {

        if (!sender.isTransferAllowedForWalletType()) {
            throw new TransferNotAllowedForWalletTypeException();
        }

        if (!sender.isBalancerEqualOrGreaterThan(transferDto.value())) {
            throw new InsufficentBalanceException();
        }

        if (!authorizationService.isAuthorized(transferDto)){
            throw new TransferNotAuthorizedException();
        }

    }
}
