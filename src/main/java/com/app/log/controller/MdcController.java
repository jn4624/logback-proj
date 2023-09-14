package com.app.log.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MdcController {
    @GetMapping("mdc")
    public String mdc() {
        /**
         * MDC란?
         * 멀티쓰레드 환경에서 로그를 남길 때 사용하는 개념
         * 파일 단위에 있어서 완전 전역 변수
         * 멀티 쓰레드 환경에서 쓰레드마다 고유한 로그값을 가지고 있고 그 값을 로그백에 전달해주기 위한 개념
         */
        MDC.put("job", "dev");

        log.trace("log -> TRACE");
        log.debug("log -> DEBUG");
        log.info("log -> INFO");
        log.warn("log -> WARN");
        log.error("log -> ERROR");

        /**
         * MDC를 클리어하지 않고 다른 요청이 동일한 쓰레드를 참조를 하면
         * value가 변경되지 않을 수 있으므로 put과 clear를 페어 단위로 사용하는 것을 권장
         */
        MDC.clear();

        return "mdc";
    }
}
