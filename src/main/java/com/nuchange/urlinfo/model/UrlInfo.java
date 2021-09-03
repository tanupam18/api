package com.nuchange.urlinfo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "url_info")
public class UrlInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "count")
	private Long count = 0L;
	@Column(name = "url", nullable = false, unique = true,length = 2048)
	private String url;
	@Column(name = "unique_key", nullable = false, unique = true, length = 36)
	private String uniqueKey;
	public UrlInfo() {};
	public UrlInfo(String url, String uniqueKey) {
		this.uniqueKey = uniqueKey;
		this.url = url;
	}

}
