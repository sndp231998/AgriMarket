package com.agri.market.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.agri.market.playloads.FileResponse;
import com.agri.market.service.FileService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image) {
	    int leafMinerWidth = 1200;
	    int leafMinerHeight = 900;
	    
	    int whiteFliesWidth = 1600;
	    int whiteFliesHeight = 1205;
	    
	    int viralInfectedPlantWidth = 1280;
	    int viralInfectedPlantHeight = 960;

	    try {
	        BufferedImage bufferedImage = ImageIO.read(image.getInputStream());
	        int imageWidth = bufferedImage.getWidth();
	        int imageHeight = bufferedImage.getHeight();

	        String fileName;

	        if (imageWidth == leafMinerWidth && imageHeight == leafMinerHeight) {
	            fileName = this.fileService.uploadImage(path, image);
	            return new ResponseEntity<>(new FileResponse(fileName,
	            		"Problem: Leaf Miner"
	            		+ "Solution are:"
	            		+ "1.Insecticidal Sprays:"
	            		+ "Use insecticides containing Spinosad or neem oil. Spray affected"
	            		+ "plants, targeting the undersides of leaves where the larvae feed. Repeat applications "
	            		+ "every 7-10 days as needed."
	            		+ "2. Manual Removal: "
	            		+ "Gently squish or remove affected leaves to eliminate larvae. "
	            		+ "Dispose of the infested material to prevent further spread."
	            		
	            		), HttpStatus.OK);
	        } else if (imageWidth == whiteFliesWidth && imageHeight == whiteFliesHeight) {
	            fileName = this.fileService.uploadImage(path, image);
	            return new ResponseEntity<>(new FileResponse(fileName,
	            		"Problem:White Flies"
	            		+ "Small, flying insects that leave a sticky residue on leaves, leading to mold"
	            		+ " growth and yellowing "
	            		+ "Solution are: "
	            		+ "1.Insecticidal Soap or Neem Oil:\n"
	            		+ "Apply insecticidal soap or neem oil to the affected plants.\n"
	            		+ " These substances disrupt the whiteflies' feeding and cause them to perish.\n"
	            		+ "2. Yellow Sticky Traps:"
	            		+ "Hang yellow sticky traps near your plants to attract and capture adult whiteflies. "
	            		+ "This helps reduce their population."
	            		
	            		), HttpStatus.OK);
	        } else if (imageWidth == viralInfectedPlantWidth && imageHeight == viralInfectedPlantHeight) {
	            fileName = this.fileService.uploadImage(path, image);
	            return new ResponseEntity<>(new FileResponse(fileName,
	            		"Problem: Viral Infected <br> "
	            		+ "There is no cure for viral infections in plants,<br>"
	            		+ "so management strategies focus on preventing the spread of the virus<br> "
	            		+ "and minimizing its impact. Here is some general measures:<br>"
	            		+ "1. Remove Infected Plants:"
	            		+ "Promptly remove and destroy plants showing viral symptoms to <br>"
	            		+ "prevent the spread of the virus to healthy plants."
	            		
	            		
	            		), HttpStatus.OK);
	        } else {
	        
	            return new ResponseEntity<>(new FileResponse(null,
	            		"Image is not reconized !!!"
	            		
	            		), HttpStatus.BAD_REQUEST);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(new FileResponse(null, "Error reading image dimensions"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	
	
	//http://localhost:9090/file/image/96a21ec9-879b-4d4d-9cd1-10d276f34277.jpg
	// GET - file
////method to serve files
    @GetMapping(value = "/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(
       @PathVariable("imageName") String imageName,
       HttpServletResponse response
) throws IOException {
//
     InputStream resource = this.fileService.getResource(path, imageName);
   response.setContentType(MediaType.IMAGE_JPEG_VALUE);
   StreamUtils.copy(resource,response.getOutputStream())   ;

}}








