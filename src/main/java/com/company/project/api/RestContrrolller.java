package com.company.project.api;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestContrrolller {

	private static final String template = " %s";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/StoreUrl")
	public StoreClass greeting(@RequestParam(value = "url", defaultValue = "google.com") String name) {
		return new StoreClass(counter.incrementAndGet(), String.format(template, name));
	}
}