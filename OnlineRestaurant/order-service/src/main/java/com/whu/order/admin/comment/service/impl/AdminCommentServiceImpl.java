package com.whu.order.admin.comment.service.impl;

import com.whu.order.admin.comment.bo.AdminCommentBO;
import com.whu.order.admin.comment.service.AdminCommentService;
import com.whu.order.admin.merchant.bo.MerchantBO;
import com.whu.order.commons.result.PageResult;
import com.whu.order.commons.utils.DateUtils;
import com.whu.order.domain.admin.dto.CommentSearchDTO;
import com.whu.order.domain.comment.dto.CommentDTO;
import com.whu.order.repository.entity.CommentDO;
import com.whu.order.repository.entity.MerchantDO;
import com.whu.order.types.SwitchTypeEnum;
import com.whu.order.types.admin.comment.CommentSearchQuery;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class AdminCommentServiceImpl implements AdminCommentService {

    @Autowired
    private AdminCommentBO adminCommentBO;

    @Autowired
    private MerchantBO merchantBO;

    @Override
    public PageResult<List<CommentDTO>> search(CommentSearchQuery query) {
        Page<Object> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());
        CommentSearchDTO commentSearchDTO = new CommentSearchDTO();
        BeanUtils.copyProperties(query, commentSearchDTO);
        List<CommentDTO> commentDTOList = adminCommentBO.search(commentSearchDTO);

        PageResult<List<CommentDTO>> pageResult = new PageResult<>(commentDTOList);
        pageResult.setPageNum(page.getPageNum());
        pageResult.setPageSize(page.getPageSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setPages(page.getPages());

        return pageResult;
    }

    @Override
    public int autoReply() {
        MerchantDO merchantDO = merchantBO.get();
        String isAutoReply = merchantDO.getIsAutoReply();

        //开启自动回复
        if (SwitchTypeEnum.ON.getContent().equals(isAutoReply)) {
            return adminCommentBO.autoReply(merchantDO.getAutoReplyContent());
        }
        return 0;
    }

    @Override
    public int calculateCommentScore() {
        Date monthBefore = DateUtils.add(new Date(), Calendar.MONTH, -1);
        List<CommentDO> commentDOList = adminCommentBO.getCommentBeforeDate(monthBefore);

        //(总星/订单数*15)*5
        double rate = 5.0;
        if (!CollectionUtils.isEmpty(commentDOList)) {
            int scores = 0;
            for (CommentDO commentDO : commentDOList) {
                scores += (commentDO.getTasteScore() + commentDO.getServiceScore() + commentDO.getEnvironmentScore());
            }
            rate = (scores * 1.0 / (commentDOList.size() * 15)) * 5;
        }

        DecimalFormat format = new DecimalFormat("0.0");

        MerchantDO merchantDO = new MerchantDO();
        merchantDO.setScore(Double.valueOf(format.format(rate)));
        return merchantBO.update(merchantDO);
    }
}
