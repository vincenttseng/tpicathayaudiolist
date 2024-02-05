package com.tpi.cathay.surfly.audiovideo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.tpi.cathay.surfly.audiovideo.exception.TimeException;

public class ImgFileNameUtil {

	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public static final String JPG = ".jpg";

	/**
	 * ekMSYjk2vhThOwKkXs6evkq_17723312321.JPG
	 * 
	 * @param filename
	 * @return
	 */
	public static String getFormattedTimeFromImgFileZhTw(String filename) throws TimeException {
		if (StringUtils.isBlank(filename)) {
			throw new TimeException("");
		}

		String tmpFile = filename.toLowerCase();
		int index0 = tmpFile.lastIndexOf("/");
		int index1 = tmpFile.indexOf(JPG);
		if (index0 < 0 || index1 < 0) {
			throw new TimeException("err file: " + filename);
		}
		if (index0 >= index1) {
			throw new TimeException("err file: " + filename);
		}

		String token = filename.substring(index0, index1);

		try {
			Date date = new Date(Long.parseLong(token));

			return sdf.format(date);
		} catch (Exception e) {
			throw new TimeException("err file: " + filename);
		}
	}
}
