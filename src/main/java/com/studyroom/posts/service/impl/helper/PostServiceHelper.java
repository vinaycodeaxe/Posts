package com.studyroom.posts.service.impl.helper;

import com.studyroom.posts.Exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class PostServiceHelper {

    private final RestTemplate restTemplate;

    public String getDataFromExternalApi(String url) {
        try {

            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            throw new BusinessException("Not able to Fetch Data from External Api");
        }
    }
}
