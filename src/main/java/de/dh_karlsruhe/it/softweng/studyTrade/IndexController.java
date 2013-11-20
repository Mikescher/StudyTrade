package de.dh_karlsruhe.it.softweng.studyTrade;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String printWelcome() {
        return "index";
    }
}
