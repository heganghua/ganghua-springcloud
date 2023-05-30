package xyz.ganghua.gateway.admin.entity.po;

import lombok.*;
import xyz.ganghua.entity.po.BasePo;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GatewayRoute extends BasePo {
    private String uri;
    private String routeId;
    /**
     * 断言
     */
    private String predicates;
    private String filters;
    private String description;
    private Integer orders = 0;
    private String status = "Y";
}