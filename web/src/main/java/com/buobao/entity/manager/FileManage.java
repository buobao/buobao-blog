package com.buobao.entity.manager;

import com.buobao.bean.BaseEnum.StateEnum;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by dqf on 2015/7/27.
 */
@Entity
@Table(name="blog_filemanage")
public class FileManage extends com.buobao.entity.Entity{
    private String targetId;
    private String targetClass;
    private String name;
    private String url;
    private String gridId;
    private String keyId;
    private String taskId;
    private String proIntanceId;
    private long size;
    private String type;
    private StateEnum state;

    public FileManage(){super();}
    public FileManage(String filename, String gridId, String keyId, String proIntanceId, String taskId, String type){
        super();
        this.name = filename;
        this.gridId = gridId;
        this.keyId = keyId;
        this.proIntanceId = proIntanceId;
        this.taskId = taskId;
        this.type = type;
        this.url = "file.action?keyId="+gridId;
        this.state = StateEnum.Enable;
    }
    public FileManage(String filename, String gridId, String keyId, String proIntanceId, String taskId){
        super();
        this.name = filename;
        this.gridId = gridId;
        this.keyId = keyId;
        this.taskId = taskId;
        this.proIntanceId=proIntanceId;
        this.url = "file.action?keyId="+gridId;
        this.state = StateEnum.Enable;
    }
    public FileManage(String filename, String gridId, String keyId){
        super();
        this.name = filename;
        this.gridId = gridId;
        this.keyId = keyId;
        this.url = "file.action?keyId="+gridId;
        this.state = StateEnum.Enable;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(String targetClass) {
        this.targetClass = targetClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGridId() {
        return gridId;
    }

    public void setGridId(String gridId) {
        this.gridId = gridId;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getProIntanceId() {
        return proIntanceId;
    }

    public void setProIntanceId(String proIntanceId) {
        this.proIntanceId = proIntanceId;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }
}
