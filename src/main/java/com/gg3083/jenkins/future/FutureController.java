package com.gg3083.jenkins.future;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GG
 * @date 2019/2/26 20:46
 */
@RestController
public class FutureController {
    
    @GetMapping
    public String future(){
        return "future";
    }
    
}
