/**
 * Controller class used to get the total words count and 
 * top 5 most occurance words of the uploaded file(s)..
 * 
 * 
 */
package com.test.core.file.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.core.fileupload.FileStorage;

/**
 * @author Katyayan Agrawal
 *
 */
@RestController
public class FileReadController {

	@Autowired
	private FileStorage fileStorage;
	
	@Value("${number.recent.words}")
	private Integer numRecentWords;
	/**
	 * 
	 */
	public FileReadController() {
		
	}
	
	@RequestMapping ("/readFrequentWordsAllFiles")
	public MyFile[] getFrequentWordsFromAllFiles() {
		
		File [] files= this.fileStorage.fetchFiles();
		MyFile[] myfiles = new MyFile[files.length];
		for(int i=0;i<files.length;i++) {
			myfiles[i] = this.findFrequentWords(files[i]);
		}
		return myfiles;
	}
	
	@RequestMapping ("/readFrequentWordFromFile")
	public MyFile getFrequentWordFromFile(@RequestParam("fileName") String file) {
		MyFile myfile = new MyFile();
		File directory = new File(fileStorage.getFilePath());
		File thisFile = new File(directory, file);
		boolean check = thisFile.exists();
		if(check) {
			myfile = this.findFrequentWords(thisFile);
		}
		return myfile;
	}
	
	/**
	 * Method to get the total number of words and top words of maximum occurrence from the passed File
	 * 
	 */
	private MyFile findFrequentWords(File file) {
		 MyFile  myFile = new MyFile();
		 FileReader fileReader = null;
		 BufferedReader bufferedReader = null;
		 
		 try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			String dataString = new String();
			String line = null;
			
			// read all the lines of the file and concatenate to form one single line
			while((line = bufferedReader.readLine()) != null) {
				dataString = dataString.concat(" ");
				dataString = dataString.concat(line);
			}
			// Get the words by splitting the dataString
			String[] wordsArray = dataString.split(" ");
			int totalWordsInFile = wordsArray.length;
			
			// Declare the HashMap to store the word
			Map<String,Integer> wordMap = new HashMap<String,Integer>();
			
            
            // iterate through the wordsArray to form the words map
			for(int i=0; i<wordsArray.length; i++) {
				if (!StringUtils.isEmpty(wordsArray[i])) {
					String singleWord = wordsArray[i].toLowerCase();
					
					// if wordMap contains the word, increment the count else add the word
					if (wordMap.containsKey(singleWord)) {
						Integer wordCount = wordMap.get(singleWord);
						wordCount = wordCount+1;
						wordMap.put(singleWord, wordCount);
					} else {
						wordMap.put(singleWord, 1);
					}
				}
			}
			LinkedHashMap<String, Integer> sortedMap =
			        new LinkedHashMap<>();
			List<String> mapKeys = new ArrayList(wordMap.keySet());
			List<Integer> mapValues = new ArrayList(wordMap.values());
			Collections.sort(mapValues, Collections.reverseOrder());
			Iterator<Integer> valueIt = mapValues.iterator();
		    while (valueIt.hasNext()) {
		        Integer val = valueIt.next();
		        Iterator<String> keyIt = mapKeys.iterator();

		        while (keyIt.hasNext()) {
		            String key = keyIt.next();
		            Integer comp1 = wordMap.get(key);
		            Integer comp2 = val;

		            if (comp1.equals(comp2)) {
		                keyIt.remove();
		                sortedMap.put(key, val);
		                break;
		            }
		        }
		    }
			
			//
		    MyWord[] myWords = new MyWord[this.numRecentWords];
            Set<String> sortedKeys = sortedMap.keySet();
            Iterator<String> iterator = sortedKeys.iterator();
            int i=0;
            while(iterator.hasNext() && i < numRecentWords) {
            	MyWord myWord = new MyWord();
            	String keyWord = iterator.next();
            	myWord.setWordCount((Integer)sortedMap.get(keyWord));
            	myWord.setWord(keyWord);
            	myWords[i] = myWord;
            	i++;
            }
            

					            
			// Set the MyFile data bean with the result
            myFile.setTotalWordsInFile(totalWordsInFile);
			myFile.setFileName(file.getName());
			myFile.setFrequentWords(myWords);
		 } catch (FileNotFoundException e) {
			 System.err.println("File not found.");			 
			 //e.printStackTrace();
		 } catch (IOException e) {
			 System.err.print(e);
			 //e.printStackTrace();
		 } finally {
			if(fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.print("FileReader IOException -"+ e);
					//e.printStackTrace();
				}
			}
			if(bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					System.err.print("BufferedReader IOException -"+ e);
					//e.printStackTrace();
				}
			}
		 }
	     
		 return myFile; 
	}

}
