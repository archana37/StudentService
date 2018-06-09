package com.eurekaclient.SchoolService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SchoolServiceController {

	
	@RequestMapping(value="/getSchool/{schoolName}",method=RequestMethod.GET)
	public String getSchoolList(@PathVariable String schoolName) throws Exception {
		
		List<String> schoolList = new ArrayList<String>();
		schoolList.add("abcschool");
		schoolList.add("xyzschool");
		
		if( !schoolList.contains(schoolName)) { 
			throw new Exception();
		}
		
		return schoolName;
	}
}
