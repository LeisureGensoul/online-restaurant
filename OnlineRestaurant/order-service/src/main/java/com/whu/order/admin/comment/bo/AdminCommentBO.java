package com.whu.order.admin.comment.bo;

import com.whu.order.domain.admin.dto.CommentSearchDTO;
import com.whu.order.domain.comment.dto.CommentDTO;
import com.whu.order.repository.entity.CommentDO;
import com.whu.order.types.admin.comment.CommentReplyQuery;

import java.util.Date;
import java.util.List;


public interface AdminCommentBO {

    /**
     * 得到过去date到现在的评论
     *
     * @param date 时间
     * @return 评分
     */
    List<CommentDO> getCommentBeforeDate(Date date);

    /**
     * 根据条件搜索
     *
     * @param query 条件
     * @return 结果
     */
    List<CommentDTO> search(CommentSearchDTO query);

    boolean reply(CommentReplyQuery query);

    boolean delete(Integer id);

    int autoReply(String replyContent);
}
