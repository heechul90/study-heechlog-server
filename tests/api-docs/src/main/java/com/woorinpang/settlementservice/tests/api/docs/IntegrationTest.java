package com.woorinpang.settlementservice.tests.api.docs;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.context.annotation.Import;
import org.springframework.restdocs.RestDocumentationExtension;

@ExtendWith(RestDocumentationExtension.class)
@Import(IntegrationTestConfig.class)
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "woorinpang.store.com/settlement-service", uriPort = 9040)
public class IntegrationTest {
}
