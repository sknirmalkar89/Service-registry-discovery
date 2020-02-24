package com.tarento.CatalogService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {

	private static Map<String, String> bookCatalogMap = new HashMap<String, String>();

	static {
		bookCatalogMap = new HashMap<String, String>();

		bookCatalogMap.put("rajat", "Manorma");
		bookCatalogMap.put("chetan", "THREE POINT SOMEONE");

	}

	@RequestMapping(value = "/getBook/{writerName}", method = RequestMethod.GET)
	public String get(@PathVariable String writerName) {
		System.out.println("Getting Student details for " + writerName);

		return bookCatalogMap.get(writerName);
	}
}