/**
 * 
 */
package com.test.core.fileupload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Krishna_Kumar07
 *
 */
@Controller
public class FileStorage {

	
	@Value("${file.storage}")
	private String filePath;
	/**
	 * 
	 */
	public FileStorage() {
		// TODO Auto-generated constructor stub
	}

	public void storeFile(MultipartFile file) {
		 byte[] bytes;
		try {
			bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename());
	         Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public File[] fetchFiles() {
		File folder = new File(filePath);
		return folder.listFiles();
	}
	
	public String[] fetchFileNames() {
		File folder = new File(filePath);
		int length = folder.listFiles().length;
		String[] fileNames = new String[length];
		File[] files = folder.listFiles();
		for (int i=0;i<length;i++) {
			if(!files[i].isDirectory())
			 fileNames[i] = files[i].getName();
	       }
		return fileNames;
	    }

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
		
	
}
