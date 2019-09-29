package com.opensource.decorator.optimization;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 08:08:05
 */
public abstract class AbstractDecorator extends GatewayComponent {

    protected GatewayComponent gatewayComponent;

    public GatewayComponent getGatewayComponent() {
        return gatewayComponent;
    }

    public void setGatewayComponent(GatewayComponent gatewayComponent) {
        this.gatewayComponent = gatewayComponent;
    }

    @Override
    public void service() {
        if(gatewayComponent != null) {
            gatewayComponent.service();
        }
    }
}
