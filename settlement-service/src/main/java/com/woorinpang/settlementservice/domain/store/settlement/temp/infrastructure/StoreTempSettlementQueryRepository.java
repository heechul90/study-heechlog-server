package com.woorinpang.settlementservice.domain.store.settlement.temp.infrastructure;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class StoreTempSettlementQueryRepository {
    private final JPAQueryFactory queryFactory;

    public StoreTempSettlementQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
}
