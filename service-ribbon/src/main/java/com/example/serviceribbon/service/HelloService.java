package com.example.serviceribbon.service;

import com.example.serviceribbon.dto.NameValue;
import com.example.serviceribbon.dto.ResponseDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface HelloService {
    String hiService(String name);

    ResponseDto test(String name);

    ResponseDto testException(String name);

    ResponseDto testException1(String name);

    NameValue getForEntityIdentifyByType(String name);
}
