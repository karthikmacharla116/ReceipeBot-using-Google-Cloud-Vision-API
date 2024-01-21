package com.receipebot.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageRecognitionService {
	
	String recognizeIngredients(MultipartFile file);

}
