package com.yunus.pagemodel;

import com.yunus.po.LeaveApply;
import com.yunus.po.PurchaseApply;
import lombok.Data;


@Data
public class HistoryProcess {

	String processDefinitionId;
	String businessKey;
	LeaveApply leaveapply;
	PurchaseApply purchaseapply;

}
