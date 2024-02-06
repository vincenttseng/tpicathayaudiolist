package com.tpi.cathay.surfly.audiovideo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tpi.cathay.surfly.audiovideo.model.ImgReqModel;

@Controller
@RequestMapping("/record")
public class SurflyListController {
	private static final Logger log = LoggerFactory.getLogger(SurflyListController.class);

	public SurflyListController() {

	}

	@GetMapping(path = "/goViewSnap")
	public String goViewSnap(Model model, @RequestParam(value = "SessionID", required = true) String sessionID,
			@RequestParam(value = "TimeStamp", required = true) String timeStamp,
			@RequestParam(value = "ConnID", required = true) String connID,
			@RequestParam(value = "VoiceMountPath", required = true) String voiceMountPath) {
		log.info("called {} {} {} {}", timeStamp, sessionID, connID, voiceMountPath);

		ImgReqModel imgReqModel = ImgReqModel.builder().sessionID(sessionID).timeStamp(timeStamp).connID(connID)
				.voicePath(voiceMountPath).build();

		return viewSnap(imgReqModel);
	}

	@PostMapping("/snaplist")
	public String viewSnap(@RequestBody ImgReqModel model) {
		log.info("called {}", model);
		
		
		
		return "view-snaps";
	}
}
