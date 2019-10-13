package sonu.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class PostService {
	@Autowired
	RestTemplate rest;
	@Autowired
	UserDetail detail;
@RequestMapping("/")	
public String Pageviewer()
{
	return "Login.html";
}
	
@ResponseBody	
@PostMapping(value="/validate", consumes=MediaType.APPLICATION_JSON_VALUE)	
public ResponseEntity<String> PostDetails(@RequestBody UserDetail detail)
{
	
	ResponseEntity<String> details=rest.postForEntity("http://localhost:8085/getrow", detail, String.class);
	return details;
}
}
