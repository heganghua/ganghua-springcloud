package xyz.ganghua.gateway.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Service;
import xyz.ganghua.gateway.admin.dao.GatewayRouteMapper;
import xyz.ganghua.gateway.admin.entity.param.GatewayRouteQueryParam;
import xyz.ganghua.gateway.admin.entity.po.GatewayRoute;
import xyz.ganghua.gateway.admin.entity.vo.GatewayRouteVo;
import xyz.ganghua.gateway.admin.service.IGatewayRouteService;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GatewayRouteService extends ServiceImpl<GatewayRouteMapper, GatewayRoute> implements IGatewayRouteService {
    @Override
    public GatewayRoute get(String id) {
        return null;
    }

    @Override
    public boolean add(GatewayRoute gatewayRoute) {
        boolean save = this.save(gatewayRoute);
        //转化为gateway需要的类型，缓存到redis, 并事件通知各网关应用
        gatewayRouteToRouteDefinition(gatewayRoute);
        //通知TODO，发送事件

        return save;
    }

    @Override
    public List<GatewayRouteVo> query(GatewayRouteQueryParam gatewayRouteQueryParam) {
        QueryWrapper<GatewayRoute> queryWrapper = gatewayRouteQueryParam.build();
        queryWrapper.eq(StringUtils.isNotBlank(gatewayRouteQueryParam.getUri()), "uri", gatewayRouteQueryParam.getUri());
        // 调用baseMapper.selectList(queryWrapper) 拿到返回值， 映射成 VO返回
        return this.list(queryWrapper).stream().map(GatewayRouteVo::new).collect(Collectors.toList());
    }

    @Override
    public boolean update(GatewayRoute gatewayRoute) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean overload() {
        return false;
    }

    private RouteDefinition gatewayRouteToRouteDefinition(GatewayRoute gatewayRoute) {
        RouteDefinition routeDefinition = new RouteDefinition();

        routeDefinition.setId(gatewayRoute.getRouteId());
        routeDefinition.setOrder(gatewayRoute.getOrders());
        routeDefinition.setUri(URI.create(gatewayRoute.getUri()));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            routeDefinition.setFilters(objectMapper.readValue(gatewayRoute.getFilters(), new TypeReference<List<FilterDefinition>>() {
            }));
            routeDefinition.setPredicates(objectMapper.readValue(gatewayRoute.getPredicates(), new TypeReference<List<PredicateDefinition>>() {
            }));
        } catch (IOException e) {
            log.error("网关路由对象转换失败", e);
        }

        return routeDefinition;
    }

}
