package com.appril.cola.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 适用于app端的简单分页结果
 *
 */
public class MobilePageResponse<T> extends Response {

    /**
     * 每页显示条数
     */
    private int pageSize = 10;
    /**
     * 当前页码
     */
    private int pageIndex;

    private Collection<T> data;
    /**
     * 是否有下一页数据
     */
    private Boolean isExistNextPage = false;


    public int getPageSize() {
        if (pageSize < 1) {
            return 1;
        }
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            this.pageSize = 1;
        } else {
            this.pageSize = pageSize;
        }
    }

    public int getPageIndex() {
        if (pageIndex < 1) {
            return 1;
        }
        return pageIndex;
    }
    public void setPageIndex(int pageIndex) {
        if (pageIndex < 1) {
            this.pageIndex = 1;
        } else {
            this.pageIndex = pageIndex;
        }
    }

    public List<T> getData() {
        return null == data ? Collections.emptyList() : new ArrayList<>(data);
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public Boolean getExistNextPage() {
        return isExistNextPage;
    }

    public void setExistNextPage(Boolean existNextPage) {
        isExistNextPage = existNextPage;
    }

    /**
     * 没有数据的结果
     * @param isExistNextPage
     * @param pageSize
     * @param pageIndex
     * @param <T>
     * @return
     */
    public static <T> MobilePageResponse<T> of(Boolean isExistNextPage, int pageSize, int pageIndex) {
        MobilePageResponse<T> response = new MobilePageResponse();
        response.setSuccess(true);
        response.setData(Collections.emptyList());

        response.setExistNextPage(isExistNextPage);
        response.setPageSize(pageSize);
        response.setPageIndex(pageIndex);
        return response;
    }

    public static <T> MobilePageResponse<T> of(Collection<T> data, Boolean isExistNextPage, int pageSize, int pageIndex) {
        MobilePageResponse<T> response = new MobilePageResponse<>();
        response.setSuccess(true);
        response.setData(data);
        response.setExistNextPage(isExistNextPage);
        response.setPageSize(pageSize);
        response.setPageIndex(pageIndex);
        return response;
    }
}
