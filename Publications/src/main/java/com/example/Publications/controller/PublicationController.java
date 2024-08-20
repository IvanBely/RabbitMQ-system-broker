package com.example.Publications.controller;

import com.example.Publications.dto.request.NewRequest;
import com.example.Publications.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PublicationController {
    private final PublicationService publicationService;
    @PostMapping("/publish")
    public ResponseEntity<String> publishPost(@RequestBody NewRequest request) {
        publicationService.publish(request);
        return ResponseEntity.ok("Post published successfully");
    }
}
