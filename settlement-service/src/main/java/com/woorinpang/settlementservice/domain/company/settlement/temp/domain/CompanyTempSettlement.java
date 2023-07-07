package com.woorinpang.settlementservice.domain.company.settlement.temp.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.util.Date;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyTempSettlement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_temp_settlement_id") @Comment("회사 임시 정산 고유번호")
    private Long id;

    @Id @Column(columnDefinition = "bigint(20) NOT NULL COMMENT '세금계산서 단위 일련번호'")
    private Long taxGroupSeq;
    @Id @Column(columnDefinition = "bigint(20) NOT NULL COMMENT '고객사 일련번호'")
    private Long companySeq;
    @Id @Column(columnDefinition = "tinyint(4) NOT NULL COMMENT '정산주기'")
    private Integer settlePeriodCode;
    @Id @Column(name = "settleStartYMD", columnDefinition = "char(8) NOT NULL COMMENT '정산 시작일'")
    private String settleStartYmd;
    @Id @Column(name = "settleEndYMD", columnDefinition = "char(8) NOT NULL COMMENT '정산 종료일'")
    private String settleEndYmd;
    @Column(name = "companyID", columnDefinition = "varchar(40) NOT NULL COMMENT '고객사 코드'")
    private String companyId;
    @Column(name = "beforeSettleEndYMD", columnDefinition = "char(8) DEFAULT NULL COMMENT '이전 정산 종료일'")
    private String beforeSettleEndYmd;
    @Column(columnDefinition = "bigint(20) DEFAULT 0 COMMENT '식대총합'")
    private Integer mealAmt;
    @Column(columnDefinition = "bigint(20) DEFAULT 0 COMMENT '마이포인트 금액'")
    private Integer myPointAmt;
    @Column(columnDefinition = "bigint(20) NOT NULL DEFAULT 0 COMMENT '즉시결제 금액'")
    private Integer instantPayAmt;
    @Column(columnDefinition = "bigint(20) DEFAULT 0 COMMENT '회사정산금액 총합'")
    private Integer companySettleAmt;
    @Column(columnDefinition = "bigint(20) DEFAULT 0 COMMENT '제휴식당 정산금액 총합'")
    private Integer storeSettleAmt;
    @Column(columnDefinition = "bigint(20) NOT NULL DEFAULT 0 COMMENT '쿠폰 금액'")
    private Integer couponAmt;
    @Column(columnDefinition = "int(11) DEFAULT 0 COMMENT '비과세 금액'")
    private Integer nonTaxAmt;
    @Column(columnDefinition = "int(11) DEFAULT NULL COMMENT '정산 주기별 실질 이용자 수'")
    private int actualUserCount;
    @Column(columnDefinition = "DEFAULT NULL COMMENT '반영일시'")
    private Date applyDate;
    @Column(columnDefinition = "bigint(20) NOT NULL COMMENT '가정산 일련번호 (추후 settleUnitSeq)'")
    private Long tempSettleSeq;
    @Column(columnDefinition = "bit(1) DEFAULT '0' COMMENT '정산 누락 플래그 (이전 종료일과 현재 시작일이 1일 초과하여 차이가 나는 경우)'")
    private Boolean settleOmitFlag;
    @Column(columnDefinition = "bit(1) NOT NULL DEFAULT '0' COMMENT '가정산 반영 처리 락 여부'")
    private Boolean settleUnitLockFlag;
    @Column(columnDefinition = "bit(1) NOT NULL DEFAULT '0' COMMENT '갱신 필요 여부'")
    private Boolean requiredUpdateFlag;

    @Column(columnDefinition = "datetime NOT NULL DEFAULT current_timestamp() COMMENT '등록일시'")
    private Date regDate;
    @Column(name = "regID", columnDefinition = "varchar(50) NOT NULL COMMENT '등록자'")
    private String regId;
    @Column(columnDefinition = "datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '수정일시'")
    private Date updDate;
    @Column(name = "updID", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '수정자 ID'")
    private String updId;
}
