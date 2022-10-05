package services.pet;

import helpers.PetHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindPetByStatusTest {
    PetHelper petStoreHelper = new PetHelper();


    @Test
    public void findPetByStatusHappyPath(){
        Response response=  petStoreHelper.getPetsByStatus("available");
        Assert.assertEquals(response.getStatusCode(),200,"Status Check Failed");
        Assert.assertNotNull(response.body());
        for (int i=0;i<response.jsonPath().getList("$.").size();i++){
            Assert.assertNotNull(response.jsonPath().getString("["+i+"].id"),i + "th Id is null");
            Assert.assertEquals(response.jsonPath().getString("["+i+"].status"),"available","fail");
        }
    }

    @Test
    public void findPetByStatusCheckWithWhiteSpaceStatus(){
        Response response = petStoreHelper.getPetsByStatus("  ");
        Assert.assertEquals(response.getStatusCode(),200,"Status check failed");
        Assert.assertEquals(response.body().asString(),"[]");
    }

    @Test
    public void findPetByStatusCheckWithNullStatus(){
       Response  response = petStoreHelper.getPetsByStatus(null);
        Assert.assertEquals(response.getStatusCode(),200,"Status check failed");
        Assert.assertEquals(response.body().asString(),"[]");
    }

    @Test
    public void findPetByStatusCheckWithInvalidStatus(){
       Response response = petStoreHelper.getPetsByStatus("invalidStatus");
        Assert.assertEquals(response.getStatusCode(),200,"Status check failed");
        Assert.assertEquals(response.body().asString(),"[]");
    }
}
