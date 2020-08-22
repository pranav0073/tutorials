package com.codefix.gitbuddy.app.controller;

import com.codefix.gitbuddy.app.dtos.treeViewUI.TreeItem;
import com.codefix.gitbuddy.app.service.git.GitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/codefix")
public class CodefixController {

    private static final Logger  logger =  LoggerFactory.getLogger(CodefixController.class);
    @Autowired
    private GitService gitService;

    @CrossOrigin(origins = {"*"})
    @GetMapping("/treeView")
    public TreeItem getTreeView(){
        TreeItem treeItem = gitService.getTreeViewForUi();
        logger.info("git service response  {}", treeItem);
       return treeItem;
    }

    @GetMapping("/greet")
    public String greet(){
        logger.info("hello");
        return "Hello";
    }
}
