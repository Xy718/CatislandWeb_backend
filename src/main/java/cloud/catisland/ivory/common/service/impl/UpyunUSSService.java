package cloud.catisland.ivory.common.service.impl;

import java.io.File;
import java.util.Optional;


import org.springframework.stereotype.Service;

import cloud.catisland.ivory.common.service.ImageService;
import cloud.catisland.ivory.common.util.UpyunUSSUtil;

// @Service
public class UpyunUSSService implements ImageService {

    @Override
    public Optional<String> upImage(File imgFile) {
        // TODO Auto-generated method stub
        return UpyunUSSUtil.upFile(imgFile, "/test2");
    }

    @Override
    public Optional<Boolean> deleteImage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<String> copy() {
        // TODO Auto-generated method stub
        return null;
    }
    
}