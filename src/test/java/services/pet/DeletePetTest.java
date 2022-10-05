package services.pet;

import helpers.CommonHelper;
import helpers.PetHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeletePetTest extends CommonHelper {
    PetHelper petHelper = new PetHelper();
    Integer petId;

    @BeforeTest
    public void beforeTest() {
        logger.info("Before Test : Creating pet with response model");
        petId = petHelper.createPetWithResponseModel("Cat", "Fog","test.ok/test.jpeg","available").id;
    }

    @Test
    public void deletePetHappyPath(){
        logger.info("Delete Pet happy pat");
        Response response = petHelper.deletePet(petId);
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertNull(petHelper.getPetsById(petId).toString());
    }
}
