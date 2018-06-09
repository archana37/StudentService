package com.eurekaclient.SchoolService.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(SchoolServiceController.class)
public class SchoolServiceControllerTest {

	@Autowired
	   private MockMvc mvc;

	   @MockBean
	   private SchoolServiceController schoolServiceController;
	   
	   @Test
	   public void isValidSchool() throws Exception {
		   
		   given(this.schoolServiceController.getSchoolList("xyzschool"))
			.willReturn("xyz school");
		   this.mvc.perform(get("/getSchool/xyzschool").accept(MediaType.TEXT_PLAIN))
			.andExpect(status().isOk()).andExpect(content().string("xyz school"));
	
		  //Mockito.when(schoolServiceController.getSchoolList("xyzschool")).thenReturn("xyz school");
		  
	   }
	   
	   @Test
	   public void isNotValidSchool() throws Exception {
		   
		 // Mockito.when(schoolServiceController.getSchoolList("jjjjj")).thenThrow(new Exception("is not valid school"));
		  /* given(this.schoolServiceController.getSchoolList("xyzschool"))
			.willThrow(new Throwable("School not found"));
		   this.mvc.perform(get("/getSchool/xyzschool").accept(MediaType.TEXT_PLAIN))
			.andExpect(status().isInternalServerError()).andExpect(content().string("School not found"));
	*/
		   Mockito.when(schoolServiceController.getSchoolList("abc")).thenThrow(new Exception("is not valid school"));

	       this.mvc.perform(get("/getSchool/abc"))
	                .andExpect(status().isNotAcceptable());
	       
	       
	                
	        //verify(schoolServiceController, times(1)).getSchoolList("abc");
		  
	   }
}
