package services.pet;

import helpers.PetHelper;
import io.restassured.response.Response;
import models.response.CreatePetResponse;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdatePetTest {
    PetHelper petHelper = new PetHelper();

    Integer petId;
    String categoryName = "Dog";
    String petName = "at";
    String photoUrl = "www.www";
    String status = "sold";

    @BeforeTest
    public void beforeTest() {
        petId = petHelper.createPetWithResponseModel("Cat", "Fog","test.ok/test.jpeg","available").id;
    }

    @Test
    public void updatePetHappyPath() {
        Response response = petHelper.updatePet(petId, categoryName, petName, photoUrl, status);
        Assert.assertEquals(response.getStatusCode(), 200, "Status Check Failed");
        Assert.assertEquals(response.jsonPath().getString("category.name"), categoryName);
        Assert.assertEquals(response.jsonPath().getString("name"), petName);
        Assert.assertEquals(response.jsonPath().getString("photoUrls[0]"), photoUrl);
        Assert.assertEquals(response.jsonPath().getString("status"), status);
    }

    @AfterTest
    public void afterTest() {
        petHelper.deletePet(String.valueOf(petId));
    }
}
