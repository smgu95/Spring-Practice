package hello.study.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.study.common.MyLogger;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
	
	private final LogDemoService logDemoService;
	private final MyLogger myLogger;
	
	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) {
		
		String requestURL = request.getRequestURL().toString();
		myLogger.setRequestURL(requestURL);
		System.out.println(myLogger.getClass());
		
		myLogger.log("controller test");
		logDemoService.logic("testId");
		
		return "ok";
	}

}
