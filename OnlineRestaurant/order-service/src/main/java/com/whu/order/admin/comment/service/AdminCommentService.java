package com.whu.order.admin.comment.service;

import com.whu.order.commons.result.PageResult;
import com.whu.order.domain.comment.dto.CommentDTO;
import com.whu.order.types.admin.comment.CommentSearchQuery;

import java.util.List;


public interface AdminCommentService {

    PageResult<List<CommentDTO>> search(CommentSearchQuery query);

    int autoReply();

    int calculateCommentScore();
}
