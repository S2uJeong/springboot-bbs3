package com.example.bbs3.controller;

import com.example.bbs3.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * PUT API는 웹 애플리케이션 서버를 통해 데이터베이스 같은 저장소에 존재하는 리소스 값을 업데이트 하는데 사용
 */
@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + ":" + map.getValue() + "\n");
        });
        return sb.toString();
    }
    // 2. Dto를 활용해서 값 받기
     // 2.1. String으로 반환 text/plain
    @PutMapping (value = "/member1")
    public String postMemnerDto1(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
     //2.2. Dto로 반환 application/json
    @PutMapping (value = "/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto) {
        return memberDto;
    }
    // 2.3. ResponseEntity 로 반환
    /**
     *  스프링 프레임워크에는 HTTPEntity라는 클래스가 있는데 이 클래스는 헤더와 바디로 구성된 HTTP 요청과 응답을 구성하는 역할을 수행한다.
     *  RequestEntity와 ResponseEntity는 HTTPEntity를 상속받아 구현됐다.
     */
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)  // 응답코드 202
                .body(memberDto);
    }
}
