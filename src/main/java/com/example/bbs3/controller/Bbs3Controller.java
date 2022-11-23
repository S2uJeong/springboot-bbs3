package com.example.bbs3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 컨트롤러에 포함된 로직에서는 어플리케이션의 사용자 또는 클라이언트가 입력한 값에 대한 응답을 수행한다.
 * 특별한 경우를 제외한 모든 요청은 컨트롤러를 통해 진행돼야 한다.
 */
@RestController
public class Bbs3Controller {

    @RequestMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
}
