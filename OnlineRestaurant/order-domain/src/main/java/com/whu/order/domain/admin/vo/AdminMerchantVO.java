package com.whu.order.domain.admin.vo;

import com.whu.order.domain.user.vo.MerchantVO;
import lombok.Data;


@Data
public class AdminMerchantVO extends MerchantVO {

    private String isAutoReply;

    private String autoReplyContent;
}
