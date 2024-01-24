package com.agri.market.controller;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.util.StreamUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.agri.market.playloads.UserDto;
import com.agri.market.service.FileService;
import com.agri.market.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	

	// POST-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	// PUT- update user

		@PutMapping("/{userId}")
		public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid) {
			UserDto updatedUser = this.userService.updateUser(userDto, uid);
			return ResponseEntity.ok(updatedUser);
		}
		
		// GET - user get
		@GetMapping("/")
		public ResponseEntity<List<UserDto>> getAllUsers() {
			return ResponseEntity.ok(this.userService.getAllUsers());
		}
		
		// GET - user get
		@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId) {
			return ResponseEntity.ok(this.userService.getUserById(userId));
		}
//		@PostMapping("/image/upload/{userId}")
//		public ResponseEntity<UserDto> uploadImage(@RequestParam("image") MultipartFile image,
//		                                               @PathVariable Integer userId) throws IOException {
//
//		    UserDto userDto = this.userService.getUserById(userId);
//
//		    // Validate image dimensions and size
//		    if (!isValidImage(image)) {
//		    	String errorMessage="Image is not valid";
//		        return new ResponseEntity<>( HttpStatus.BAD_REQUEST); // Or any appropriate error response
//		    }
//
//		    String fileName = this.fileService.uploadImage(path, image);
//		    userDto.setImageName(fileName);
//		    // UserDto updateUser = this.userService.updateUser(userDto, userId);
//		    String errorMessage="Image is not valid";
//		    return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
//		}

//		// Helper method for image validation
//		private boolean isValidImage(MultipartFile image) {
//		    try {
//		        BufferedImage bufferedImage = ImageIO.read(image.getInputStream());
//
//		        // Check dimensions
//		        if (bufferedImage.getWidth() != 1200 || bufferedImage.getHeight() != 900) {
//		            return false;
//		        }
//
//		        // Check size
//		        if (image.getSize() > 111 * 1024) { // 300 KB
//		            return false;
//		        }
//
//		        return true;
//		    } catch (IOException e) {
//		        // Handle image reading errors (e.g., invalid format)
//		        return false;
//		    }
//		}

}


//----------------------------------------------------



//post image upload
//
//@PostMapping("/image/upload/{userId}")
//public ResponseEntity<UserDto> uploadPostImage(@RequestParam("image") MultipartFile image,
//		@PathVariable Integer userId) throws IOException {
//
//	UserDto userDto = this.userService.getUserById(userId);
//	
//	
//
//	String fileName = this.fileService.uploadImage(path, image);
//	userDto.setImageName(fileName);
//	//UserDto updateUser = this.userService.updateUser(userDto, userId);
//	return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
//
//
//
//}
//
////method to serve files
//@GetMapping(value = "/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
//public void downloadImage(
//       @PathVariable("imageName") String imageName,
//       HttpServletResponse response
//) throws IOException {
//
//   InputStream resource = this.fileService.getResource(path, imageName);
//   response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//   StreamUtils.copy(resource,response.getOutputStream())   ;
//
//}
