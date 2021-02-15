package com.dip.domain.concrete;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Menu implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7377588088040957513L;
    private int id;
    private String parentId;
    private String menuId;
    private String menuName;
    private String status;
    private String isParent;
    private String menuLevel;
    private Timestamp createTime;
    private Timestamp updateTime;
    private List<Menu> childList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public List<Menu> getChildList() {
        return childList;
    }

    public void setChildList(List<Menu> childList) {
        this.childList = childList;
    }

    public Menu() {

    }

    public Menu(int id, String parentId, String menuId, String menuName, String status, String isParent,
                String menuLevel, Timestamp createTime, Timestamp updateTime, List<Menu> childList) {
        super();
        this.id = id;
        this.parentId = parentId;
        this.menuId = menuId;
        this.menuName = menuName;
        this.status = status;
        this.isParent = isParent;
        this.menuLevel = menuLevel;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.childList = childList;
    }

}
