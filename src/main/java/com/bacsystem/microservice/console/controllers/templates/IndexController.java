package com.bacsystem.microservice.console.controllers.templates;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController
 * <p>
 * IndexController class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 30/09/2024
 */

@Log4j2
@Controller
public class IndexController {

    @GetMapping(value = {"/", "/index"})
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("title", "Index");
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath(request.getContextPath());
        log.info("path {}", request.getContextPath());
        log.info("cookie {}", cookie);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        log.info("response {}", response);

        return "index";
    }
}
