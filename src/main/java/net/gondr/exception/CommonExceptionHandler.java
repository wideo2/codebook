package net.gondr.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("net.gondr.controller")
public class CommonExceptionHandler {
	@ExceptionHandler
	public String handlException(Exception e, Model model)
	{
		model.addAttribute("title", "에러 클래스 : " + e.getClass().getName());
		model.addAttribute("errorMsg", e.getMessage());
		e.printStackTrace();
		return "errorpage";
	}
}
