package com.whu.order.mini.user.service;

import com.whu.order.commons.result.PageResult;
import com.whu.order.domain.comment.dto.CommentDTO;
import com.whu.order.types.PageQuery;
import com.whu.order.types.user.CommentQuery;
import com.whu.order.types.user.CommentTypeQuery;

import java.util.List;


public interface CommentService {

    boolean comment(CommentQuery query, Integer userId);

    PageResult<List<CommentDTO>> commentList(PageQuery query);

    PageResult<List<CommentDTO>> getUserCommentList(PageQuery query, Integer userId);

    PageResult<List<CommentDTO>> commentListByType(CommentTypeQuery query);
}
