package com.tonigdev.api.nikelao.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tonigdev.api.nikelao.model.News;
import com.tonigdev.api.nikelao.repositories.IClientsRepository;
import com.tonigdev.api.nikelao.repositories.INewsRepository;
import com.tonigdev.api.nikelao.responses.NewsResponseRest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewsService implements INewsService {

	private final INewsRepository repository;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<NewsResponseRest> getNews() {
		log.info("NewsService.getNews() - Inicio método.");
		ResponseEntity<NewsResponseRest> response;
		NewsResponseRest apiResponse = new NewsResponseRest();
		List<News> news;

		try {

			news = repository.findAll();

			if (news != null && !news.isEmpty()) {
				apiResponse.setResults(news);
				apiResponse.setStatus(HttpStatus.OK);
				apiResponse.setMessage("Se han obtenido los datos con éxito.");

				response = new ResponseEntity<NewsResponseRest>(apiResponse, HttpStatus.OK);
			} else {
				apiResponse.setStatus(HttpStatus.NOT_FOUND);
				apiResponse.setMessage("No se han obtenido elementos.");

				response = new ResponseEntity<NewsResponseRest>(apiResponse, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			log.error("NewsService.getNews() - Se ha producido un error al consultar los datos: " + e.getMessage());
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			apiResponse.setMessage("Se ha producido un error al consultar los datos.");

			response = new ResponseEntity<NewsResponseRest>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return response;
	}

	@Override
	public ResponseEntity<NewsResponseRest> addNew(News news) {
		log.info("NewsService.addNew(news) - Inicio método.");
		ResponseEntity<NewsResponseRest> response;
		NewsResponseRest apiResponse = new NewsResponseRest();
		List<News> listNews;
		News newInsert;

		try {

			newInsert = repository.save(news);

			if (newInsert != null) {
				listNews = new ArrayList<>();
				listNews.add(newInsert);

				apiResponse.setStatus(HttpStatus.OK);
				apiResponse.setMessage("Se ha añadido correctamente la noticia.");
				apiResponse.setResults(listNews);

				response = new ResponseEntity<NewsResponseRest>(apiResponse, HttpStatus.OK);

			} else {
				apiResponse.setStatus(HttpStatus.BAD_REQUEST);
				apiResponse.setMessage("No se ha podido insertar la noticia.");

				response = new ResponseEntity<NewsResponseRest>(apiResponse, HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			log.error("NewsService.addNew() - Se ha producido un error al insertar los datos: " + e.getMessage());
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			apiResponse.setMessage("Se ha producido un error al insertar los datos.");

			response = new ResponseEntity<NewsResponseRest>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

}
