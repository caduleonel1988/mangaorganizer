package br.com.carlos.mangaorganizer.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Manga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String summary;
	
	protected Status status;
	private Integer chapters;
	
//	@ManyToMany(targetEntity = Genre.class)
//	private List<Genre> genres;
	
	@DateTimeFormat
	private Calendar publicationDate;
	
	@DateTimeFormat
	private Calendar finalizationDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getChapters() {
		return chapters;
	}

	public void setChapters(Integer chapters) {
		this.chapters = chapters;
	}

	public Calendar getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Calendar publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Calendar getFinalizationDate() {
		return finalizationDate;
	}

	public void setFinalizationDate(Calendar finalizationDate) {
		this.finalizationDate = finalizationDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}
