package com.zpp.demo.Tools;

import lombok.Data;

@Data
public class UToekn {
    private String username;
    //状态码
    int Code;
    //登录标识
    String TokenId;
    //结果标识
    String resultRE;

    public UToekn(){}
    public UToekn( int code,String TokenId,String res){
        this.Code = code;
        this.TokenId = TokenId;
        this.resultRE = res;
    }
    public UToekn( int code,String TokenId,String res,String name){
        this.Code = code;
        this.TokenId = TokenId;
        this.resultRE = res;
        this.username = name;
    }
}
