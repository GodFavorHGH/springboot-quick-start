package com.dip.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dip.domain.concrete.EBill;
import com.dip.mapper.EBillMapper;
import com.dip.service.EBillService;

@Service
public class EBillServiceImpl implements EBillService {

    @Autowired
    private EBillMapper eBillMapper;

    @Override
    public int addEBill(EBill bill) {
        // TODO Auto-generated method stub
        return eBillMapper.addEBill(bill);
    }

    @Override
    public List<EBill> getEbillList(Map condition) {
        // TODO Auto-generated method stub
        return eBillMapper.getEbillList(condition);
    }

}
