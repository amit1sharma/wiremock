package com.amt.testmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cardNo"
})
public class ReqCreditCardBalanceEnquiry {

    @XmlElement(name = "card_no", required = true)
    protected String cardNo;

   
    public String getCardNo() {
        return cardNo;
    }

    
    public void setCardNo(String value) {
        this.cardNo = value;
    }

}