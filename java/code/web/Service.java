package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class Home {
    @GetMapping("/")
    String showHome(){
        return "home";   // home.html
    }
    
    @GetMapping("/status") @ResponseBody
     Status showStatus() {
         Runtime r = Runtime.getRuntime();
         return new Status("OK",
                 r.freeMemory(), r.totalMemory());
    }
}

record Status(String status, long free, long total) { }