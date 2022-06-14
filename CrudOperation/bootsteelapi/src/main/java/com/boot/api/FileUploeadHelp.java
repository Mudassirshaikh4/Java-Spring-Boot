package com.boot.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploeadHelp {
public final String UPLOAD_DIR="C:\\Users\\LC5669948\\Downloads\\images";
public boolean uploadFile(MultipartFile multipartfile)
{
boolean f=false;	
try {
	InputStream is=multipartfile.getInputStream();
	byte data[]=new byte[is.available()];
	is.read(data);
	FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multipartfile.getOriginalFilename());
   fos.write(data);
   fos.flush();
   fos.close();
   f=true;
} catch (Exception e) {
	e.printStackTrace();
}
return f;
}
}
