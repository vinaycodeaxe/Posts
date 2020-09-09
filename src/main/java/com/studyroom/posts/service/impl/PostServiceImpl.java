package com.studyroom.posts.service.impl;

import com.studyroom.posts.dto.Post;
import com.studyroom.posts.service.PostService;
import com.studyroom.posts.service.impl.helper.PostServiceHelper;
import com.studyroom.posts.service.impl.mapper.PostServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private static final String URL = "https://api.stackexchange.com/2.2/search?order=desc&sort=activity&intitle=perl&site=stackoverflow";
    private final PostServiceHelper postServiceHelper;

    @Override
    public List<Post> getPostData() {
        String data = postServiceHelper.getDataFromExternalApi(URL);
        return PostServiceMapper.mapResponseToDto(data);
    }
}
