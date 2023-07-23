package com.woorinpang.settlementservice.domain.payment.record.original.infrastructure;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecord;
import com.woorinpang.settlementservice.domain.payment.record.original.infrastructure.dto.find.FindPagePaymentOriginalRecordResponse;
import com.woorinpang.settlementservice.domain.payment.record.original.infrastructure.dto.search.PaymentOriginalRecordSearchCondition;
import com.woorinpang.settlementservice.global.common.entity.YearMonthDay;
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
     * 결제 원본기록 목록조회
     */
    public Page<FindPagePaymentOriginalRecordResponse> findPagePaymentOriginalRecord(PaymentOriginalRecordSearchCondition condition, Pageable pageable) {
        return PageableExecutionUtils.getPage(
                getPaymentOriginalRecordList(condition, pageable),
                pageable,
                getPaymentOriginalRecordListCount(condition)::fetchOne
        );
    }

    /**
     * 결제 원본기록 목록조회 by companyId and storeId and paymentDateYmd
     */
    public List<PaymentOriginalRecord> findAllByCompanyAndStore(Long companyId, Long storeId, YearMonthDay paymentDateYmd) {
        return queryFactory
                .select(paymentOriginalRecord)
                .from(paymentOriginalRecord)
                .where(
                        searchCompanyIdEq(companyId),
                        searchStoreIdEq(storeId),
                        searchPaymentDateYmdEq(paymentDateYmd)
                )
                .fetch();
    }

    /**
     * 결제 원본기록 목록
     */
    private List<FindPagePaymentOriginalRecordResponse> getPaymentOriginalRecordList(PaymentOriginalRecordSearchCondition condition, Pageable pageable) {
        return queryFactory
                .select(
                        Projections.constructor(FindPagePaymentOriginalRecordResponse.class,
                                paymentOriginalRecord.id,
                                paymentOriginalRecord.transactionId,
                                paymentOriginalRecord.company,
                                paymentOriginalRecord.store,
                                paymentOriginalRecord.user,
                                paymentOriginalRecord.paymentAmount,
                                paymentOriginalRecord.payment
                        )
                )
                .from(paymentOriginalRecord)
                .where(
                        searchCompanyIdEq(condition.getSearchCompanyId()),
                        searchStoreIdEq(condition.getSearchStoreId()),
                        searchUserEq(condition.getSearchUserId())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    /**
     * 결제 원본기록 목록 카운트
     */
    private JPAQuery<Long> getPaymentOriginalRecordListCount(PaymentOriginalRecordSearchCondition condition) {
        return queryFactory
                .select(paymentOriginalRecord.count())
                .from(paymentOriginalRecord)
                .where(
                        searchCompanyIdEq(condition.getSearchCompanyId()),
                        searchStoreIdEq(condition.getSearchStoreId()),
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
    private BooleanExpression searchStoreIdEq(Long storeId) {
        return storeId != null ? paymentOriginalRecord.store.storeId.eq(storeId) : null;
    }

    /**
     * where userId = userId
     */
    private BooleanExpression searchUserEq(Long userId) {
        return userId != null ? paymentOriginalRecord.user.userId.eq(userId) : null;
    }

    /**
     * where paymentDateYmd = paymentDateYmd
     */
    private BooleanExpression searchPaymentDateYmdEq(YearMonthDay paymentDateYmd) {
        return paymentDateYmd != null ? paymentOriginalRecord.payment.paymentDateYmd.eq(paymentDateYmd) : null;
    }
}
