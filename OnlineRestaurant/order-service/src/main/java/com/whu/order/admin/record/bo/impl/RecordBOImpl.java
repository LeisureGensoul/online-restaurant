package com.whu.order.admin.record.bo.impl;

import com.whu.order.admin.record.bo.RecordBO;
import com.whu.order.repository.dao.SystemRecordDOMapper;
import com.whu.order.repository.entity.SystemRecordDO;
import com.whu.order.repository.entity.SystemRecordDOExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class RecordBOImpl implements RecordBO {

    @Autowired
    private SystemRecordDOMapper systemRecordDOMapper;

    @Cacheable(value = "YesterdayRecord")
    @Override
    public SystemRecordDO getYesterdayRecord() {
        SystemRecordDOExample example = new SystemRecordDOExample();
        example.setOrderByClause("record_date desc");
        PageHelper.startPage(1, 1);
        return systemRecordDOMapper.selectByExample(example).get(0);
    }
}
