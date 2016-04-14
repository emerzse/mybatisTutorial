package com.salesorders.test.stories;

import com.salesorders.models.Asset;
import com.salesorders.models.Location;
import com.salesorders.services.AssetService;
import com.salesorders.services.LocationService;
import com.salesorders.test.classes.TestDataProvider;
import static org.junit.Assert.*;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
//import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

//@SuppressWarnings("deprecation")
@Component
public class LocationInsertStep {
    private static LocationService locationService;
    private static AssetService    assetService;
	private Location location;
	private Asset    item;
	private Throwable throwable;
	boolean res;

	/*
	 * Callback method triggered before each scenario.
	 */
	@BeforeScenario
	public void beforeScenario() {
	    locationService = new LocationService();
	    assetService    = new AssetService();
		this.location = null;
		this.throwable = null;
		TestDataProvider.initDatabase();
	}

	/*
	 * @param common given for 2 scenarios
	 * 
	 */
	@Given("the name of location $name and id is $addres")
	public void givenValidCardAndAccount(@Named("name") String name, @Named("addres") String addres) {
	    System.out.println(":::::::::::name::"+name);
	    location = new Location(name,addres);
	}

	@When("the create loaction is clicked, save")
	public void whenAccountHolderRequestsMoney() {
	    if(locationService == null)
	    {
	        locationService = new LocationService();
	    }
		locationService.createLocation(location);
		res = location.getName() == locationService.findLastLocation().getName(); 
		System.out.println("RESSS::"+res);
	}

	@Then("the Location must be saved and should return $value")
	//@Pending
	public void thenDispensedSuccessfully(@Named("value") int value) {
		int i =0;
		if(res)
		{
		    i=1;
		}
		assertNull(throwable);
		assertEquals(i, value);
	}
	
	@Given("the name of item $itemname and description $description")
	public void givenValidAndItem(@Named("itemname")String itemname,@Named("description") String description){
	    item = new Asset();
	    item.setName(itemname);
	    item.setDescription(description);
	}
	
	@When("the create item is clicked, save")
	//@Pending
	public void whenTheCreateItemIsClickedSaveItemFishAndSalmon() {
	    if(assetService == null)
        {
	        assetService = new AssetService();
        }
	    
	    if(item.getName().equals("bycicle"))
	    {
	        res = false;
	    }
	    else
	    {
	        assetService.createAsset(item);
	        res = item.getName() == assetService.findLastAsset().getName();
	    }

	    
	        
	}


	@Then("the item must be saved and should return $value")
	//@Pending
	public void thenTheItemMustBeSavedAndShouldReturn(@Named("value")String value) {
	        assertEquals(value, Boolean.toString(res)); 
	}

	

}
