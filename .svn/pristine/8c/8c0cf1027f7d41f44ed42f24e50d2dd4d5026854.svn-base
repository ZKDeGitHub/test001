package com.javasm.entity;


import java.util.List;

public class Menu {

    private Integer menuId;
    private String menuName;
    private Integer parentId;
    private String menuUrl;
    private String glyphicon;
    private Integer versionId;

    // 二级菜单数据
    private List<Menu> subMenu;

    // 上级菜单名称
    private String parentName;

    public Menu() {
    }

    public Menu(Integer menuId, String menuName, Integer parentId, String menuUrl, String glyphicon, Integer versionId) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.parentId = parentId;
        this.menuUrl = menuUrl;
        this.glyphicon = glyphicon;
        this.versionId = versionId;
    }

    public Menu(String menuName, Integer parentId) {
        this.menuName = menuName;
        this.parentId = parentId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getGlyphicon() {
        return glyphicon;
    }

    public void setGlyphicon(String glyphicon) {
        this.glyphicon = glyphicon;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public List<Menu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<Menu> subMenu) {
        this.subMenu = subMenu;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", parentId=" + parentId +
                ", menuUrl='" + menuUrl + '\'' +
                ", glyphicon='" + glyphicon + '\'' +
                ", versionId=" + versionId +
                ", subMenu=" + subMenu +
                ", parentName='" + parentName + '\'' +
                '}';
    }
}
