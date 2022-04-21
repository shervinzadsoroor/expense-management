package com.expenseAndDebt.management.repository.expense.impl;

import com.expenseAndDebt.management.model.domainmodel.Expense;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class ExpenseSpecifications implements Specification<Expense> {

    private SearchCriteria criteriaSearch;

    @Override
    public Predicate toPredicate(Root<Expense> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (criteriaSearch.getOperation().equalsIgnoreCase(">")) {
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get(criteriaSearch.getKey()), criteriaSearch.getValue().toString());
        } else if (criteriaSearch.getOperation().equalsIgnoreCase("<")) {
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get(criteriaSearch.getKey()), criteriaSearch.getValue().toString());
        } else if (criteriaSearch.getOperation().equalsIgnoreCase("=")) {
            return criteriaBuilder.equal(
                    root.<String>get(criteriaSearch.getKey()), criteriaSearch.getValue().toString());
        } else if (criteriaSearch.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteriaSearch.getKey()).getJavaType() == String.class) {
                return criteriaBuilder.like(
                        root.get(criteriaSearch.getKey()), "%" + criteriaSearch.getValue() + "%");
            } else {
                return criteriaBuilder.equal(root.get(criteriaSearch.getKey()), criteriaSearch.getValue());
            }
        }
        return null;
    }
}
