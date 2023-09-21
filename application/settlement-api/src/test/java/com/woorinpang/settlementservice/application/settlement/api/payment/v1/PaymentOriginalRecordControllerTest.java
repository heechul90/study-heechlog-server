package com.woorinpang.settlementservice.application.settlement.api.payment.v1;

import com.woorinpang.settlementservice.application.settlement.api.payment.v1.request.AddPaymentRecordRequest;
import com.woorinpang.settlementservice.domain.payment.domain.PaymentRecordService;
import com.woorinpang.settlementservice.tests.api.docs.RestDocsTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.restdocs.payload.JsonFieldType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.woorinpang.settlementservice.tests.api.docs.RestDocsUtils.operationRequestPreprocessor;
import static com.woorinpang.settlementservice.tests.api.docs.RestDocsUtils.operationResponsePreprocessor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;

public class PaymentOriginalRecordControllerTest extends RestDocsTest {
    private PaymentRecordService paymentRecordService;
    private PaymentOriginalRecordController controller;

    @BeforeEach
    public void setUp() {
        paymentRecordService = mock(PaymentRecordService.class);
        controller = new PaymentOriginalRecordController(paymentRecordService);
        this.mockMvc = mockController(controller);
    }

    @Test
    void paymentAdd() {
        Long addedId = 1L;
        AddPaymentRecordRequest request = AddPaymentRecordRequest.builder()
                .companyId(1L)
                .companyName("요기조기 컴퍼니")
                .storeId(2L)
                .storeName("오메가3 스토어")
                .userId(4L)
                .userName("이희철")
                .paymentAmount(BigDecimal.valueOf(10000))
                .companySettlementAmount(BigDecimal.valueOf(10000))
                .storeSettlementAmount(BigDecimal.valueOf(10000))
                .paymentDate(LocalDateTime.now())
                .build();

        when(paymentRecordService.add(any(), any(), any(), any(), any(), any())).thenReturn(addedId);

        String transactionId = UUID.randomUUID().toString();

        given().contentType(ContentType.JSON)
                .body(request)
                .post("/api/v1/payment/original/records/{transactionId}", transactionId)
                .then()
                .status(HttpStatus.CREATED)
                .apply(
                        document(
                                "PaymentAddPost",
                                operationRequestPreprocessor(),
                                operationResponsePreprocessor(),
                                pathParameters(
                                        parameterWithName("transactionId")
                                                .description("트랜잭션 유유아이디")),
                                requestFields(
                                        fieldWithPath("timestamp")
                                                .type(JsonFieldType.STRING)
                                                .description("api 요청 시간"),
                                        fieldWithPath("resultType")
                                                .type(JsonFieldType.STRING)
                                                .description("resultType"),
                                        fieldWithPath("errorMessage")
                                                .type(JsonFieldType.NULL)
                                                .ignored(),
                                        fieldWithPath("data.companyId")
                                                .type(JsonFieldType.NUMBER)
                                                .description("컴퍼니 고유번호")
                                )
                        )
                );
    }
}
