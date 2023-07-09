package com.woorinpang.settlementservice.domain.store.daily.domain;

import com.woorinpang.settlementservice.domain.store.common.domain.StorePaymentAmount;
import com.woorinpang.settlementservice.global.common.entity.BaseEntity;
import com.woorinpang.settlementservice.global.common.entity.YearMonthDay;
import com.woorinpang.settlementservice.global.common.entity.YearMonthDayConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreDailySettlement extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_daily_settlement_id") @Comment("제휴사 일일 정산 고유번호")
    private Long id;

    private Long storeId;

    @Embedded
    private StorePaymentAmount storePaymentAmount;

    @Column(columnDefinition = "char(8) null comment '정산일자 년월일'")
    @Convert(converter = YearMonthDayConverter.class)
    private YearMonthDay settlementDateYmd;
}