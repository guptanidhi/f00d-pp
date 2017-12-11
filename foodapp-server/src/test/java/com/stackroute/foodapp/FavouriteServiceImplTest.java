//package com.stackroute.foodapp;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import com.stackroute.foodapp.domain.Restaurant;
//import com.stackroute.foodapp.repository.UserRepository;
//import com.stackroute.foodapp.service.jpa_impl.FavouriteServiceImpl;
//
//import static org.mockito.Mockito.*;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//
//
//
//public class FavouriteServiceImplTest {
//	
//
//   private FavouriteServiceImpl productServiceImpl;
//   @Mock
//   private UserRepository productRepository;
//   @Mock
//   private Restaurant product;
//   @Before
//   public void setupMock() {
//       MockitoAnnotations.initMocks(this);
//       productServiceImpl=new FavouriteServiceImpl();
//       productServiceImpl.setUserRepository(productRepository);
//   }
//   @Test
//   public void shouldReturnProduct_whenGetProductByIdIsCalled() throws Exception {
//       // Arrange
//       when(productRepository.findOne(5)).thenReturn(product);
//       // Act
//       Restaurant retrievedProduct = productServiceImpl.getbyid(5);
//       // Assert
//       assertThat(retrievedProduct, is(equalTo(product)));
//
//   }
//   @Test
//   public void shouldReturnProduct_whenSaveProductIsCalled() throws Exception {
//       // Arrange
//       when(productRepository.save(product)).thenReturn(product);
//       // Act
//       Restaurant savedProduct = productServiceImpl.addNewUser(product);
//       // Assert
//       assertThat(savedProduct, is(equalTo(product)));
//   }
//   @Test
//   public void shouldCallDeleteMethodOfProductRepository_whenDeleteProductIsCalled() throws Exception {
//       // Arrange
//       doNothing().when(productRepository).delete(5);
//       UserRepository my = Mockito.mock(UserRepository.class);
//       // Act
//       productServiceImpl.deletebyid(5);
//       // Assert
//       verify(productRepository, times(1)).delete(5);
//   }
//}
//
//
//
