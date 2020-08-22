package com.codefix.gitbuddy.app.dtos.treeResponse;

import java.util.List;

public class TreeResponse {

    private String sha;
    private String url;
    private List<FilePaths> tree;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<FilePaths> getTree() {
        return tree;
    }

    public void setTree(List<FilePaths> tree) {
        this.tree = tree;
    }
}

