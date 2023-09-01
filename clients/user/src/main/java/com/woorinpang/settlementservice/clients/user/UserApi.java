package com.woorinpang.settlementservice.clients.user;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "USER-SERVER")
public class UserApi {
}
