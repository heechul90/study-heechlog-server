package com.woorinpang.settlementservice.domain.payment.record.original.infrastructure;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecord;
import com.woorinpang.settlementservice.domain.payment.record.original.infrastructure.dto.search.PaymentOriginalRecordSearchCondition;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.woorinpang.settlementservice.domain.payment.record.original.domain.QPaymentOriginalRecord.paymentOriginalRecord;

@Repository
public class PaymentOriginalRecordQueryRepository {
    private final JPAQueryFactory queryFactory;

    public PaymentOriginalRecordQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    /**
     * 결제 원본 기록 목록조회
     */
    public Page<PaymentOriginalRecord> findPagePaymentOriginalRecord(PaymentOriginalRecordSearchCondition condition, Pageable pageable) {
        return PageableExecutionUtils.getPage(
                getPaymentOriginalRecordList(condition, pageable),
                pageable,
                getPaymentOriginalRecordListCount(condition)::fetchOne
        );
    }

    /**
     * 결제 원본 기록 목록
     */
    private List<PaymentOriginalRecord> getPaymentOriginalRecordList(PaymentOriginalRecordSearchCondition condition, Pageable pageable) {
        return queryFactory
                .select(paymentOriginalRecord)
                .from(paymentOriginalRecord)
                .where(
                        searchCompanyIdEq(condition.getSearchCompanyId()),
                        searchStoreEq(condition.getSearchStoreId()),
                        searchUserEq(condition.getSearchUserId())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    /**
     * 결제 원본 기록 목록 카운트
     */
    private JPAQuery<Long> getPaymentOriginalRecordListCount(PaymentOriginalRecordSearchCondition condition) {
        return queryFactory
                .select(paymentOriginalRecord.count())
                .from(paymentOriginalRecord)
                .where(
                        searchCompanyIdEq(condition.getSearchCompanyId()),
                        searchStoreEq(condition.getSearchStoreId()),
                        searchUserEq(condition.getSearchUserId())
                );
    }

    /**
     * where companyId = companyId
     */
    private BooleanExpression searchCompanyIdEq(Long companyId) {
        return companyId != null ? paymentOriginalRecord.company.companyId.eq(companyId) : null;
    }

    /**
     * where storeId = storeId
     */
    private BooleanExpression searchStoreEq(Long storeId) {
        return storeId != null ? paymentOriginalRecord.store.storeId.eq(storeId) : null;
    }

    /**
     * where userId = userId
     */
    private BooleanExpression searchUserEq(Long userId) {
        return userId != null ? paymentOriginalRecord.user.userId.eq(userId) : null;
    }
}
