package com.woorinpang.settlementservice.domain.company.settlement.apply.infrastructure;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class CompanySettlementApplyQueryRepository {
    private final JPAQueryFactory queryFactory;

    public CompanySettlementApplyQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
}
