package com.amt.testmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "reqCreditCardBalanceEnquiry"
})
public class SrvReq {

    @XmlElement(name = "req_credit_card_balance_enquiry", required = true)
    protected ReqCreditCardBalanceEnquiry reqCreditCardBalanceEnquiry;

    
    public ReqCreditCardBalanceEnquiry getReqCreditCardBalanceEnquiry() {
        return reqCreditCardBalanceEnquiry;
    }

    
    public void setReqCreditCardBalanceEnquiry(ReqCreditCardBalanceEnquiry value) {
        this.reqCreditCardBalanceEnquiry = value;
    }
}