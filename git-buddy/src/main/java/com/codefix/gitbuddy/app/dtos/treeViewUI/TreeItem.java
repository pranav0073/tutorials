package com.codefix.gitbuddy.app.dtos.treeViewUI;

import java.util.ArrayList;
import java.util.List;

public class TreeItem {
    private String fileName;
    private String url;
    private boolean isFile;
    List<TreeItem> treeItemList;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    public List<TreeItem> getTreeItemList() {
        return treeItemList;
    }

    public void setTreeItemList(List<TreeItem> treeItemList) {
        this.treeItemList = treeItemList;
    }

    public void addItem(TreeItem treeItem){
        if(this.treeItemList != null){
            treeItemList.add(treeItem);
        }else{
            treeItemList =  new ArrayList<>();
            treeItemList.add(treeItem);
        }
    }
}
