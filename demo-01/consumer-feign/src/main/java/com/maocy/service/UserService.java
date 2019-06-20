package com.maocy.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.maocy.api.UserApi;

@FeignClient("service-system")
public interface UserService extends UserApi {

}
