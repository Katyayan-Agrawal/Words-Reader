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
	 * 
	 */
	public MyFile() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

	
	public Integer getTotalWordsInFile() {
		return totalWordsInFile;
	}
	public void setTotalWordsInFile(Integer totalWordsInFile) {
		this.totalWordsInFile = totalWordsInFile;
	}

	public MyWord[] getFrequentWords() {
		return frequentWords;
	}

	public void setFrequentWords(MyWord[] frequentWords) {
		this.frequentWords = frequentWords;
	}


}
