package com.readingmonitor.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
public class TestLocalAspect {

	private static final Logger logger = LoggerFactory.getLogger(TestLocalAspect.class);

	//@Before("execution(* *(..)) && !within(is(FinalType)) && !within(is(EnumType)) && !within(org.springframework..*)")
	@Before("execution(String com.readingmonitor.controller.LoginController.login(..))")
	public void firstAdvice() {
		logger.debug("\n********\nexec local test aspect!\n*********");
	}
}
