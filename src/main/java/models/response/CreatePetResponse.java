package models.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePetResponse {
	@JsonProperty("photoUrls")
	public ArrayList<String> photoUrls;

	@JsonProperty("name")
	public String name;

	@JsonProperty("id")
	public int id;

	@JsonProperty("category")
	public Category category;

	@JsonProperty("tags")
	public ArrayList<Tag> tags;

	@JsonProperty("status")
	public String status;

	public static class Tag{
		@JsonProperty("name")
		public String name;

		@JsonProperty("id")
		public int id;
	}

	public static class Category{
		@JsonProperty("name")
		public String name;

		@JsonProperty("id")
		public int id;
	}
}