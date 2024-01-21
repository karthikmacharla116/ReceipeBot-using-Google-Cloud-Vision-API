package com.receipebot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.receipebot.service.ImageRecognitionService;

@RestController
public class ImageRecognitionController {

	private ImageRecognitionService imageRecogninitonService;

	public ImageRecognitionController(ImageRecognitionService service) {
		this.imageRecogninitonService = service;
	}

	@PostMapping(value = "/ingredients", consumes = "multipart/form-data")
	public String detectIngredients(MultipartFile file) {
		return imageRecogninitonService.recognizeIngredients(file);
	}
}
