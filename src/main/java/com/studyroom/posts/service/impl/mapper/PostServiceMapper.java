package com.studyroom.posts.service.impl.mapper;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.studyroom.posts.dto.Post;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PostServiceMapper {

    public static final String ITEMS = "items";
    public static final String TITLE = "title";
    public static final String OWNER = "owner";
    public static final String PROFILE_IMAGE = "profile_image";
    public static final String TAGS = "tags";
    public static final String PUNCTUATION_REGEX = "[\\[\\]\"]";
    public static final String EMPTY_STRING = "";

    public static List<Post> mapResponseToDto(String jsonResponse) {
        JsonObject convertedObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonArray items = convertedObject.getAsJsonArray(ITEMS);
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            posts.add(mapJsonObjectToPost(items.get(i).getAsJsonObject()));
        }

        return posts;
    }

    private static Post mapJsonObjectToPost(JsonObject jsonObject) {

        String title = jsonObject.get(TITLE).getAsString();
        String profileImage = jsonObject.getAsJsonObject(OWNER).get(PROFILE_IMAGE).getAsString();
        String tags = jsonObject.getAsJsonArray(TAGS).toString().replaceAll(PUNCTUATION_REGEX, EMPTY_STRING);
        return Post.builder()
                .profileImage(profileImage)
                .title(title)
                .tags(tags)
                .build();
    }

}
