package gukjin.springlecturebasic.web;


import com.sun.net.httpserver.HttpServer;
import gukjin.springlecturebasic.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @ResponseBody
    @RequestMapping("log-demo")
    private String logDemo(HttpServletRequest req) {
            String requestUrl = req.getRequestURL().toString();
            myLogger.setRequestURL(requestUrl);
            myLogger.log("Controller Test");
            logDemoService.logic("test id");
            return "ok";
    }
}
