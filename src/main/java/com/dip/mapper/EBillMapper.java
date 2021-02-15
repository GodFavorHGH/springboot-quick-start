package com.dip.mapper;

import java.util.List;
import java.util.Map;

import com.dip.domain.concrete.EBill;

public interface EBillMapper {

    int addEBill(EBill bill);

    List<EBill> getEbillList(Map condition);

}
