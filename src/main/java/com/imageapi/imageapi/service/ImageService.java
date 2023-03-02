package com.imageapi.imageapi.service;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	
	public String uploadImage(String path,MultipartFile file);
	
	public InputStream getResourses(String path,String fileName)throws FileNotFoundException;

}
