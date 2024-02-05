package com.tpi.cathay.surfly.audiovideo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImgReqModel {
	@JsonProperty("SessionID")
	private String sessionID;
	
	@JsonProperty("ConnID")
	private String connID;
	
	@JsonProperty("TimeStamp")
	private String timeStamp;
	
	@JsonProperty("VoiceMountPath")
	private String voicePath;
}
