package org.iwp.iWare.object.model;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
public class PageModel implements Serializable {
    // 分页索引
    private Integer pageIndex;
    // 分页大小
    private Integer pageSize;
    // 总页数
    private Integer totalCount;
    // 当前页的数据
    private Object data;
}
