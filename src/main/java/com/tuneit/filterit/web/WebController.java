package com.tuneit.filterit.web;

import com.mangofactory.swagger.annotations.ApiIgnore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tegoo on 5/15/15.
 */
@Controller("/")
@ApiIgnore
public class WebController {

    @RequestMapping("/docs")
    public String render(Model model) {
        return "redirect:/docs/index.html";
    }

}