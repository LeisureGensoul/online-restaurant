package com.whu.order.types;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Data
@ApiModel(description = "分页请求")
public class PageQuery {

    @Min(value = 0, message = "错误页码")
    private int pageNo;

    @Max(value = 100, message = "页面数据不能超过1000条")
    private int pageSize;
}
