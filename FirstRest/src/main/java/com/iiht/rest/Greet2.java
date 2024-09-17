package com.iiht.rest;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api2.0")
public class Greet2 {
 
	@GetMapping
	@RequestMapping("/message")
	public ResponseEntity<String> message() {
		ResponseEntity<String> response=new ResponseEntity<>("OLA!Commo Sava",HttpStatus.OK);
		return response;
	}
	
	
	
	
	@GetMapping
	@RequestMapping("/time")
	public ResponseEntity<String> getTime() {
		
				return ResponseEntity.status(HttpStatus.OK).body(Calendar.getInstance().getTime()+"");
	}
	
	
	@GetMapping
	@RequestMapping("/{gender}")
	public String genderMessage(@PathVariable String gender) {
		if (gender.equals("Female")) {
			return "Welcome Miss";
		}
		if(gender.equals("Male")) {
			return "Welcome Mr";
		}
		else {
			return "Welcome";
		}
	}
	
	
	@GetMapping
	@RequestMapping("/{name}/{gender}")
	public ResponseEntity<String> genderMessage2(@RequestHeader HttpHeaders headers,@PathVariable String gender,@PathVariable String name) {
		//HttpHeaders headers=new HttpHeaders();
		
		Set set=headers.keySet();
		Iterator<String> keys=set.iterator();
		String keyStr=null;
		while(keys.hasNext()) {
			keyStr+=keys.next()+"\n";
		}
		
		String keyValueStr=null;
		
		Set<Entry<String,List<String>>> entries=headers.entrySet();
		
		Iterator iter2=entries.iterator();
		
		while(iter2.hasNext()) {
			keyValueStr+=iter2.next()+"\n";
		}
		//return keyValueStr;
		HttpHeaders headers2=new HttpHeaders();
		
		
		//headers2.setAcceptLanguageAsLocales(null);
		headers2.setAcceptCharset((List<Charset>)Charset.defaultCharset());
		headers2.setContentType(MediaType.TEXT_HTML);
		headers2.setContentLength(keyValueStr.length());
		headers2.set("UST",  "Gamma training room 6");
		
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers2).body(keyValueStr);
	    
	}
	
	@PostMapping
	@RequestMapping("/namegender")
	public ResponseEntity<Member> genderMessage3(@RequestBody Member member) {
		member.setName(member.getName()+" Hello");
		
		return ResponseEntity.ok(member);
		
		
		
//		if(member.getGender().equals("Female")) {
//			return ResponseEntity.ok("Welcome Miss "+member.getName());
//		}
//		if(member.getGender().equals("Male")) {
//			return ResponseEntity.ok("Welcome Mr "+member.getName());
//		}
//		else {
//			return ResponseEntity.ok("Welcome "+member.getName());
//		}
	}
	
}
