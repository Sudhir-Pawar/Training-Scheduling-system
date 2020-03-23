package com.zensar.tss.dao;

import com.zensar.tss.bean.TrainingProgram;

public interface OperationInterface<T, P, Q> {
	public Q budgetOfMonth(P p);
	public T displayTotalFinancialBudget();
	public Q countModule(P a);
}
