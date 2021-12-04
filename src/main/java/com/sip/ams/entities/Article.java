package com.sip.ams.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotBlank(message = "Label is mandatory")
	@Column(name = "label")
	private String label;

	@Column(name = "price")
	private float price;
	@Column(name = "picture")
	private String picture;
	

	public Article() {
		super();
	}

	public Article(long id, @NotBlank(message = "Label is mandatory") String label, float price, String picture,
			Provider provider) {
		super();
		this.id = id;
		this.label = label;
		this.price = price;
		this.picture = picture;
		this.provider = provider;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public float getPrice() {
		return price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	/**** Many To One ****/
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "provider_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Provider provider;

	public Provider getProvider() {
	return provider;
	}
	public void setProvider(Provider provider) {
	this.provider=provider;
	}
}
