package com.nuchange.urlinfo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nuchange.urlinfo.model.UrlInfo;
import com.nuchange.urlinfo.service.UrlInfoService;

@RestController
public class UrlInfoController {

	@Autowired
	UrlInfoService service;
	@GetMapping("/storeUrl")
	public Long storeUrl(@RequestParam(value = "url") String url) {
		return service.storeUrl(url);
	}


@GetMapping("/list")
public List<UrlInfo> listUrl(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size) {
	return service.listUrl(page, size);
}

@GetMapping("/get")
public  String getUrl(@RequestParam(value = "url") String url) {
	return service.getStoreUrl(url);
}

@GetMapping("/count")
public  Long countUrl(@RequestParam(value = "url") String url) {
	return service.countStoreUrl(url);
}

}