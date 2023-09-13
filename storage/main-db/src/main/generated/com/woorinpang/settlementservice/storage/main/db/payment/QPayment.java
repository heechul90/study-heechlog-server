package com.woorinpang.settlementservice.storage.main.db.payment;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPayment is a Querydsl query type for Payment
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPayment extends BeanPath<Payment> {

    private static final long serialVersionUID = -1297994537L;

    public static final QPayment payment = new QPayment("payment");

    public final DateTimePath<java.time.LocalDateTime> paymentDate = createDateTime("paymentDate", java.time.LocalDateTime.class);

    public final SimplePath<com.woorinpang.settlementservice.common.objects.YearMonthDay> paymentDateYmd = createSimple("paymentDateYmd", com.woorinpang.settlementservice.common.objects.YearMonthDay.class);

    public QPayment(String variable) {
        super(Payment.class, forVariable(variable));
    }

    public QPayment(Path<? extends Payment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPayment(PathMetadata metadata) {
        super(Payment.class, metadata);
    }

}

