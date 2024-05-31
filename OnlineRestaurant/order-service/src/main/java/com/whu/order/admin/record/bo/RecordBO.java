package com.whu.order.admin.record.bo;

import com.whu.order.repository.entity.SystemRecordDO;


public interface RecordBO {

    /**
     * 得到昨天记录
     * @return 昨天记录
     */
    SystemRecordDO getYesterdayRecord();
}
