package com.woorinpang.settlementservice.storage.main.db.payment;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPaymentRecordEntity is a Querydsl query type for PaymentRecordEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaymentRecordEntity extends EntityPathBase<PaymentRecordEntity> {

    private static final long serialVersionUID = 70709771L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPaymentRecordEntity paymentRecordEntity = new QPaymentRecordEntity("paymentRecordEntity");

    public final QCompany company;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPayment payment;

    public final QPaymentAmount paymentAmount;

    public final QPaymentCancellation paymentCancellation;

    public final EnumPath<PaymentType> paymentType = createEnum("paymentType", PaymentType.class);

    public final QStore store;

    public final StringPath transactionId = createString("transactionId");

    public final QUser user;

    public QPaymentRecordEntity(String variable) {
        this(PaymentRecordEntity.class, forVariable(variable), INITS);
    }

    public QPaymentRecordEntity(Path<? extends PaymentRecordEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPaymentRecordEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPaymentRecordEntity(PathMetadata metadata, PathInits inits) {
        this(PaymentRecordEntity.class, metadata, inits);
    }

    public QPaymentRecordEntity(Class<? extends PaymentRecordEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company")) : null;
        this.payment = inits.isInitialized("payment") ? new QPayment(forProperty("payment")) : null;
        this.paymentAmount = inits.isInitialized("paymentAmount") ? new QPaymentAmount(forProperty("paymentAmount"), inits.get("paymentAmount")) : null;
        this.paymentCancellation = inits.isInitialized("paymentCancellation") ? new QPaymentCancellation(forProperty("paymentCancellation")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

