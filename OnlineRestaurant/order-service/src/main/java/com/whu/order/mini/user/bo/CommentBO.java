package com.whu.order.mini.user.bo;

import com.whu.order.domain.comment.dto.CommentDTO;
import com.whu.order.types.user.CommentQuery;

import java.util.List;


public interface CommentBO {

    /**
     * 保存评论
     * @param query
     * @param userId
     * @return id
     */
    int saveComment(CommentQuery query, Integer userId);

    /**
     * 保存评论图片
     * @param pictures 图片url
     * @param commentId 评论id
     * @return 成功
     */
    boolean savePicture(List<String> pictures, Integer commentId);

    /**
     * 获取所有评论
     * @return 评论
     */
    List<CommentDTO> getAllComment();

    /**
     * 获取用户评论
     * @param userId 用户id
     * @return 评论
     */
    List<CommentDTO> getUserComment(Integer userId);

    /**
     * 根据分类查询评论
     * @param type 分类
     * @return 评论
     */
    List<CommentDTO> getCommentByType(Integer type);

}
