package com.whu.order.types.user;

import com.whu.order.types.PageQuery;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class CommentTypeQuery extends PageQuery {

    @NotNull(message = "不能为空")
    private Integer type;

}
