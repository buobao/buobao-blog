package com.buobao.dao.manager;

import com.buobao.dao.BaseDao;
import com.buobao.entity.manager.FileManage;

import java.util.List;

/**
 * Created by dqf on 2015/7/27.
 */
public interface FileManageDao extends BaseDao<FileManage, String> {
    /*依据keyId查找文件*/
    List<FileManage> getFileById(String keyId);
    /*依据keyId和targetClass查询*/
    List<FileManage> getFileByIdAndTarget(String keyId, String targetClass);
    List<FileManage> getFileByTask(String keyId, String taskId, String processInstanceId);
    List<FileManage> getFileByTask(String keyId, String taskId, String proId, String type);
}
