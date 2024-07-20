package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductPageInfoTest extends BaseTest {

	//AAA -->UTs
		//TC -- only one hard assertion or can have multiple soft assertions
		
		@BeforeClass
		public void infoPageSetup() {
			accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		}
		
		
		@Test
		public void productHeaderTest() {
			searchResultsPage = accPage.doSearch("macbook");
			productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
			Assert.assertEquals(productInfoPage.getProductHeader(), "MacBook Pro");
		}
		
		
		@Test
		public void productImagesCountTest() {
			searchResultsPage = accPage.doSearch("imac");
			productInfoPage = searchResultsPage.selectProduct("iMac");
			Assert.assertEquals(productInfoPage.getProductImagesCount(), 3);
		}
		
		
		@Test
		public void productInfoTest() {
			searchResultsPage = accPage.doSearch("macbook");
			productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
			Map<String, String> productActDetailsMap = productInfoPage.getProductDetailsMap();
			softAssert.assertEquals(productActDetailsMap.get("Brand"), "Apple");
			softAssert.assertEquals(productActDetailsMap.get("Product Code"), "Product 18");
			softAssert.assertEquals(productActDetailsMap.get("Availability"), "In Stock");
			softAssert.assertEquals(productActDetailsMap.get("productprice"), "$2,000.00");
			softAssert.assertEquals(productActDetailsMap.get("extaxprice"), "$2,000.00");
			softAssert.assertAll();
			
		}
}
