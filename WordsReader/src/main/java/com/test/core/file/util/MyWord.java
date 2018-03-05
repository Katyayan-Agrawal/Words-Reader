/**
 * This is the POJO representing the uploaded file properties.
 * 
 * 
 */
package com.test.core.file.util;

/**
 * @author Katyayan
 *
 */
public class MyWord {

	private String word;
	private Integer wordCount;
	/**
	 * 
	 */
	public MyWord() {
		// TODO Auto-generated constructor stub
	}
	public Integer getWordCount() {
		return wordCount;
	}
	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}

}
