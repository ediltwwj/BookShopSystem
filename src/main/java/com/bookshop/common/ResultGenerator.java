package com.bookshop.common;

// 返回结果信息的构造器
public class ResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";

    // 无返回数据，例如插入删除，只要知道状态码就可以
    public static Result genSuccessResult(){

        Result result = new Result();
        result.setResultCode(ResultCode.RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);

        return result;
    }

    // 针对查询，有返回数据的
    public static Result genSuccessResult(Object data){

        Result result = new Result();
        result.setResultCode(ResultCode.RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);

        return result;
    }

    public static Result genFailResult(String message) {

        Result result = new Result();
        result.setResultCode(ResultCode.RESULT_CODE_SERVER_ERROR);
        if (message == null || message.length() < 1) {
            message = DEFAULT_FAIL_MESSAGE;
        }
        result.setMessage(message);

        return result;
    }
}
