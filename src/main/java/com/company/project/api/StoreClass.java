package com.company.project.api;

public class StoreClass {

	private final long id;
	private final String url;

	public StoreClass(long id, String url) {
		this.id = id;
		this.url = url;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return url;
	}
}
