package org.iwp.common.util;

import org.iwp.common.model.PageModel;

import java.util.List;

public class PageUtil {

    // 根据原始数据进行分页
    public static PageModel buildPage(Integer pageIndex, Integer pageSize, List<Object> sourceData){
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        pageModel.setPageSize(pageSize);
        pageModel.setTotalCount(sourceData.size());
        pageModel.setData(sourceData.subList(pageIndex * pageSize, (pageIndex + 1) * pageSize));
        return pageModel;
    }

    // 根据已分页数据构建分页模型
    public static PageModel buildPage(Integer pageIndex, Integer pageSize, Integer totalCount, List<Object> pagedData){
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        pageModel.setPageSize(pageSize);
        pageModel.setTotalCount(totalCount);
        pageModel.setData(pagedData);
        return pageModel;
    }
}