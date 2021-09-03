package com.nuchange.urlinfo.service;

import java.util.List;

import com.nuchange.urlinfo.model.UrlInfo;

public interface UrlInfoService {
	String getStoreUrl(String url);
	Long countStoreUrl(String url);
	Long storeUrl(String url);
	List<UrlInfo> listUrl(Integer start, Integer end);
}