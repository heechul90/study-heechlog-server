package com.woorinpang.settlementservice.domain.company.settlement.apply.infrastructure;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyApplySettlementQueryRepository {
    private final JPAQueryFactory queryFactory;

    public CompanyApplySettlementQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
}
