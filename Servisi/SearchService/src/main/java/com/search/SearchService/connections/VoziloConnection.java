package com.search.SearchService.connections;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.search.SearchService.dto.VoziloDTO;

@FeignClient(name = "eureka-oglas-service")
public interface VoziloConnection {

		@GetMapping("/vozilo/search/getOne/{id}")
		VoziloDTO getOneForSearch(@PathVariable("id") Long id);
	
}
