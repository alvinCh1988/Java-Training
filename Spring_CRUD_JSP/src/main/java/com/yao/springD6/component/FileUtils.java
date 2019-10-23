package com.yao.springD6.component;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("FileUtils")
public class FileUtils {
	

	public String upload(MultipartFile file, String path, String fileName) {

		FileUtils fileUtils = new FileUtils();
		String cusFileName = fileUtils.getUUID() + fileUtils.getSuffix(fileName);
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
	public String getSuffix(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

//	取UUID
	public String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
