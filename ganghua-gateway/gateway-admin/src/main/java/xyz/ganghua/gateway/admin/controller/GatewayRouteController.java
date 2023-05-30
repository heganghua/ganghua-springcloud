package xyz.ganghua.gateway.admin.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ganghua.entity.vo.Result;
import xyz.ganghua.gateway.admin.controller.form.GatewayRouteForm;
import xyz.ganghua.gateway.admin.service.IGatewayRouteService;

import javax.validation.Valid;

@RestController
@RequestMapping("/gateway/routes")
@Api("gateway routes")
@Slf4j
public class GatewayRouteController {

    @Autowired
    private IGatewayRouteService gatewayRouteService;

    public Result add(@Valid @RequestBody GatewayRouteForm gatewayRoutForm) {


    }

}
