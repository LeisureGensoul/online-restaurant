package com.whu.order.controller.admin;

import com.alibaba.excel.EasyExcel;
import com.whu.order.admin.bill.bo.BillBO;
import com.whu.order.admin.bill.converter.BillConverter;
import com.whu.order.commons.result.ActionResult;
import com.whu.order.commons.result.PageResult;
import com.whu.order.domain.admin.vo.BillVO;
import com.whu.order.repository.entity.BillDO;
import com.whu.order.types.PageQuery;
import com.whu.order.types.admin.bill.BillSearchQuery;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value = "/onlinerestaurant/admin")
@Api(tags = "管理系统账单接口")
@Slf4j
public class AdminBillController {

    @Autowired
    private BillBO billBO;

    @Autowired
    private BillConverter converter;

    @ApiOperation("账单列表")
    @PostMapping(value = "/bill/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActionResult<Object> list(@RequestBody @Valid PageQuery query) {
        Page<Object> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());
        List<BillDO> allBill = billBO.getAll();

        List<BillVO> billVOS = converter.convert2VOList(allBill);
        PageResult<List<BillVO>> pageResult = new PageResult<>(billVOS);
        pageResult.setPageNum(page.getPageNum());
        pageResult.setPageSize(page.getPageSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setPages(page.getPages());

        log.info("Admin select bill success");
        return ActionResult.getSuccessResult(pageResult);
    }

    @ApiOperation("导出所有账单")
    @GetMapping(value = "/bill/excel")
    public void excelAllBill(HttpServletResponse response) throws IOException {
        List<BillDO> allBill = billBO.getAll();

        List<BillVO> billVOS = converter.convert2VOList(allBill);

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=bill.xlsx");
        response.setHeader("Set-Cookie", "fileDownload=true; path=/");
        EasyExcel.write(response.getOutputStream(), BillVO.class).sheet("全部").doWrite(billVOS);
        log.info("Admin excel bill success");
    }

    @ApiOperation("搜索")
    @PostMapping(value = "/bill/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActionResult<Object> search(@RequestBody @Valid BillSearchQuery query) {
        Page<Object> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());
        List<BillDO> byDate = billBO.getByDate(query.getBillDate());

        List<BillVO> billVOS = converter.convert2VOList(byDate);
        PageResult<List<BillVO>> pageResult = new PageResult<>(billVOS);
        pageResult.setPageNum(page.getPageNum());
        pageResult.setPageSize(page.getPageSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setPages(page.getPages());

        log.info("Admin search bill success");
        return ActionResult.getSuccessResult(pageResult);
    }
}
