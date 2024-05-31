package com.whu.order.types.admin.comment;

import com.whu.order.types.PageQuery;
import lombok.Data;


@Data
public class CommentSearchQuery extends PageQuery {

    private String username;

    private Integer commentType;
}
