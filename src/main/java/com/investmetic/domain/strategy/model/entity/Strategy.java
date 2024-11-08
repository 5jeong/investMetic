package com.investmetic.domain.strategy.model.entity;

import com.investmetic.domain.strategy.model.IsApproved;
import com.investmetic.domain.strategy.model.IsPublic;
import com.investmetic.domain.strategy.model.OperationCycle;
import com.investmetic.domain.user.model.entity.User;
import com.investmetic.global.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import lombok.Getter;

@Entity
@Getter
public class Strategy extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long strategyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trade_type_id", nullable = false)
    private TradeType tradeType; // 매매유형

    private String strategyName; // 전략명

    @Enumerated(EnumType.STRING)
    private OperationCycle operationCycle; // 운용주기

    private BigDecimal minimumInvestmentAmount; // 최소운용가능금액

    @Column(length = 3000)
    private String strategyDescription; // 전략소개

    @Column(length = 1000)
    private String proposalFilePath; // 제안서 파일경로

    @Enumerated(EnumType.STRING)
    private IsPublic isPublic; // 공개여부

    @Enumerated(EnumType.STRING)
    private IsApproved isApproved; // 승인여부

    private Integer subscriptionCount; // 구독수

    private Double averageRating; // 평균별점



}