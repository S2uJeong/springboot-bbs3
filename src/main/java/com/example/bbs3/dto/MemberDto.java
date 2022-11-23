package com.example.bbs3.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO란? - 각 클래스 및 인터페이스를 호출하면서 전달하는 매개변수로 사용되는 데이터 객체, 레이어간의 데이터 교환에 활용
 */
@Getter @Setter
public class MemberDto {
    private String name;
    private String email;
    private String organization;

    @Override
    public String toString() {
        return "MemberDto{"+
                "name='" + name + '\'' +
                ", email ='" + email + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }
}
