package com.yao.springD4.model;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	

	public static String upload(MultipartFile file, String path, String fileName) {

		
		String cusFileName = getUUID() + getSuffix(fileName);
		String realPath = path + "/" + cusFileName;
		File dest = new File(realPath);
		// 判斷目錄是否存在
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdir();
		}
		
		try {
			// 儲存檔案
			file.transferTo(dest);
			return cusFileName;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

//	取檔案格式 (.jgp)
	public static String getSuffix(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

//	取UUID
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
