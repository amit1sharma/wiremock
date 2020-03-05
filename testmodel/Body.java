package com.amt.testmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "srvReq","srvRep"
})
public class Body {
    @XmlElement(name = "srv_req", required = true)
    public SrvReq srvReq;
    
    
    @XmlElement(name = "srv_rep", required = true)
    public SrvRep srvRep;

    
    
    public SrvReq getSrvReq() {
        return srvReq;
    }

    
    public void setSrvReq(SrvReq value) {
        this.srvReq = value;
    }
    
    public SrvRep getSrvRep() {
        return srvRep;
    }

    
    public void setSrvRep(SrvRep value) {
        this.srvRep = value;
    }

}



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"exceptionDetails","repCreditCardBalanceEnquiry"
})
class SrvRep {
	
	@XmlElement(name="exception_details")
	private ExceptionDetails exceptionDetails;

    @XmlElement(name = "rep_credit_card_balance_enquiry", required = true)
    protected RepCreditCardBalanceEnquiry repCreditCardBalanceEnquiry;
    
	public ExceptionDetails getExceptionDetails() {
		return exceptionDetails;
	}

	public void setExceptionDetails(ExceptionDetails exceptionDetails) {
		this.exceptionDetails = exceptionDetails;
	}

    
    public RepCreditCardBalanceEnquiry getRepCreditCardBalanceEnquiry() {
        return repCreditCardBalanceEnquiry;
    }

    
    public void setReqCreditCardBalanceEnquiry(RepCreditCardBalanceEnquiry value) {
        this.repCreditCardBalanceEnquiry = value;
    }
}


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "balanceEnquiry"
})
class RepCreditCardBalanceEnquiry {
	
	 

	@XmlElement(name="balance_enquiry")
	private BalanceEnquiry balanceEnquiry;
	
	public BalanceEnquiry getBalanceEnquiry() {
		return balanceEnquiry;
	}

	public void setBalanceEnquiry(BalanceEnquiry balanceEnquiry) {
		this.balanceEnquiry = balanceEnquiry;
	}
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "applicationName","dateTime","status","errorCode","errorDescription","transactionRefId"
})
class ExceptionDetails{
	
	@XmlElement(name="application_name")
	private String applicationName;
	
	@XmlElement(name="date_time")
	private String dateTime;
	
	@XmlElement(name="status")
	private String status;
	
	@XmlElement(name="error_code")
	private String errorCode;
	
	@XmlElement(name="error_description")
	private String errorDescription;
	
	@XmlElement(name="transaction_ref_id")
	private String transactionRefId;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getTransactionRefId() {
		return transactionRefId;
	}

	public void setTransactionRefId(String transactionRefId) {
		this.transactionRefId = transactionRefId;
	}
	
	
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cardNo","cardBrand","cardCurrency","cardLimit","availableCredit","cashLimit","availableCash","outstandingBalance","expiryDate","overlimitFlag",
    "overlimitAmount","minPayment","dueDate","unbilledAmount","pastDueFlag","pastDueAmount"
})
class BalanceEnquiry{
	@XmlElement(name="card_no")
	private String cardNo;
	
	@XmlElement(name="card_brand")
	private String cardBrand;
	
	@XmlElement(name="card_currency")
	private String cardCurrency;
	
	@XmlElement(name="card_limit")
	private String cardLimit;
	
	@XmlElement(name="available_credit")
	private String availableCredit;
	
	@XmlElement(name="cash_limit")
	private String cashLimit;
	
	
	@XmlElement(name="available_cash")
	private String availableCash;
	
	@XmlElement(name="outstanding_balance")
	private String outstandingBalance;
	@XmlElement(name="expiry_date")
	private String expiryDate;
	@XmlElement(name="overlimit_flag")
	private String overlimitFlag;
	@XmlElement(name="overlimit_amount")
	private String overlimitAmount;
	@XmlElement(name="min_payment")
	private String minPayment;
	@XmlElement(name="due_date")
	private String dueDate;
	@XmlElement(name="unbilled_amount")
	private String unbilledAmount;
	@XmlElement(name="past_due_flag")
	private String pastDueFlag;
	@XmlElement(name="past_due_amount")
	private String pastDueAmount;
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardBrand() {
		return cardBrand;
	}
	public void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}
	public String getCardCurrency() {
		return cardCurrency;
	}
	public void setCardCurrency(String cardCurrency) {
		this.cardCurrency = cardCurrency;
	}
	public String getCardLimit() {
		return cardLimit;
	}
	public void setCardLimit(String cardLimit) {
		this.cardLimit = cardLimit;
	}
	public String getAvailableCredit() {
		return availableCredit;
	}
	public void setAvailableCredit(String availableCredit) {
		this.availableCredit = availableCredit;
	}
	public String getCashLimit() {
		return cashLimit;
	}
	public void setCashLimit(String cashLimit) {
		this.cashLimit = cashLimit;
	}
	public String getAvailableCash() {
		return availableCash;
	}
	public void setAvailableCash(String availableCash) {
		this.availableCash = availableCash;
	}
	public String getOutstandingBalance() {
		return outstandingBalance;
	}
	public void setOutstandingBalance(String outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getOverlimitFlag() {
		return overlimitFlag;
	}
	public void setOverlimitFlag(String overlimitFlag) {
		this.overlimitFlag = overlimitFlag;
	}
	public String getOverlimitAmount() {
		return overlimitAmount;
	}
	public void setOverlimitAmount(String overlimitAmount) {
		this.overlimitAmount = overlimitAmount;
	}
	public String getMinPayment() {
		return minPayment;
	}
	public void setMinPayment(String minPayment) {
		this.minPayment = minPayment;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getUnbilledAmount() {
		return unbilledAmount;
	}
	public void setUnbilledAmount(String unbilledAmount) {
		this.unbilledAmount = unbilledAmount;
	}
	public String getPastDueFlag() {
		return pastDueFlag;
	}
	public void setPastDueFlag(String pastDueFlag) {
		this.pastDueFlag = pastDueFlag;
	}
	public String getPastDueAmount() {
		return pastDueAmount;
	}
	public void setPastDueAmount(String pastDueAmount) {
		this.pastDueAmount = pastDueAmount;
	}
	
	
	
}