package com.imageapi.imageapi.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class ImageServiceImpl implements ImageService {

	@Override
	public String uploadImage(String path, MultipartFile file) {
		// file name
		
		String name = file.getOriginalFilename();
		
		String randomID = UUID.randomUUID().toString();
		
		String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));
		
		
		//file path
		
		String filepath=path+File.separator+name;
		
		
		// create folder if not created
		
		File f=new File(path);
		
		if (!f.exists()) {
			
			f.mkdir();
			
		}

		// copy file
		
		try {
			Files.copy(file.getInputStream(), Paths.get(filepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return fileName1;
	}

	@Override
	public InputStream getResourses(String path, String fileName) throws FileNotFoundException {
		
		String fullPath=path+File.separator+fileName;
		
		InputStream is=new FileInputStream(fullPath);
		
				
		return is;
	}

}
