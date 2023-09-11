package com.woorinpang.settlementservice.storage.main.db.payment;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPaymentCancellation is a Querydsl query type for PaymentCancellation
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPaymentCancellation extends BeanPath<PaymentCancellation> {

    private static final long serialVersionUID = 1808170874L;

    public static final QPaymentCancellation paymentCancellation = new QPaymentCancellation("paymentCancellation");

    public final DateTimePath<java.time.LocalDateTime> paymentCancellationDate = createDateTime("paymentCancellationDate", java.time.LocalDateTime.class);

    public final StringPath paymentCancellationReason = createString("paymentCancellationReason");

    public final SimplePath<com.woorinpang.settlementservice.common.objects.YearMonthDay> paymentCancellationYmd = createSimple("paymentCancellationYmd", com.woorinpang.settlementservice.common.objects.YearMonthDay.class);

    public QPaymentCancellation(String variable) {
        super(PaymentCancellation.class, forVariable(variable));
    }

    public QPaymentCancellation(Path<? extends PaymentCancellation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaymentCancellation(PathMetadata metadata) {
        super(PaymentCancellation.class, metadata);
    }

}

