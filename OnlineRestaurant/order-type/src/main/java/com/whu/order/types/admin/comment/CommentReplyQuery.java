package com.whu.order.types.admin.comment;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


@Data
public class CommentReplyQuery {

    @NotNull(message = "id不能为null")
    private Integer id;

    @Length(max = 100, message = "评论长度不能超过100")
    private String reply;

}
