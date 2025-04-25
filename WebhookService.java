package com.example.bajajproject.service;

import com.example.bajajproject.api.model.WebhookResponse;
import com.example.bajajproject.api.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class WebhookService {

    private final RestTemplate restTemplate;

    public WebhookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void fetchWebhookData() {
        String url = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook";
        String requestBody = "{\n" +
                "\"name\": \"John Doe\",\n" +
                "\"regNo\": \"REG12347\",\n" +
                "\"email\": \"john@example.com\"\n" +
                "}";
        WebhookResponse response = restTemplate.postForObject(url, requestBody, WebhookResponse.class);

        String webhookUrl = response.getWebhook();
        String accessToken = response.getAccessToken();
        WebhookResponse.Data data = response.getData();

        // Process data here...
    }
}
