package com.globant.findcelebrity.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.globant.findcelebrity.constant.SearchConstant;
import com.globant.findcelebrity.dto.Person;
import com.globant.findcelebrity.service.SearchService;


@Controller
@RequestMapping("search")
public class SearchController {
	
	private static Logger logger = Logger.getLogger(SearchController.class.getName());
	
	@Autowired
	private SearchService searchService;

	@GetMapping("/celebrity")
	public String listCustomers(Model theModel) {
		return SearchConstant.UPLOAD_FORM;
	}
	
	
	@PostMapping("/uploadFile")
	public String uploadPeopleFile(@RequestParam("file") MultipartFile file, Model theModel) {
		String output = SearchConstant.ERROR;
		if (!file.isEmpty() && SearchConstant.TEXT.equals(file.getContentType())) {
			BufferedReader buffReader;
			Deque<Person> peopleList = new ArrayDeque<Person>();
			List<String> listToPrint = new ArrayList<>();
			Person celebrity;
			int index = 0;
				try {
				     String line;
				     InputStream inputStream = file.getInputStream();
				     buffReader = new BufferedReader(new InputStreamReader(inputStream));
				     while ((line = buffReader.readLine()) != null) {
				    	 if(!line.trim().isEmpty() && !(line.trim().length()>15)) {
				    	 Person person = new Person(line.trim(), index);
				    	 peopleList.push(person);
				    	 listToPrint.add(line.trim());
				    	 index++;
				    	 }
				     }

				     int[][] peopleResultMatrix = searchService.informationAboutPeople(peopleList.size());
				     celebrity = searchService.findTheCelebrity(peopleList, peopleResultMatrix);
				     theModel.addAttribute(SearchConstant.ATTRIBUTE_CELEBRITY, celebrity);
				     theModel.addAttribute(SearchConstant.ATTRIBUTE_MATRIX, printMatrix(peopleResultMatrix, listToPrint));
				     output = SearchConstant.SUCCESS;
				     
				  } catch (Exception e) {
				    logger.warning("Throw an exception:"+e.getMessage()); 
				    output = SearchConstant.ERROR;
				  }			
		} 		
		return output;
	}
	
	/**
	 * Print Matrix in the HTML page
	 * @param matrix: Results of the question: ¿Do you know him/her? 0:No, 1:Yes
	 * @param listToPrint: Initial list of people
	 * @return HTML code with the table for the matrix
	 */
	private String printMatrix(int[][] matrix, List<String> listToPrint) {
		StringBuilder builder = new StringBuilder();		
		builder.append("<table>");
		
		builder.append("<tr><td></td>");
		listToPrint.stream().forEach(e->builder.append("<td>"+e+"</td>"));
		builder.append("</tr>");
		
		for (int x=0; x < matrix.length; x++) {
			builder.append("<tr>");
			builder.append("<td>");
			builder.append(listToPrint.get(x));
			builder.append("</td>");
			  for (int y=0; y < matrix[x].length; y++) {
				  builder.append("<td>");
				  builder.append(matrix[x][y]);
				  builder.append("</td>");			    
			  }
			  builder.append("</tr>");
			}
		builder.append("</table>");
		return builder.toString();
	}
}
