/**
 * This is the file used to store the uploaded file to the local directory	
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
 * @author Katyayan Agrawal
 *
 */
@Controller
public class FileStorage {

	
	@Value("${file.storage}")
	private String filePath;
	/**
	 * Default Constructor
	 */
	public FileStorage() {
	}

   /**
   * This is the method used to store the file.
   * @param file.
   * @return void.
   * @exception IOException On input error.
   * @see IOException
   */
	public void storeFile(MultipartFile file) {
		 byte[] bytes;
		try {
			bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename());
	         Files.write(path, bytes);
		} catch (IOException e) {
			System.err.print("IOException -"+ e);
			//e.printStackTrace();
		}
	}
	
   /**
   * This is the method used to fetch the files.
   * @return list of files.
   */	
	public File[] fetchFiles() {
		File folder = new File(filePath);
		return folder.listFiles();
	}
	
   /**
   * This is the method used to fetch the files name.
   * @return fileNames.
   */	
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

   /**
   * Set/Get method for filePath
   */	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
