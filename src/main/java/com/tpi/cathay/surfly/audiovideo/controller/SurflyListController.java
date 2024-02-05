package com.tpi.cathay.surfly.audiovideo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tpi.cathay.surfly.audiovideo.model.ImgReqModel;

@Controller
@RequestMapping("/record")
public class SurflyListController {
	private static final Logger log = LoggerFactory.getLogger(SurflyListController.class);

	public SurflyListController() {

	}

	@PostMapping("/snaplist")
	public String viewBooks(@RequestBody ImgReqModel model) {
		log.info("called {}", model);
		
		
		return "view-books";
	}
}
