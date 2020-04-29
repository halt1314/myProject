package com.hy.example.testModule.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hy.example.testModule.entity.City;
import com.hy.example.testModule.entity.Country;
import com.hy.example.testModule.service.CityService;
import com.hy.example.testModule.service.CountryService;

@Controller
@RequestMapping("/test")
public class TestPageController {
	
	@Autowired
	private CityService cityService;
	private CountryService countryService;
	@RequestMapping("/index")
	public String testIndexPage(ModelMap modelMap) {
		
		int countryId = 522;
		//Country country = countryService.getCountryById(countryId);
		List<City> cities = cityService.getCitiesByCountryId(countryId);
		cities = cities.stream().limit(10).collect(Collectors.toList());
		City city = cities.get(0);

		modelMap.addAttribute("thymeleafTitle", "thymeleaf Title");
		modelMap.addAttribute("checked", true);
		modelMap.addAttribute("currentNumber", 99);
		modelMap.addAttribute("changeType", "checkbox");
		modelMap.addAttribute("baiduUrl", "http://www.baidu.com");
		modelMap.addAttribute("shopLogo", "http://cdn.duitang.com/uploads"
				+ "/item/201308/13/20130813115619_EJCWm.thumb.700_0.jpeg");
		//modelMap.addAttribute("country", country);
		modelMap.addAttribute("city", city);
		modelMap.addAttribute("updateCityUri", "/api/city");
		modelMap.addAttribute("cities", cities);
		modelMap.addAttribute("template", "test/index");
		
		return "index";
	}
	
	@PostMapping(value="/files", consumes="multipart/form-data")
 	public String uploadFiles(@RequestParam MultipartFile[] files, 
 			RedirectAttributes redirectAttributes) {
 		boolean isEmpty = true;

 		try {
 			for (MultipartFile file : files) {
 				if (file.isEmpty()) {
 //				break;
 					continue;
 				}

 				String fileName = file.getOriginalFilename();
 				String destFilePath = "D:\\test\\" + fileName;
 				File destFile = new File(destFilePath);
 				file.transferTo(destFile);

 				isEmpty = false;
 			}
 		} catch (IllegalStateException | IOException e) {
 			e.printStackTrace();
 			redirectAttributes.addFlashAttribute("message", "Upload file failed.");
 			return "redirect:/test/index";
 		}

 		if (isEmpty) {
 			redirectAttributes.addFlashAttribute("message", "Please select file.");
 		} else {
 			redirectAttributes.addFlashAttribute("message", "Upload file success.");
 		}
 		return "redirect:/test/index";
 	}

	@PostMapping(value="/file", consumes = "multipart/form-data")
 	public String uploadFile(@RequestParam MultipartFile file, 
 			RedirectAttributes redirectAttributes) {

 		if (file.isEmpty()) {
 			redirectAttributes.addFlashAttribute("message", "Please select file.");
 			return "redirect:/test/index";
 		}

 		try {
 			String fileName = file.getOriginalFilename();
 			String destFilePath = "D:\\test\\" + fileName;
 			File destFile = new File(destFilePath);
 			file.transferTo(destFile);

 			redirectAttributes.addFlashAttribute("message", "Upload file success.");
 		} catch (IllegalStateException | IOException e) {
 			e.printStackTrace();
 			redirectAttributes.addFlashAttribute("message", "Upload file failed.");
 			return "redirect:/test/index";
 		}

 		return "redirect:/test/index";
 	}

	@RequestMapping("/download")
 	public ResponseEntity<Resource> downLoadFile(@RequestParam String fileName) {
 		try {
 			Resource resource = new UrlResource(Paths.get("D:\\test\\" + fileName).toUri());

 			return ResponseEntity.ok()
 					.header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
 					.header(HttpHeaders.CONTENT_DISPOSITION, 
 							String.format("attachment; filename=\"%s\"", resource.getFilename()))
 					.body(resource);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}

 		return null;
 	}
	
	@RequestMapping("/dashboad")
	public String testDashboadPage(ModelMap modelMap){
		
		modelMap.addAttribute("template", "common/dashboad");
		return "index";
		
	}
}
