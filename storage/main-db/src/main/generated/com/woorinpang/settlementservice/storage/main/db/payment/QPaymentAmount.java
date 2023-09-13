package com.woorinpang.settlementservice.storage.main.db.payment;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPaymentAmount is a Querydsl query type for PaymentAmount
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPaymentAmount extends BeanPath<PaymentAmount> {

    private static final long serialVersionUID = 634137615L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPaymentAmount paymentAmount1 = new QPaymentAmount("paymentAmount1");

    public final com.woorinpang.settlementservice.common.objects.QAmount companySettlementAmount;

    public final com.woorinpang.settlementservice.common.objects.QAmount paymentAmount;

    public final com.woorinpang.settlementservice.common.objects.QAmount storeSettlementAmount;

    public QPaymentAmount(String variable) {
        this(PaymentAmount.class, forVariable(variable), INITS);
    }

    public QPaymentAmount(Path<? extends PaymentAmount> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPaymentAmount(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPaymentAmount(PathMetadata metadata, PathInits inits) {
        this(PaymentAmount.class, metadata, inits);
    }

    public QPaymentAmount(Class<? extends PaymentAmount> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.companySettlementAmount = inits.isInitialized("companySettlementAmount") ? new com.woorinpang.settlementservice.common.objects.QAmount(forProperty("companySettlementAmount")) : null;
        this.paymentAmount = inits.isInitialized("paymentAmount") ? new com.woorinpang.settlementservice.common.objects.QAmount(forProperty("paymentAmount")) : null;
        this.storeSettlementAmount = inits.isInitialized("storeSettlementAmount") ? new com.woorinpang.settlementservice.common.objects.QAmount(forProperty("storeSettlementAmount")) : null;
    }

}

