package com.codefix.gitbuddy.app.service.git;

import com.codefix.gitbuddy.app.dtos.treeResponse.TreeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class GitTreeService {


    @Autowired
    RestTemplate restTemplate;

    private static final String gitEndPoint  = "https://api.github.com";
    private static final String treeEndpoint =  "/repos/{user}/{repo}/git/trees/{sha}";
    public TreeResponse getGitTree(String user, String repo, String sha){

        UriComponentsBuilder builder =  UriComponentsBuilder.fromUriString(gitEndPoint);
        builder.path(treeEndpoint);
        builder.queryParam("recursive",true);
        String url = builder.buildAndExpand(user, repo, sha).toUriString();
        System.out.println("attempting to hit " + url);
        ResponseEntity<TreeResponse>  treeResponseResponseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<TreeResponse>() {
        });



        return treeResponseResponseEntity.getBody();
    }

}
