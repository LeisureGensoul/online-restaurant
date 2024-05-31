package com.whu.order.admin.bill.converter;

import com.whu.order.domain.admin.vo.BillVO;
import com.whu.order.repository.entity.BillDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


@Component
public class BillConverter {

    public List<BillVO> convert2VOList(List<BillDO> allBill) {

        if (CollectionUtils.isEmpty(allBill)) {
            return null;
        }
        List<BillVO> res = new ArrayList<>();
        allBill.forEach(billDO -> {
            BillVO billVO = new BillVO();
            BeanUtils.copyProperties(billDO, billVO);
            res.add(billVO);
        });

        return res;
    }
}
