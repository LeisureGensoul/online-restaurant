package com.whu.order.types.admin.bill;

import com.whu.order.types.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Past;
import java.util.Date;


@Data
public class BillSearchQuery extends PageQuery {

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @Past(message = "日期必须为过去的时间")
    private Date billDate;
}
