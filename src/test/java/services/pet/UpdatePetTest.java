package services.pet;

import helpers.CommonHelper;
import helpers.PetHelper;
import io.restassured.response.Response;
import models.response.CreatePetResponse;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdatePetTest extends CommonHelper {
    PetHelper petHelper = new PetHelper();

    Integer petId;
    String categoryName = "Dog";
    String petName = "at";
    String photoUrl = "www.www";
    String status = "sold";

    @BeforeTest
    public void beforeTest() {
        logger.info("Before Test create pet for Update");
        petId = petHelper.createPetWithResponseModel("Cat", "Fog","test.ok/test.jpeg","available").id;
    }

    @Test
    public void updatePetHappyPath() {
        logger.info("Update Path happy path");
        Response response = petHelper.updatePet(petId, categoryName, petName, photoUrl, status);
        Assert.assertEquals(response.getStatusCode(), 200, "Status Check Failed");
        Assert.assertEquals(response.jsonPath().getString("category.name"), categoryName);
        Assert.assertEquals(response.jsonPath().getString("name"), petName);
        Assert.assertEquals(response.jsonPath().getString("photoUrls[0]"), photoUrl);
        Assert.assertEquals(response.jsonPath().getString("status"), status);
    }

    @AfterTest
    public void afterTest() {
        logger.info(" After test - Delete pet");
        petHelper.deletePet(petId);
    }
}
