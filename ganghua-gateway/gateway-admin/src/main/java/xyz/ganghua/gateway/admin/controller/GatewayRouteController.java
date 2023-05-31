package xyz.ganghua.gateway.admin.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.ganghua.entity.vo.Result;
import xyz.ganghua.gateway.admin.entity.form.GatewayRouteForm;
import xyz.ganghua.gateway.admin.entity.param.GatewayRouteQueryParam;
import xyz.ganghua.gateway.admin.entity.po.GatewayRoute;
import xyz.ganghua.gateway.admin.service.IGatewayRouteService;

import javax.validation.Valid;

@RestController
@RequestMapping("/gateway/routes")
@Api("gateway routes")
@Slf4j
public class GatewayRouteController {

    @Autowired
    private IGatewayRouteService gatewayRouteService;

    @ApiOperation(value = "新增网关路由", notes = "新增一个网关路由")
    @ApiImplicitParam(name = "gatewayRoutForm", value = "新增网关路由form表单", required = true, dataType = "GatewayRouteForm")
    @PostMapping
    public Result add(@Valid @RequestBody GatewayRouteForm gatewayRoutForm) {
        log.info("name:", gatewayRoutForm);
        GatewayRoute po = gatewayRoutForm.toPo(GatewayRoute.class);
        return Result.success(gatewayRouteService.add(po));
    }

    @ApiOperation(value = "根据uri获取网关路由", notes = "根据uri获取网关路由信息，简单查询")
    @ApiImplicitParam(paramType = "query", name = "name", value = "网关路由路径", required = true, dataType = "string")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @GetMapping
    public Result getByUri(@RequestParam String uri) {
        return Result.success(gatewayRouteService.query(new GatewayRouteQueryParam(uri)).stream().findFirst());
    }


}
