package fei.domain;

import java.io.Serializable;

public class Page implements Serializable {
    private Integer firstLimitParam;
    private Integer pageSize;

    public Integer getFirstLimitParam() {
        return firstLimitParam;
    }

    public void setFirstLimitParam(Integer firstLimitParam) {
        this.firstLimitParam = firstLimitParam;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
