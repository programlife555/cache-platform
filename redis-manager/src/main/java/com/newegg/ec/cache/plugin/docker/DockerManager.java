package com.newegg.ec.cache.plugin.docker;

import com.newegg.ec.cache.plugin.INodeOperate;
import com.newegg.ec.cache.plugin.INodeRequest;
import com.newegg.ec.cache.plugin.basemodel.*;
import org.springframework.stereotype.Component;

/**
 * Created by lzz on 2018/4/20.
 */
@Component
public class DockerManager implements INodeOperate,INodeRequest {

    @Override
    public boolean pullImage(String imageUrl) {
        return false;
    }

    @Override
    public boolean install(InstallParam installParam) {
        return false;
    }

    @Override
    public boolean start(StartParam startParam) {
        return false;
    }

    @Override
    public boolean stop(StopParam stopParam) {
        return false;
    }

    @Override
    public boolean restart(RestartParam restartParam) {
        return false;
    }

    @Override
    public boolean remove(RemovePram removePram) {
        return false;
    }

    @Override
    public String showInstall() {
        return "plugin/dockerCreateCluster";
    }

    @Override
    public String showManager() {
        return null;
    }
}
