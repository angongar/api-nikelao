package com.tonigdev.api.nikelao.services;

import org.springframework.http.ResponseEntity;

import com.tonigdev.api.nikelao.model.News;
import com.tonigdev.api.nikelao.responses.NewsResponseRest;

public interface INewsService {

	public ResponseEntity<NewsResponseRest> getNews();
	
	public ResponseEntity<NewsResponseRest> addNew(News news);
	
}
