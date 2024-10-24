package com.typeConverter.controller;

import com.typeConverter.type.IpPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

@GetMapping("/hello-v2")
public String hellov2(@RequestParam("data") Integer data){
    System.out.println("data= "+data);

    return "ok";
}

   @GetMapping("/ipport")
    public String hellov2(@RequestParam("ipPort") IpPort ipPort){
        System.out.println("ip= "+ipPort);

        return "ok";
    }

}
