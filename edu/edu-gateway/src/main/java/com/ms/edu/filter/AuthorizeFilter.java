package com.ms.edu.filter;

import com.alibaba.nacos.client.utils.StringUtils;
import com.ms.edu.utils.AppJwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
public class AuthorizeFilter implements GlobalFilter, Ordered {
    private static final List<String> whiteList = new ArrayList<>();

    static {
        whiteList.add("/page/userLogin");
        whiteList.add("/page/course");
        whiteList.add("/page/getAdver");
        whiteList.add("/page/wxLogin");
        whiteList.add("/page/checkWxStatus");
        whiteList.add("/page/searchCourse");
        whiteList.add("/page/courseComment");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取请求对象和响应对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        //2.判断当前的请求是否为登录，如果是，直接放行
        System.out.println(request.getURI().getPath());

        for (String uri : whiteList) {
            if (request.getURI().getPath().contains(uri)){
                //放行
                return chain.filter(exchange);
            }
        }


        //3.获取当前用户的请求头jwt信息
        HttpHeaders headers = request.getHeaders();
        String jwtToken = headers.getFirst("token");

        //4.判断当前令牌是否存在
        if (StringUtils.isEmpty(jwtToken)) {
            //如果不存在，向客户端返回错误提示信息
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        try {
            //5.如果令牌存在，解析jwt令牌，判断该令牌是否合法，如果不合法，则向客户端返回错误信息
            Claims claims = AppJwtUtil.getClaimsBody(jwtToken);
            int result = AppJwtUtil.verifyToken(claims);
            if (result == 0 || result == -1) {
                //5.1 合法，则向header中重新设置userId
                Integer id = (Integer) claims.get("id");
                log.info("find userid:{} from uri:{}", id, request.getURI());
                //重新设置token到header中
                ServerHttpRequest serverHttpRequest = request.mutate().headers(httpHeaders -> {
                    httpHeaders.add("userId", id + "");
                }).build();
                exchange.mutate().request(serverHttpRequest).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            //向客户端返回错误提示信息
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }


        //6.放行
        return chain.filter(exchange);
    }

    /**
     * 优先级设置
     * 值越小，优先级越高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
