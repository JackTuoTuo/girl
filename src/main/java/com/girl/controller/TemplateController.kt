package com.girl.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class TemplateController {

    @RequestMapping("/helloHtml")
    fun helloHtml(map: MutableMap<String, Any>): String {
        map.put("hello", "from TemplateController.helloHtml")
        return "/oneGirl"
    }
}