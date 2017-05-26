package com.clean.news.domain.model.newssources;

import java.util.List;

public class Source {
	private String country;
	private UrlsToLogos urlsToLogos;
	private String name;
	private List<String> sortBysAvailable;
	private String description;
	private String language;
	private String id;
	private String category;
	private String url;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setUrlsToLogos(UrlsToLogos urlsToLogos){
		this.urlsToLogos = urlsToLogos;
	}

	public UrlsToLogos getUrlsToLogos(){
		return urlsToLogos;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSortBysAvailable(List<String> sortBysAvailable){
		this.sortBysAvailable = sortBysAvailable;
	}

	public List<String> getSortBysAvailable(){
		return sortBysAvailable;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}