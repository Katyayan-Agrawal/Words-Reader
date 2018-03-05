/**
 * This is the Controller class for uploading the files
 */
package com.test.core.fileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Katyayan
 *
 */
@Controller
public class FileUploadController {

	@Autowired
	private FileStorage fileStorage;
	
	/**
	 * Default Constructor
	 */
	public FileUploadController() {
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("File") MultipartFile file, RedirectAttributes redirectAttributes) {
		if(file != null) {
			fileStorage.storeFile(file);
			 redirectAttributes.addFlashAttribute("message",
		                "You successfully uploaded " + file.getOriginalFilename() + ".");

		}        
        return "redirect:/viewfiles";
	}
	
	@RequestMapping("/viewfiles")
	public String fetchfiles(Model model) {
	      String[] fileNames = fileStorage.fetchFileNames();
	      model.addAttribute("files" , fileNames);
	      return "listFiles";
	}
	
}
