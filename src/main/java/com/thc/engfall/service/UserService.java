package com.thc.engfall.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserService {
    Map<String, Object> create(Map<String, Object> params);
    Map<String, Object> update(Map<String, Object> params);
    Map<String, Object> delete(Long id);
    Map<String, Object> detail(Long id);
    Map<String, Object> list();
}
