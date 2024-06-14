package com.ednilton.picpay.client;

import com.ednilton.picpay.entity.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "NotificationClient",
        url = "${client.notification-service}"
)

public interface NotificationClient {

    @PostMapping
    ResponseEntity<Void> sendNotification(Transfer Transfer);
}
