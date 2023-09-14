package com.woorinpang.settlementservice.common.objects;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAmount is a Querydsl query type for Amount
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QAmount extends BeanPath<Amount> {

    private static final long serialVersionUID = 304058908L;

    public static final QAmount amount1 = new QAmount("amount1");

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    public QAmount(String variable) {
        super(Amount.class, forVariable(variable));
    }

    public QAmount(Path<? extends Amount> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAmount(PathMetadata metadata) {
        super(Amount.class, metadata);
    }

}

