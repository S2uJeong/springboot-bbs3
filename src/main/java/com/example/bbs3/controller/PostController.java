package com.example.bbs3.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * POST API는 웹 애플리케이션을 통해 데이터베이스 등의 저장소에 리소스를 저장할 때 사용된다.
 * Get에서는 URL의 경로나 파라미터에 변수를 넣어 요청을 보냈지만 POST는 저장하고자 하는 리소스 값을 HTTP 바디에 담아 서버에 전달한다. 그래서 비교적 간단함
 */
@RestController
@RequestMapping(value = "/api/v1/post-api")
public class PostController {
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    // 1. @RequestBody 와 Map을 활용한 구현 <링크> http://localhost:8080/api/v1/post-api/member
    // @RequestBody는 HTTP의 Body 내용을 해당 어노테이션이 지정된 객체에 매핑하는 역할을 한다.
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + ":" + map.getValue() + "\n");
        });
        return sb.toString();
    }
}


