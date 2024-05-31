package com.whu.order.domain.comment.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class CommentDTO {

    private Integer id;

    private Integer userId;

    private String username;

    private String orderNum;

    private String avatarUrl;

    private String nickname;

    private Integer serviceScore;

    private Integer environmentScore;

    private Integer tasteScore;

    private String content;

    private String reply;

    private String isReply;

    private Date replyTime;

    private Date createTime;

    private Date updateTime;

    private String isDelete;

    private List<CommentPictureDTO> picUrls;

}
