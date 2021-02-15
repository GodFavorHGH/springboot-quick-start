package com.dip.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dip.common.Result;
import com.dip.constants.ResultCode;
import com.dip.domain.concrete.EBill;
import com.dip.service.EBillService;
import com.dip.utils.DataConvertUtil;

@RestController
@RequestMapping("/ebill")
@SuppressWarnings({"rawtypes", "unchecked"})
public class EBillController {

    @Autowired
    private EBillService eBillService;

    @RequestMapping("/add")
    public Result addBill(EBill bill) {
        int count = eBillService.addEBill(bill);
        return count == 1 ? Result.success() : Result.failure(ResultCode.FAILURE.getCode(), "添加失败！");
    }

    @RequestMapping("/bills")
    public Result getBillList(@RequestBody String params) {
        Map condition = DataConvertUtil.convertJsonToMap(params);
        List<EBill> bills = eBillService.getEbillList(condition);
        Result res = Result.success();
        res.setData(bills);
        return res;
    }
}
