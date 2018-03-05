/**
 * This is the POJO representing the uploaded file properties.
 * 
 * 
 */
package com.test.core.file.util;

/**
 * @author Katyayan Agrawal
 *
 */
public class MyFile {

	private String fileName;
	private MyWord[] frequentWords;
	private Integer totalWordsInFile;

	/**
	 * Default Constructor
	 */
	public MyFile() {
	}
	
	/**
	 * Set/Get method for filePath
	 */
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Set/Get method for totalWordsInFile
	 */	
	public Integer getTotalWordsInFile() {
		return totalWordsInFile;
	}
	public void setTotalWordsInFile(Integer totalWordsInFile) {
		this.totalWordsInFile = totalWordsInFile;
	}

	/**
	 * Set/Get method for frequentWords
	 */	
	public MyWord[] getFrequentWords() {
		return frequentWords;
	}

	public void setFrequentWords(MyWord[] frequentWords) {
		this.frequentWords = frequentWords;
	}
}
