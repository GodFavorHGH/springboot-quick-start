package com.dip.service;

import java.util.List;
import java.util.Map;

import com.dip.domain.concrete.EBill;

public interface EBillService {

    int addEBill(EBill bill);

    List<EBill> getEbillList(Map condition);

}
