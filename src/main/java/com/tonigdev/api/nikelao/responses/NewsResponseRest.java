package com.tonigdev.api.nikelao.responses;

import java.util.List;

import com.tonigdev.api.nikelao.model.News;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class NewsResponseRest extends APINikelaoResponseRest{
	
	private List<News> results;

}
