package com.woorinpang.settlementservice.domain.company.settlement.temp.infrastructure;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class CompanySettlementTempQueryRepository {
    private final JPAQueryFactory queryFactory;

    public CompanySettlementTempQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
}
