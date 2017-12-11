//package com.stackroute.foodapp;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import com.stackroute.foodapp.domain.Restaurant;
//import com.stackroute.foodapp.repository.UserRepository;
//import com.stackroute.foodapp.service.jpa_impl.FavouriteServiceImpl;
//
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.when;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class ProductServiceImplSpyTest {
//	
//   @Spy
//   private FavouriteServiceImpl prodServiceSpy;
//   @Mock
//   private UserRepository productRepository;
//   @Mock
//   private Restaurant product;
//
//   @Test(expected=NullPointerException.class)
//   public void shouldThrowNullPointerException_whenGetProductByIdIsCalledWithoutContext() throws Exception {
//       //Act
//	   Restaurant retrievedProduct = prodServiceSpy.getbyid(5);
//       //Assert
//       assertThat(retrievedProduct, is(equalTo(product)));
//   }
//   
//   @Test(expected=NullPointerException.class)
//   public void shouldThrowNullPointerException_whenSaveProductIsCalledWithoutContext() throws Exception {
//       //Arrange
//       Mockito.doReturn(product).when(productRepository).save(product);
//       //Act
//       Restaurant savedProduct = prodServiceSpy.addNewUser(product);
//       //Assert
//       assertThat(savedProduct, is(equalTo(product)));
//   }
//
//   @Test
//   public void shouldVerifyThatGetProductByIdIsCalled() throws Exception {
//       //Arrange
//       Mockito.doReturn(product).when(prodServiceSpy).getbyid(5);
//       //Act
//       Restaurant retrievedProduct = prodServiceSpy.getbyid(5);
//       //Assert
//       Mockito.verify(prodServiceSpy).getbyid(5);
//   }
//   @Test
//   public void shouldVerifyThatSaveProductIsNotCalled() throws Exception {
//       //Arrange
//       Mockito.doReturn(product).when(prodServiceSpy).getbyid(5);
//       //Act
//       Restaurant retrievedProduct = prodServiceSpy.getbyid(5);
//       //Assert
//       Mockito.verify(prodServiceSpy,never()).addNewUser(product);
//   }
//}