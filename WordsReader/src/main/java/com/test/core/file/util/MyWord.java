/**
 * This is the POJO representing the uploaded file properties.
 * 
 */
package com.test.core.file.util;

/**
 * @author Katyayan Agrawal
 *
 */
public class MyWord {

	private String word;
	private Integer wordCount;
	
	/**
	 * Default Constructor
	 */
	public MyWord() {
	}
	
	/**
	 * Set/Get method for wordCount
	 */
	public Integer getWordCount() {
		return wordCount;
	}
	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
	}
	/**
	 * Set/Get method for word
	 */
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
}
