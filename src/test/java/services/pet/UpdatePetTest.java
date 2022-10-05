package services.pet;

import helpers.PetHelper;
import io.restassured.response.Response;
import models.request.UpdatePetRequest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static helpers.config.ApiConstant.PetStoreEndPoints.PET;

public class UpdatePetTest {

    PetHelper petHelper = new PetHelper();
    Integer petId = 24621246;
    String categoryName = "Dog";
    String petName = "at";
    String photoUrl = "www.www";
    String status = "sold";


    @Test
    public void updatePetHappyPath(){
        Response response = petHelper.updatePet(petId,categoryName,petName,photoUrl,status);
        Assert.assertEquals(response.getStatusCode(),200,"Status Check Failed");
        Assert.assertEquals(response.jsonPath().getString("category.name"),categoryName);
        Assert.assertEquals(response.jsonPath().getString("name"),petName);
        Assert.assertEquals(response.jsonPath().getString("photoUrls[0]"),photoUrl);
        Assert.assertEquals(response.jsonPath().getString("status"),status);
    }

    @Test
    public void updatePetNegativeCases(){
        Response response = petHelper.updatePet(petId,null,petName,photoUrl,status);

    }
}
