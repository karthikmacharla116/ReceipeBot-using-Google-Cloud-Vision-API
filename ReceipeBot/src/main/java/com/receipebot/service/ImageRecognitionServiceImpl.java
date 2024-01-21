package com.receipebot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.spring.vision.CloudVisionTemplate;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.Feature;

@Service
public class ImageRecognitionServiceImpl implements ImageRecognitionService {
	
	private CloudVisionTemplate cloudVisionTemplate;
	
	public ImageRecognitionServiceImpl(CloudVisionTemplate cloudVisionTemplate) {
		this.cloudVisionTemplate = cloudVisionTemplate;
	}

	@Override
	public String recognizeIngredients(MultipartFile file) {
		AnnotateImageResponse response = 
				cloudVisionTemplate.analyzeImage(file.getResource(), Feature.Type.LABEL_DETECTION);
		return response.getLabelAnnotationsList().toString();
	}

}
