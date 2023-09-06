package com.woorinpang.settlementservice.storage.main.db.company;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyQueryRepository {
    private final JPAQueryFactory queryFactory;

    public CompanyQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
}
