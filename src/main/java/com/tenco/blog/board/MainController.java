package com.tenco.blog.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // 주소설계
    // http://localhost:8080/main-page

    @GetMapping("mainpage")
    public String mainPage() {
        System.out.println("mainPage() 메서드 호출 확인");

        return "mainPage"; // /WEB-INF/view/mainPage.jsp를 반환
    }
}
