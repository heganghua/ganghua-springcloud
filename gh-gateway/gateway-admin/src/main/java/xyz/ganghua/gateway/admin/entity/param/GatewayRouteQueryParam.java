package xyz.ganghua.gateway.admin.entity.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import xyz.ganghua.entity.param.BaseParam;
import xyz.ganghua.gateway.admin.entity.po.GatewayRoute;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatewayRouteQueryParam extends BaseParam<GatewayRoute> {

    private String uri;
}
