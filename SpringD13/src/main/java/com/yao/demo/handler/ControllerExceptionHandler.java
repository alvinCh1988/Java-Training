package com.yao.demo.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	/**
	 * 異常處理
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler({Exception.class})
	public ModelAndView handleException(HttpServletRequest req, Exception ex) throws Exception {
		
		logger.error("Request URL : {} , Exception : {}" , req.getRequestURL(), ex.getMessage());
		
		if(AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null) {
			throw ex;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("url", req.getRequestURI());
		mav.addObject("exception", ex);
		mav.setViewName("login");
		
		return mav;
	}

}
