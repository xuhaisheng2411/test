package com.readfile;


import com.entity.OcBaseElement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readerFile {
	
	public static String change(Object obj){
		
		
		return ((OcBaseElement) obj).toString();
	}

    public static void main(String[] args) {

		try {
			FileReader file = new FileReader("D:/test.txt");
 			BufferedReader reader = new BufferedReader(file);

              String line;

			while ((line = reader.readLine()) != null){
				line=line.replaceAll("\\\\","/");//&nbsb
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

    }


}
