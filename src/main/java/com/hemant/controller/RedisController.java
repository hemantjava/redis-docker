package com.hemant.controller;

import com.hemant.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PostMapping("/set")
    public String setKeyValue(@RequestParam String key, @RequestParam String value) {
        redisService.saveValue(key, value, 60); // Expires in 60 seconds
        return "Key-Value pair saved!";
    }

    @GetMapping("/get")
    public String getKeyValue(@RequestParam String key) {
        return redisService.getValue(key);
    }
}

