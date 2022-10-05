package services.pet;

import helpers.PetHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DeletePetTest {
    PetHelper petHelper = new PetHelper();

    @Test
    public void deletePetHappyPath(){
        Response responseForId = petHelper.getPetsByStatus("available");
        String  id =  responseForId.jsonPath().getString("[0].id");
        Response response = petHelper.deletePet(id);
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(petHelper.getPetsById(id).getStatusCode(),200);
    }
}
