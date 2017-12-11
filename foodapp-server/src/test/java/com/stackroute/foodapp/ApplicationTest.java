//package com.stackroute.foodapp;
//
//
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.context.embedded.LocalServerPort;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.*;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.foodapp.domain.Restaurant;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ApplicationTest  extends TestCase {
////	@Test
////	public void test() {
////		
////	}
//   
//	@LocalServerPort
//	private int port;
//	TestRestTemplate restTemplate = new TestRestTemplate();
//	HttpHeaders headers = new HttpHeaders();
//	Restaurant user;    
//    
//	@Before
//    public void setUp() throws Exception {
//		user = new Restaurant(16,"DarkKnight","imglink","cafe","800","4.0","great place");
//    }
//	
//    private String createURLWithPort(String uri) {
//        return "http://localhost:" + port +"/v2.0/FavouriteService"+ uri;
//    }
//    
//    @After
//    public void tearDown() throws Exception {
//    }
//    
//    @Test
//    public void testuser(){
//    	
//    }
//    @Test
//    public void testSaveUser() throws Exception { 
//
//    	HttpHeaders headers = new HttpHeaders();
//    	headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Restaurant> entity = new HttpEntity<Restaurant>(user, headers); 
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/Favourites"),
//                HttpMethod.POST, entity, String.class); 
//        assertNotNull(response);
//        String actual = response.getBody();
//        assertEquals("Saved",actual);
//    }
//    
//    @Test
//    public void testList() throws Exception {
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/demo/all"),
//                HttpMethod.GET, entity, String.class);
//        assertNotNull(response);
//    }
//    
//    @Test
//    public void testGetUser() throws Exception {
//    }
//    
//    @Test
//    public void testUpdateUser() throws Exception {
//    	HttpHeaders headers = new HttpHeaders();
//    	headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Restaurant> entity = new HttpEntity<Restaurant>(user, headers); 
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/Favourites/16?comments=greatambience"),
//                HttpMethod.PUT, entity, String.class); 
//        assertNotNull(response);
//        String actual = response.getBody();
//        assertEquals("Updated",actual);
//    }
//    
//    @Test
//    public void testDeleteUser() throws Exception {
//    	HttpHeaders headers = new HttpHeaders();
//    	headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Restaurant> entity = new HttpEntity<Restaurant>(user, headers); 
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/Favourites/16"),
//                HttpMethod.DELETE, entity, String.class); 
//        assertNotNull(response);
//        String actual = response.getBody();
//        assertEquals("Deleted",actual);
//    }
//    
//}