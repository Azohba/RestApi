package helpers;

import client.RestAssuredClient;
import config.ApiConstant;
import io.restassured.response.Response;
import models.request.CreatePetRequest;
import models.request.UpdatePetRequest;
import models.response.CreatePetResponse;

import java.util.HashMap;
import java.util.Map;

import static config.ApiConstant.PetStoreEndPoints.PET;

public class PetHelper extends RestAssuredClient {
    public PetHelper() {
        super(ApiConstant.PetStore.BASE_URL);
    }
    CommonHelper commonHelper = new CommonHelper();

    public Response getPetsByStatus(String status){
        Map<String,Object> params = new HashMap<>();
        params.put("status",status);
        return get(PET+"/findByStatus",params,null,null);
    }
    public Response getPetsById(Integer id){
        Map<String,Object> params = new HashMap<>();
        params.put("id",id);
        return get(PET,params,null,null);
    }

    public Response createPet(String categoryName, String petName, String photoUrl, String status){
        CreatePetRequest.Category category = CreatePetRequest.Category.newBuilder()
                .withName(categoryName).build();
        CreatePetRequest.Tag tag = CreatePetRequest.Tag.newBuilder()
                .withId(commonHelper.getRandomNumber(3))
                .withName(commonHelper.getRandomString(5)).build();
        CreatePetRequest createPetRequest = CreatePetRequest.newBuilder()
                .withId(commonHelper.getRandomNumber(8))
                .withCategory(category)
                .withName(petName)
                .addPhotoUrls(photoUrl)
                .addTags(tag)
                .withStatus(status).build();
        return post(PET,null,null,createPetRequest);
    }

    public CreatePetResponse createPetWithResponseModel(String categoryName, String petName, String photoUrl, String status){
        CreatePetRequest.Category category = CreatePetRequest.Category.newBuilder()
                .withName(categoryName).build();
        CreatePetRequest.Tag tag = CreatePetRequest.Tag.newBuilder()
                .withId(commonHelper.getRandomNumber(3))
                .withName(commonHelper.getRandomString(5)).build();
        CreatePetRequest createPetRequest = CreatePetRequest.newBuilder()
                .withId(commonHelper.getRandomNumber(8))
                .withCategory(category)
                .withName(petName)
                .addPhotoUrls(photoUrl)
                .addTags(tag)
                .withStatus(status).build();
        Response response = post(PET,null,null,createPetRequest);
        return response.body().as(CreatePetResponse.class);
    }

    public Response deletePet(Integer petId){
        Response response = delete(PET + "/" + petId,null,null,null);
        return response;
    }

    public Response updatePet(Integer petId,String categoryName,String petName,String photoUrl,String status){
        UpdatePetRequest.Category category = UpdatePetRequest.Category.newBuilder()
                .withName(categoryName).build();
        UpdatePetRequest.Tag tag = UpdatePetRequest.Tag.newBuilder()
                .withId(commonHelper.getRandomNumber(3))
                .withName(commonHelper.getRandomString(6)).build();
        UpdatePetRequest updatePetRequest = UpdatePetRequest.newBuilder()
                .withId(petId)
                .withCategory(category)
                .withName(petName)
                .addPhotoUrls(photoUrl)
                .addTags(tag)
                .withStatus(status).build();
        return put(PET,null,null,updatePetRequest);
    }
}
