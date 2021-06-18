package com.appril.cola.dto;


/**
 * 基础分页查询参数
 */
public abstract class SimplePageQuery extends Query {
    private static final int DEFAULT_PAGE_SIZE = 10;

    private int pageSize = DEFAULT_PAGE_SIZE;
    private int pageIndex = 1;


    public int getPageIndex() {
        if (pageIndex < 1) {
            return 1;
        }
        return pageIndex;
    }

    public SimplePageQuery setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    public int getPageSize() {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    public SimplePageQuery setPageSize(int pageSize) {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
        return this;
    }
}
