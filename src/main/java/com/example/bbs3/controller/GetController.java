package com.example.bbs3.controller;

import com.example.bbs3.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
/**
 * @RequestMapping 어노테이션을 별다른 설정 없이 선언하면 HTTP의 모든 요청을 받는다.
 * 이를 방지하기 위해, 어노테이션의 mehthod 요소의 값을 RequestMethod.GET 으로 설정한다.
 * -> 스프링 4.3 이후로는 각 메서드에 맞는 어노테이션이 나옴 @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
 */
 // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello World";
    }
    // 1. 매개변수 없는 GET 메서드 구현 <링크> http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName() {
        return "sujeong";
    }
    // 2. 매개변수 있는 GET 메서드 구현 *일반적 <링크> http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping (value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }
    // 2.1. {키}:{값} 형식으로 받는 방법 <링크> http://localhost:8080/api/v1/get-api/request1?name=sujeong&email=mail&organization=or
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // 2.2. Dto 를 통해 가독성을 높인 방법 <링크> http://localhost:8080/api/v1/get-api/request3?name=sujeong&email=mail&organization=or
    @GetMapping (value = "/request3")
    public String getRequestParam3 (MemberDto memberDto){
        return memberDto.toString();
    }

    // 2.3. 어떤 값이 들어올지 정확치 않을때 <링크> http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    // ex) 회원가입시 필수 아닌 항목은 비워져 올 수 있다.
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
           sb.append(map.getKey() + ":" + map.getValue() + "\n");
        });
        return sb.toString();
    }
}
