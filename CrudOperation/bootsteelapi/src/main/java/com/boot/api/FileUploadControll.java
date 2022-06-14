package com.boot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadControll
{
@Autowired
	private FileUploeadHelp fileuploadhelp;
	@GetMapping("/upfile")
	public ResponseEntity<String> uploadFile(@RequestParam("fold") MultipartFile fold)
{
//System.out.println(fold.getOriginalFilename());
//System.out.println(fold.getSize());
//System.out.println(fold.getContentType());
//System.out.println(fold.getName());
try
{	
		if(fold.isEmpty())
	{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request something mention");
	}
	if(!fold.getContentType().equals("img1.jpeg"))
	{
	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg content");
	}	
boolean f=fileuploadhelp.uploadFile(fold);
if(f)
{
return ResponseEntity.ok("file is successfully uploead");	
}
}
catch(Exception e)
{
e.printStackTrace();
}
	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong try again");	
}
}
