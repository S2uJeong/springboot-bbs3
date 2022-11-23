package com.example.bbs3.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Delete는 Get방식과 비슷하게 값을 전달 받는다.
 */
@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
    // 1. PathVariable
    @DeleteMapping(value = "/{variable}")
    public String deleteVariable(@PathVariable String variable) {
        return variable;
    }
    // 2. RequestParam
    @DeleteMapping (value = "/request1")
    public String getRequestParam1(@RequestParam String email) {
        return "e-mail : " + email;
    }
}
