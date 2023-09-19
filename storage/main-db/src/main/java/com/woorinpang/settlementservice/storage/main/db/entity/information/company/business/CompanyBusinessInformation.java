package com.woorinpang.settlementservice.storage.main.db.entity.information.company.business;

import com.woorinpang.settlementservice.storage.main.db.entity.information.common.Address;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 컴퍼니 사업정보
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyBusinessInformation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_business_information_id") @Comment("컴퍼니 사업정보 고유번호")
    private Long id;

    @Column(columnDefinition = "varchar(60) not null comment '사업명'")
    private String businessName;

    @Column(columnDefinition = "varchar(30) not null comment '대표명'")
    private String chargeName;

    @Column(columnDefinition = "char(11) not null comment '사업자번호'")
    private String businessSerial;

    @Column(columnDefinition = "char(4) not null comment '종사업자번호'")
    private String businessSubSerial;

    @Embedded
    private Address address;

    @Column(columnDefinition = "varchar(11) not null comment '연락처'")
    private String phone;

    @Column(columnDefinition = "varchar(30) null comment '업태'")
    private String businessCondition;

    @Column(columnDefinition = "varchar(30) null comment '종목'")
    private String businessType;
}
