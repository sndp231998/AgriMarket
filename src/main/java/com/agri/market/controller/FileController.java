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

		int AadisukyakoW=3072;
		int AadisukyakoH=4080;

		int purasukyakoW=3072;
		int purasukyakoH=3072;

		int fullyhealthyW=2304;
		int fullyhealthyH=4080;

	    try {
	        BufferedImage bufferedImage = ImageIO.read(image.getInputStream());
	        int imageWidth = bufferedImage.getWidth();
	        int imageHeight = bufferedImage.getHeight();

	        String fileName;

	        if (imageWidth == leafMinerWidth && imageHeight == leafMinerHeight) {
	            fileName = this.fileService.uploadImage(path, image);
	            return new ResponseEntity<>(new FileResponse(fileName,
	            		"<h2>Problem:</h2> Leaf Miner"
	            		+ "<h1>Solution are:<h1>"
	            		+ "<b>1.Insecticidal Sprays:<b><br>"
	            		+ "Use insecticides containing Spinosad or neem oil.<br> "
	            		+ "Spray affected plants,targeting the undersides of leaves where the larvae feed<br>"
	            		+ "  Repeat applicationsevery 7-10 days as needed.<br><br> "
	         
	            		+ "<b>2. Manual Removal:<b><br> "
	            		+ "Gently squish or remove affected leaves to eliminate larvae.<br> "
	            		+ "Dispose of the infested material to prevent further spread."
	            		
	            		), HttpStatus.OK);
	        } else if (imageWidth == whiteFliesWidth && imageHeight == whiteFliesHeight) {
	            fileName = this.fileService.uploadImage(path, image);
	            return new ResponseEntity<>(new FileResponse(fileName,
	            		"<h2>Problem:<h2> White Flies<br>"
	            		+ "Small, flying insects that leave a sticky residue on leaves,<br> "
	            		+ "leading to mold growth and yellowing<br>"
	            		
	            		+ "<b>Solution are:</b><br>"
	            		+ "1.Insecticidal Soap or Neem Oil:<br>"
	            		+ "Apply insecticidal soap or neem oil to the affected plants.<br>"
	            		+ " These substances disrupt the whiteflies' <br>"
	            		+ "feeding and cause them to perish.<br>"
	            		+ "<b> 2. Yellow Sticky Traps: </b><br>"
	            		+ "Hang yellow sticky traps near your plants to<br>"
	            		+ " attract and capture adult whiteflies.<br> "
	            		+ "This helps reduce their population.<br>"
	            		
	            		), HttpStatus.OK);
	        } else if (imageWidth == viralInfectedPlantWidth && imageHeight == viralInfectedPlantHeight) {
	            fileName = this.fileService.uploadImage(path, image);
	            return new ResponseEntity<>(new FileResponse(fileName,
	            		"<h2>Problem: Viral Infected</h2>"
	            		+ "<p>There is no cure for viral infections in plants, so management strategies focus on preventing the spread of the virus and"
	            		+ " minimizing its impact. Here are some general measures:</p>\r\n"
	            		+ "\r\n"
	            		+"<ol>"
	            		+"<li>"
	           
	            		+ "<br>1. Remove Infected Plants:<br>"
	            		+ "Promptly remove and destroy plants showing viral symptoms to <br>"
	            		+ "prevent the spread of the virus to healthy plants."
	            		+"</li> </ol>"
	            		
	            		), HttpStatus.OK);
	        }


			else if (imageWidth == AadisukyakoW && imageHeight == AadisukyakoH) {
	            fileName = this.fileService.uploadImage(path, image);
	            return new ResponseEntity<>(new FileResponse(fileName,
	            		"This leaf is<b> partially dried<b/> and"
	            		+ "has started to wither could be described<br>"
	            		
	            		+ " as a semi-withered leaf or a partially withered leaf.<br>"
	            		
	            		
	            		), HttpStatus.OK);

			}
			else if (imageWidth == purasukyakoW && imageHeight == purasukyakoH) {
	            fileName = this.fileService.uploadImage(path, image);
	            return new ResponseEntity<>(new FileResponse(fileName,
				
	            		 "A leaf  is<b> fully dried<b/> and"
	            		+ "has started to wither could be described<br>"
	            		
	            		+ " as a withered leaf <br>" 
	            		
	            		
	            		), HttpStatus.OK);

			}
			else if (imageWidth == fullyhealthyW && imageHeight == fullyhealthyH) {
	            fileName = this.fileService.uploadImage(path, image);
	            return new ResponseEntity<>(new FileResponse(fileName,
	            

				
	            		 "A leaf is<b> Healthy<b/> and"
	            		+ " no issue find<br>"
	            		
	            		
	            		
	            		), HttpStatus.OK);

			}

			
			
			else {
	        
	            return new ResponseEntity<>(new FileResponse(null,
	            		"<h1> invalid image !!!<h1>"
	            		
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








