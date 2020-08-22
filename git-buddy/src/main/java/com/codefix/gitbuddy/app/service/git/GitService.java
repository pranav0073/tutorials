package com.codefix.gitbuddy.app.service.git;

import com.codefix.gitbuddy.app.dtos.treeResponse.TreeResponse;
import com.codefix.gitbuddy.app.dtos.treeViewUI.TreeItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GitService {
    private static Logger logger =  LoggerFactory.getLogger(GitService.class);
    @Autowired
    private GitTreeService gitTreeService;

    public TreeItem getTreeViewForUi(){
        TreeResponse treeResponse = gitTreeService.getGitTree("pranav0073","finbox","0919e604cfabb430cc376cdfc1b5723b8b68a701");
        TreeItem treeItem =  new TreeItem();
        treeItem.setFileName("codeFix");
        treeItem.setFile(false);

        Map<String,TreeItem> localStore = new HashMap<>();
        logger.info("tree response size {}",    treeResponse.getTree().size());
        treeResponse.getTree().stream().forEach(
                t->{
                    String path = t.getPath();
                    String[] folders =path.split("/");
                    if(folders.length == 1){
                        TreeItem treeItem1 =  new TreeItem();
                        treeItem1.setFile(true);
                        treeItem1.setUrl(t.getUrl());
                        treeItem1.setFileName(t.getPath());
                        localStore.put(path,treeItem1);
                    }else{
                        String localPath = "";
                        TreeItem lastParent =null;
                        for(int i=0; i< folders.length-1; i++){
                            localPath = localPath.isEmpty() ? folders[i]: localPath+"/"+folders[i];
                            if(localStore.containsKey(localPath)){
                                lastParent =  localStore.get(localPath);

                                continue;
                            }else{
                                TreeItem treeItem1 =  new TreeItem();
                                treeItem1.setFileName(folders[i]);
                                localStore.put(localPath,treeItem1);
                            }

                            lastParent =  localStore.get(localPath);
                        }
                        //after creating folder add the file
                        TreeItem treeItem2 =  new TreeItem();
                        treeItem2.setFileName(folders[folders.length-1]);
                        treeItem2.setUrl(t.getUrl());
                        if(lastParent != null){
                            lastParent.addItem(treeItem2);
                            localStore.put(localPath+"/"+folders[folders.length-1],treeItem2);
                        }

                    }

                }

        );
        List<TreeItem>  rootItemList = localStore.values().stream().filter(v->v.isFile()).collect(Collectors.toList());
        treeItem.setTreeItemList(rootItemList);
        return treeItem;
    }
}
