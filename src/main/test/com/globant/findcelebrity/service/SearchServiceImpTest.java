package com.globant.findcelebrity.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.globant.findcelebrity.dto.Person;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceImpTest {

	@InjectMocks
	private SearchService searchService = new SearchServiceImp();
	
	@Before
    public void setUp() throws Exception {
         MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testGenerateMatrixInformationAboutPeople() {
		int numberOfPeople = 4;
		int[][] matrix = searchService.informationAboutPeople(numberOfPeople);
		assertNotNull(matrix);
		assertTrue(numberOfPeople==matrix.length);
		for (int i = 0; i < matrix.length; i++) {
			assertEquals(matrix[i][i], 0);
		}		
	}
	
	@Test
	public void testFindTheCelebrityWithRandomMatrix() {
	
		Deque<Person> peopleList = new ArrayDeque<Person>();
		peopleList.push(new Person("Annie", 0));
		peopleList.push(new Person("John", 1));
		peopleList.push(new Person("Caroline", 2));
		
		Person celebrity = searchService.findTheCelebrity(peopleList, searchService.informationAboutPeople(peopleList.size()));
		
		assertNotNull(celebrity);
		assertTrue(celebrity.getName().equals("Annie")||celebrity.getName().equals("John")||celebrity.getName().equals("Caroline"));
	}
}
