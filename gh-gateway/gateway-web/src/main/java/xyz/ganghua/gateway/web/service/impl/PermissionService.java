package xyz.ganghua.gateway.web.service.impl;

import org.springframework.stereotype.Service;
import xyz.ganghua.gateway.web.service.IPermissionService;

/**
 * 由authentication-client模块提供签权的feign客户端
 */
@Service
public class PermissionService implements IPermissionService {

    @Override
    public boolean permission(String authentication, String url, String method) {
        return true;
    }
}
