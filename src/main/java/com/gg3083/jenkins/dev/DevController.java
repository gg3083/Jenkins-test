package com.gg3083.jenkins.dev;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GG
 * @date 2019/2/26 20:43
 */
@RestController
public class DevController {

    @GetMapping("dev")
    public String dev(){
        return "Dev";
    }
}
