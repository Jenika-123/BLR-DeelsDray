package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import objectRepo.categoryPage;

public class createCategoryTest extends BaseClass{
	@Test
	public void addCategoryTest() {
		SoftAssert soft=new SoftAssert();
		home.clickcoursesTab();
		home.clickcategory();
		soft.assertEquals(category.getPageHeader(),"Category");
		category.clickNewBTN();
		category.addCategory(web,"Java");
		Map<String,String>map=excel.readFromExcel("Add Category");
		category.addCategory(map.get("Name"));
		 soft.assertTrue(category.searchForCategory(map.get("Name")));
	 soft.assertTrue(category.getAlertMessage().contains("Category added"));
	 soft.assertTrue(category.searchForCategory("Java"));
	 System.out.println(category.getAlertMessage());
	category.deleteCategory(web,map.get("Name"));
	 soft.assertFalse(category.searchForCategory(map.get("Name")));
		 soft.assertTrue(category.getAlertMessage().contains("Category deleted"));
		 soft.assertAll();
		
		
	}

}
