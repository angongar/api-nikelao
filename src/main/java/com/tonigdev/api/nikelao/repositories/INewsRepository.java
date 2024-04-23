package com.tonigdev.api.nikelao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tonigdev.api.nikelao.model.News;

public interface INewsRepository extends JpaRepository<News, Long>{

}
