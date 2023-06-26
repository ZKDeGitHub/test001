package com.javasm.entity;


/**
 * @author:
 * @className: PageInfo
 * @description:
 * @date: 2023/6/15 15:58
 * @since: 11
 */

public class PageInfo {
    private Integer page;
    private Integer pageSize;
    private Integer total;

    public PageInfo(Integer page, Integer pageSize, Integer total) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
    }

    public PageInfo() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
