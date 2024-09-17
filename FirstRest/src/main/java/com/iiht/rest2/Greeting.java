package com.iiht.rest2;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest2/api")
public class Greeting {

	@GetMapping("/{msg}/{name}")
	public ResponseEntity<?> getMessage(@RequestHeader HttpHeaders headers, @PathVariable String msg,@PathVariable String name){
		
		
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
		headers.setAcceptLanguageAsLocales(null);
		headers2.setContentType(MediaType.TEXT_HTML);
		headers2.setContentLength(keyValueStr.length());
		headers2.set("UST",  "Gamma training room 6");
		
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers2).body(keyValueStr);
	    
	}
}
