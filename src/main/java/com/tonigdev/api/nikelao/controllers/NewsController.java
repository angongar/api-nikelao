package com.tonigdev.api.nikelao.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tonigdev.api.nikelao.model.News;
import com.tonigdev.api.nikelao.responses.NewsResponseRest;
import com.tonigdev.api.nikelao.services.INewsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api-nikelao")
@RequiredArgsConstructor
public class NewsController {
	
	private final INewsService service;
	
	@GetMapping("/news")
	public ResponseEntity<NewsResponseRest> news(){
		return service.getNews();
	}
	
	@PostMapping("/news")
	public ResponseEntity<NewsResponseRest> addNews(@RequestBody News news){
		return service.addNew(news);
	}
	

}
