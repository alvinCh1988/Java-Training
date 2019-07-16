package com.yao.demo.component;

import java.io.File;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

@Component("FileUtils")
public class FileUtils {
	
	
	/**
	 * 圖檔上傳
	 * @param file
	 * @param accountName
	 * @return
	 */
	public String upload(MultipartFile file, String accountName) {

		try {

			String fileName = file.getOriginalFilename();

			/**
			 * 設定檔案路徑
			 */
			String myPath = "/images/uploadUsersPhote";
			File uploadpath = new File(ResourceUtils.getURL("classpath:static").getPath(), myPath);

			/**
			 * 取得檔案格式
			 */
			String suffix = fileName.substring(fileName.lastIndexOf("."));

			String uploadFileName = accountName + suffix;
			String realPath = uploadpath + "/" + uploadFileName;
			File dest = new File(realPath);

			System.out.println(dest);

			/**
			 * 判斷目錄是否存在
			 */
			if (!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();
			}

			/**
			 * 儲存檔案
			 */
			file.transferTo(dest);
			String rePath = myPath + "/" + uploadFileName;

			return rePath;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
