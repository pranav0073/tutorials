package com.codefix.gitbuddy.app.dtos.treeResponse;

/*
*
*
* "path": "-pre-wrap",
			  "mode": "100644",
			  "type": "blob",
			  "sha": "45a7fe5901ddf535c0a281bea18f9d2cf5a338f2",
			  "size": 11603,
			  "url": "https://api.github.com/repos/pranav0073/codefix/git/blobs/45a7fe5901ddf535c0a281bea18f9d2cf5a338f2"
		  },
*
* */
public class FilePaths {

    private String path;
    private String mdoe;
    private String type;
    private String sha;
    private long size;
    private String url;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMdoe() {
        return mdoe;
    }

    public void setMdoe(String mdoe) {
        this.mdoe = mdoe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
