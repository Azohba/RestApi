package models.request;

import java.util.ArrayList;

public class CreatePetRequest {
    public int id;
    public Category category;
    public String name;
    public ArrayList<String> photoUrls;
    public ArrayList<Tag> tags;
    public String status;

    private CreatePetRequest(Builder builder) {
        id = builder.id;
        category = builder.category;
        name = builder.name;
        photoUrls = builder.photoUrls;
        tags = builder.tags;
        status = builder.status;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Tag{
        public int id;
        public String name;

        private Tag(Builder builder) {
            id = builder.id;
            name = builder.name;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static final class Builder {
            private int id;
            private String name;

            private Builder() {
            }

            public Builder withId(int val) {
                id = val;
                return this;
            }

            public Builder withName(String val) {
                name = val;
                return this;
            }

            public Tag build() {
                return new Tag(this);
            }
        }
    }

    public static class Category{
        public int id;
        public String name;

        private Category(Builder builder) {
            id = builder.id;
            name = builder.name;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static final class Builder {
            private int id = 0;
            private String name;

            private Builder() {
            }

            public Builder withId(int val) {
                id = val;
                return this;
            }

            public Builder withName(String val) {
                name = val;
                return this;
            }

            public Category build() {
                return new Category(this);
            }
        }
    }

    public static final class Builder {
        private int id;
        private Category category;
        private String name;
        private ArrayList<String> photoUrls = new ArrayList<>();
        private ArrayList<Tag> tags  = new ArrayList<>();
        private String status;

        private Builder() {
        }

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public Builder withCategory(Category val) {
            category = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withPhotoUrls(ArrayList<String> val) {
            photoUrls = val;
            return this;
        }

        public Builder addPhotoUrls(String val) {
            photoUrls.add(val);
            return this;
        }

        public Builder withTags(ArrayList<Tag> val) {
            tags = val;
            return this;
        }

        public Builder addTags(Tag val) {
            tags.add(val);
            return this;
        }

        public Builder withStatus(String val) {
            status = val;
            return this;
        }

        public CreatePetRequest build() {
            return new CreatePetRequest(this);
        }
    }
}
