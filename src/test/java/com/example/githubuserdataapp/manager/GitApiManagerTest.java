package com.example.githubuserdataapp.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class GitApiManagerTest {
    private static UserRequestManager userRequestManager;
    private static GitApiManager gitApiManager;
    private static RestTemplateBuilder restTemplateBuilder;

    @BeforeAll
    static void createGitApiManagerObject() throws FileNotFoundException {
        userRequestManager = mock(UserRequestManager.class);
        restTemplateBuilder = mock(RestTemplateBuilder.class);
        gitApiManager = new GitApiManager(userRequestManager, restTemplateBuilder);
    }

    @Test
    void getCalculateParamValueWhenFollowValueIsZero() {
        Integer follow = 0;
        Integer publicRepo = 5;

        float result = gitApiManager.getCalculateParamValue(follow,publicRepo);

        assertEquals(result, 0F);

    }

    @Test
    void getCalculateParamValueWhenFollowAndPublicReposValueIsGreaterThanZero() {
        Integer follow = 10;
        Integer publicRepo = 50;

        float result = gitApiManager.getCalculateParamValue(follow,publicRepo);

        assertEquals(result, 31.2F);
    }

    @Test
    void getCalculateParamValueWhenPublicReposValueIsNull() {
        Integer follow = 10;
        Integer publicRepo = null;

        float result = gitApiManager.getCalculateParamValue(follow,publicRepo);

        assertEquals(result, 1.2F);
    }

    @Test
    void getCalculateParamValueWhenFollowIsNull() {
        Integer follow = null;
        Integer publicRepo = 5;

        float result = gitApiManager.getCalculateParamValue(follow,publicRepo);

        assertEquals(result, 0F);
    }
}
