package com.example.chatService.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionList {

    UNKNOWN(-9999, "알 수 없는 오류가 발생하였습니다."),

    EMPTY_USER(-5051, "유저 정보를 입력해 주세요."),
    NOT_CORRECT_USER(-5052, "수강생이 아닙니다. 수강생으로 로그인 다시 부탁드립니다."),
    NOT_ACCESS_USER(-5053, "접근할 수 없는 유저 입니다."),
    EMPTY_JWT(-5054, "토큰이 없습니다. 확인부탁드립니다."),
    NOT_EXISTENT_USER(-5055, "존재하지 않는 유저입니다."),
    NON_EXISTENT_CHECKLIST(5005, "내용이 존재하지 않습니다."),

    // USER
    INVALID_USER_ID(5011, "요청으로 들어온 User의 식별자가 유효하지 않습니다."),

    // Jwt
    NULL_JWT_TOKEN(7000, "토큰이 존재하지 않습니다."),
    EXPIRED_JWT(7001, "만료된 토큰입니다."),
    PREMATURE_JWT(7002, "아직 활성화되지 않은 토큰입니다."),
    UNSUPPORTED_JWT(7003, "지원되지 않는 토큰 형식 또는 구조입니다."),
    MALFORMED_JWT(7004, "토큰의 형식이 잘못되었습니다."),
    SIGNATURE_JWT(7005, "토큰의 서명이 검증되지 않았습니다."),
    ILLEGAL_ARGUMENT_JWT(7006, "잘못된 인자가 전달되었습니다."),
    SECURITY_JWT(7007, "보안 관련 문제로 토큰 검증이 실패했습니다."),

    // 권한
    UNAUTHORIZED_ACCESS(8000, "접근 권한이 없습니다.");

    private final int code;
    private final String message;
}