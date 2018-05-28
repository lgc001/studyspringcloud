package com.example.servicehi.controller;

import com.example.servicehi.dto.NameValue;
import com.example.servicehi.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name) {
        return "hi "+name+",i am service-hi from port:" +port;
    }

    @RequestMapping("/index")
    public String index() {
        return "这是 home/index";
    }

    @RequestMapping("/test")
    public ResponseDto test(@RequestParam String name) {
        ResponseDto resp=new ResponseDto();
        resp.setCode("0");
        resp.setMsg("ok");
        NameValue nameValue = new NameValue();
        nameValue.setName("hi "+name);
        nameValue.setValue("i am service-hi-json from port:" +port);
        resp.setContent(nameValue);

        return resp;
    }
    @RequestMapping("/test1")
    public ResponseDto test1(@RequestBody NameValue param) {
        ResponseDto resp=new ResponseDto();
        resp.setCode("0");
        resp.setMsg("ok");
        NameValue nameValue = new NameValue();
        nameValue.setName("hi "+param.getName());
        nameValue.setValue("i am service-hi-json from port:" +param.getValue());
        resp.setContent(nameValue);

        return resp;
    }

    @RequestMapping("/test-exception")
    public ResponseDto testException(@RequestParam String name) {
        ResponseDto resp=new ResponseDto();
        resp.setCode("0");
        resp.setMsg("ok");
        NameValue nameValue = new NameValue();
        nameValue.setName("hi "+name);
        nameValue.setValue("i am service-hi-json from port:" +port);
        resp.setContent(nameValue);

        int a=1;
        int b=0;
        int c=a/b;

        return resp;
    }

    @RequestMapping("/test-exception1")
    public ResponseDto testException1(@RequestParam String name) {
        ResponseDto resp=new ResponseDto();

        try {
            resp.setCode("0");
            resp.setMsg("ok");
            NameValue nameValue = new NameValue();
            nameValue.setName("hi " + name);
            nameValue.setValue("i am service-hi-json from port:" + port);
            resp.setContent(nameValue);

            int a = 1;
            int b = 0;
            int c = a / b;
        }catch (Exception e){
            resp.setCode("1");
            resp.setMsg(e.getMessage());
            resp.setContent(e.toString());
        }

        return resp;
    }
}
