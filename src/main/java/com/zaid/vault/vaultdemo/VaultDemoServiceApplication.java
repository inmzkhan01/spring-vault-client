package com.zaid.vault.vaultdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class VaultDemoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VaultDemoServiceApplication.class, args);
    }

    @Value("${username:}")
    private String username;

    @Value("${username:}")
    private String password;

    @GetMapping
    public Mono<?> getCredential() {
        Map<String, String> credential = new HashMap<>();
        credential.put("username", username);
        credential.put("password", password);
        return Mono.just(credential);
    }

}
