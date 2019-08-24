package com.bookshop.common;

import java.io.Serializable;

// 返回结果信息
public class Result<T> implements Serializable {

    private static final long seriaVersionUID = 1L;
    private Integer resultCode;  // 判断请求是否成功
    private String message;
    private T data;

    public Result(){

    }

    // 请求失败的时候没有数据
    public Result(Integer resultCode, String message){
        this.resultCode = resultCode;
        this.message = message;
    }

    public Integer getResultCode(){
        return this.resultCode;
    }

    public void setResultCode(Integer resultCode){
        this.resultCode = resultCode;
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
