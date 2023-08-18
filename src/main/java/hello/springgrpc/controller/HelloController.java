package hello.springgrpc.controller;

import hello.springgrpc.service.HelloClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    private final HelloClientService helloClientService;

    @Autowired
    public HelloController(HelloClientService helloClientService) {
        this.helloClientService = helloClientService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String helloApi(@RequestParam("name") String name) {
        return helloClientService.sendMessage(name);
    }
}
