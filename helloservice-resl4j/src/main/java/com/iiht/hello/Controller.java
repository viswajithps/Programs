package com.iiht.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Controller {

	@GetMapping()
	public String message() {
//		int fact=0;
//		for(int i=number;i>0;i--) {
//			fact=fact*number;
//		}
		return "Factorial of ";
	}
	
//	@GetMapping("even/{number}")
//	public String message2(@PathVariable int number) {
//		
//		if(number%2==0) {
//			return "Number is Even";
//		}else {
//			return "Number is Odd";
//		}
//		
//	}
//	
//	@GetMapping("square/{number}")
//	public String message3(@PathVariable int number) {
//		
//		double num=number *number;
//		return "Square of " +number+"is "+num;
//		
//	}
//	
	
}
