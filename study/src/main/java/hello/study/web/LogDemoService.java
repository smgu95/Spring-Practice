package hello.study.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import hello.study.common.MyLogger;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogDemoService {
	private final MyLogger logger;
	public void logic(String id) {
		// TODO Auto-generated method stub
		logger.log("service id = " + id);
	}

}
