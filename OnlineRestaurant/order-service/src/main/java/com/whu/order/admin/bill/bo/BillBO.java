package com.whu.order.admin.bill.bo;

import com.whu.order.repository.entity.BillDO;

import java.util.Date;
import java.util.List;


public interface BillBO {

    List<BillDO> getAll();

    List<BillDO> getByDate(Date date);
}
