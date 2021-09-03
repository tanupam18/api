package com.nuchange.urlinfo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nuchange.urlinfo.model.UrlInfo;
import com.nuchange.urlinfo.repository.UrlInfoRepository;

@Service
public class UrlInfoServiceImpl implements UrlInfoService {

	@Autowired
	UrlInfoRepository repository;
	@Override
	public Long storeUrl(String url) {
		validateUrl(url);
		UrlInfo urlInfo = new UrlInfo(url, UUID.randomUUID().toString());
		UrlInfo savedUrlInfo = repository.save(urlInfo);
		return (savedUrlInfo != null) ? savedUrlInfo.getId() : null;
	}

	@Override
	public String getStoreUrl(String url) {
		validateUrl(url);
		UrlInfo urlInfo = repository.findByUrl(url);
		if(urlInfo != null) {
			urlInfo.setCount(urlInfo.getCount()+1);
			urlInfo = repository.save(urlInfo);
			return urlInfo.getUniqueKey();
		}
		
		return  null;
	}

	@Override
	public Long countStoreUrl(String url) {
		validateUrl(url);
		UrlInfo urlInfo = repository.findByUrl(url);
		return (urlInfo!= null) ? urlInfo.getCount() : null;
	}

	private void validateUrl(String url) {
		if(url== null || url.trim().isEmpty()) {
			throw new IllegalArgumentException("Provided url should not be empty");
		}
	}

	@Override
	public List<UrlInfo> listUrl(Integer page,Integer size ) {
		Pageable pageElements = PageRequest.of(page, size);
		return repository.findAll(pageElements).toList();
	}

}
