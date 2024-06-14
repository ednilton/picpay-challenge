package com.ednilton.picpay.config;

import com.ednilton.picpay.entity.WalletType;
import com.ednilton.picpay.repository.WalletRepository;
import com.ednilton.picpay.repository.WalletTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final WalletTypeRepository walletTypeRepository;
    private final WalletRepository walletRepository;

    public DataLoader(WalletTypeRepository walletTypeRepository, WalletRepository walletRepository) {
        this.walletTypeRepository = walletTypeRepository;
        this.walletRepository = walletRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Arrays.stream(WalletType.Enum.values())
                .forEach(walletType -> walletTypeRepository.save(walletType.get()));


    }
}
