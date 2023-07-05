package com.pod;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ClassUtil {

	public String getResourceFileContent(String filename,int maxLength) {
		String result="";
		if (maxLength<=0) {
			maxLength = 1024 * 1024 * 1024;//1GB
		}
		ClassPathResource resource = new ClassPathResource(filename);
		try {
			//File sourceFile = resource.getFile();
		    InputStream inputStream =resource.getInputStream();
			 if (null!=inputStream) {
				 byte[] bs = new byte[maxLength];
				  try {
					while (inputStream.read(bs) != -1) {
						  result = new String(bs);
					  }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				 
			 }			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> covert(List<?> list,Class<T> c){
		return (List<T>) list;
	}

}
