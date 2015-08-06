package com.buobao.service.impl.manager;

import com.buobao.bean.BaseEnum;
import com.buobao.dao.BaseDao;
import com.buobao.dao.manager.FileManageDao;
import com.buobao.entity.manager.FileManage;
import com.buobao.service.impl.BaseServiceImpl;
import com.buobao.service.manager.FileManageService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSFile;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by dqf on 2015/7/27.
 */
@Service
public class FileManageServiceImpl extends BaseServiceImpl<FileManage,String> implements FileManageService{
    @Resource
    private FileManageDao fileManageDao;
    @Resource
    private GridFsTemplate gridOperations;

    @Override
    public BaseDao<FileManage, String> getBaseDao() {
        return fileManageDao;
    }

    @Override
    public String saveAndEnable(FileManage fileManage) {
        return fileManageDao.save(fileManage);
    }

    @Override
    public FileManage gridFSSave(InputStream inputStream, String contentType, String filename) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("filename",filename);
        metaData.put("contentType",contentType);

        GridFSFile file = gridOperations.store(inputStream,filename,contentType,metaData);
        String gridId = file.getId().toString();

        FileManage fileManage = new FileManage();
        fileManage.setUrl("file.action?keyId="+gridId);
        fileManage.setGridId(gridId);
        fileManage.setName(filename);
        fileManage.setSize(file.getLength());

        fileManage.setState(BaseEnum.StateEnum.Enable);

        metaData.put("fileId",fileManage.getId());
        file.save();

        return fileManage;
    }

    @Override
    public FileManage gridFSSave(File file, FileManage fileManage, String contentType, String filename) throws IOException {
        return null;
    }

    @Override
    public void gridFSDelete(FileManage fileManage) {
    }

    @Override
    public List<FileManage> getFileByKeyId(String keyId) {
        return null;
    }

    @Override
    public List<FileManage> getFileByKeyIdAndTarget(String keyId, String targetClass) {
        return null;
    }

    @Override
    public List<FileManage> getFileByTask(String keyId, String taskId, String processInstanceId) {
        return null;
    }

    @Override
    public List<FileManage> getFileByTask(String keyId, String taskId, String proId, String swf) {
        return null;
    }
}


























