package com.woorinpang.settlementservice.domain.payment.record.daily.infrastructure;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDailyRecordQueryRepository {
    private final JPAQueryFactory queryFactory;

    public PaymentDailyRecordQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
}
