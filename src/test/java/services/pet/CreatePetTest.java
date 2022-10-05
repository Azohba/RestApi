package services.pet;

import helpers.PetHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePetTest {
    PetHelper petHelper = new PetHelper();

    String categoryName = "cat";
    String petName = "jiji";
    String photoUrl = "url";
    String[] statuses = {"available","pending","sold"};

    @Test
    public void createPetHappyPath() {
        Response response = petHelper.createPet(categoryName, petName, photoUrl, statuses[0]);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(categoryName, response.jsonPath().getString("category.name"));
        Assert.assertTrue(response.jsonPath().getString("name").equals(petName));
        Assert.assertTrue(response.jsonPath().getString("photoUrls[0]").equals(photoUrl));
        Assert.assertTrue(response.jsonPath().getString("status").equals(statuses[0]));
    }

    @Test
    public void createTestNegatives(){
        Response response = petHelper.createPet(null,null,null,null);

    }
    
}
