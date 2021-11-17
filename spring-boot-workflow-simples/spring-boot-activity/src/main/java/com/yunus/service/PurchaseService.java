package com.yunus.service;

import com.yunus.po.PurchaseApply;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.Map;

public interface PurchaseService {
	 ProcessInstance startWorkflow(PurchaseApply apply, String userid, Map<String, Object> variables);
	PurchaseApply getPurchase(int id);
	void updatePurchase(PurchaseApply a);
}
