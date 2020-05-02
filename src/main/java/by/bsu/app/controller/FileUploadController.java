package by.bsu.app.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class FileUploadController {

	public static String uploadDir = System.getProperty("user.dir",
			"C:\\Users\\User\\eclipse-FinalProject")+"\\uploads";
	public static String taskDir = System.getProperty("task.dir",
			"C:\\Users\\User\\eclipse-FinalProject")+"\\uploadTasks";
	public static final String PATH = "C:\\\\Users\\\\User\\\\eclipse-FinalProject\\\\SpringSecurityDemo\\\\SpringSecurityUser\\\\uploads\\output.zip"; 
	
	//private static String UPLOADED_FOLDER = "E://uploadedfiles//";

	

	@GetMapping(value= "/foo")
	public String UploadPage(Model model) {
		return "index";
	}
	
	
//	 @RequestMapping(value = "/pdf", method = RequestMethod.GET)
//	    public void getFile(HttpServletResponse response) {
//	        try {
//	            DefaultResourceLoader loader = new DefaultResourceLoader();
//	            InputStream is = loader.getResource("D:\\open.pdf").getInputStream();
//	            IOUtils.copy(is, response.getOutputStream());
//	            response.setHeader("Content-Disposition", "attachment; filename=open.pdf");
//	            response.flushBuffer();
//	        } catch (IOException ex) {
//	            throw new RuntimeException("IOError writing file to output stream");
//	        }
//	    }
	
	
	
	@RequestMapping("/upload")
	  public String upload(Model model,@RequestParam("file") MultipartFile[] files) throws FileNotFoundException {
		 
		  StringBuilder fileNames = new StringBuilder();
		 
		 

		  for (MultipartFile file : files) {
		  Path fileNameAndPath = Paths.get(uploadDir, file.getOriginalFilename());
		  fileNames.append(file.getOriginalFilename()+" ");
		  
		  try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
		  
		  
	  model.addAttribute("msg", "Successfully uploaded files "+fileNames.toString());
	  return "uploadstatusview";
	}
	
	
	@RequestMapping("/uploadTask")
	  public String uploadTask(Model model,@RequestParam("file") MultipartFile[] files) throws FileNotFoundException {
		 
		  StringBuilder fileNames = new StringBuilder();
		 
		 

		  for (MultipartFile file : files) {
		  Path fileNameAndPath = Paths.get(taskDir, file.getOriginalFilename());
		  fileNames.append(file.getOriginalFilename()+" ");
		  
		  try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
		  
		  
	  model.addAttribute("msg", "Successfully uploaded task "+fileNames.toString());
	  return "uploadstatusview";
	}
	
	
	
	
//	@RequestMapping("/uploadTask")
//	  public String uploadT(Model model,@RequestParam("file") MultipartFile[] files) throws FileNotFoundException {
//		 
//		  StringBuilder fileNames = new StringBuilder();
//		 
//		 
//
//		  for (MultipartFile file : files) {
//		  Path fileNameAndPath = Paths.get(taskDir, file.getOriginalFilename());
//		  fileNames.append(file.getOriginalFilename()+" ");
//		  
//		  try {
//			Files.write(fileNameAndPath, file.getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	  }
//		  
//		  
//	  model.addAttribute("msg", "Successfully uploaded tasks "+fileNames.toString());
//	  return "uploadstatusview";
//	}
	
	
	
	
//	@RequestMapping(value="/getpdf", method=RequestMethod.GET)
//	  public String uploadPDF(Model model,@RequestParam("file") MultipartFile[] files) throws FileNotFoundException {
//		 
//		  StringBuilder fileNames = new StringBuilder();
//		 
//		 
//
//		  for (MultipartFile file : files) {
//		  Path fileNameAndPath = Paths.get(uploadDir, file.getOriginalFilename());
//		  fileNames.append(file.getOriginalFilename()+" ");
//		  
//		  try {
//			Files.write(fileNameAndPath, file.getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	  }
//	  model.addAttribute("msg", "Successfully uploaded files "+fileNames.toString());
//	  return "uploadstatusview";
//	
//	
//	}
	
}


		  

		
	
	
	

