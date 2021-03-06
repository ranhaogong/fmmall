package com.gonghr.fmmall.common.result;
import lombok.Getter;

/**
 * 统一返回结果状态信息类
 */
@Getter
public enum ResultCodeEnum {
    SUBMIT_ORDER_SUCCESS(10000, "提交订单成功"),
    SUBMIT_ORDER_FAILURE(10001, "提交订单失败"),
    REGISTER_SUCCESS(10000, "注册成功"),
    REGISTER_FAILURE(10002, "注册失败"),
    TEST(10003, "测试接口"),
    REGISTER_FAILURE_OTHERS(10001, "⽤户名已经被注册"),
    LOGIN_FAILURE_NO_USERNAME(10001, "登录失败，⽤户名不存在！"),
    LOGIN_FAILURE_EXPIRATION(20002, "登录超时，请重新登录！"),
    LOGIN_FAILURE_ILLEGAL_TOKEN(10001, "Token不合法，请⾃重！"),
    LOGIN_SUCCESS(10000, "登陆成功"),
    LOGIN_FAILURE_WRONG_PASSWORD(10001, "登录失败，密码错误"),
    NOT_LOGIN(20001, "请先登录"),
    SUCCESS(10000,"成功"),
    FAIL(10001, "失败"),
    PARAM_ERROR( 202, "参数不正确"),
    SERVICE_ERROR(203, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    DATA_UPDATE_ERROR(205, "数据版本异常"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),

    CODE_ERROR(210, "验证码错误"),
    //    LOGIN_MOBLE_ERROR(211, "账号不正确"),
    LOGIN_DISABLED_ERROR(212, "改用户已被禁用"),
    REGISTER_MOBLE_ERROR(213, "手机号已被使用"),
    LOGIN_AURH(214, "需要登录"),
    LOGIN_ACL(215, "没有权限"),

    URL_ENCODE_ERROR( 216, "URL编码失败"),
    ILLEGAL_CALLBACK_REQUEST_ERROR( 217, "非法回调请求"),
    FETCH_ACCESSTOKEN_FAILD( 218, "获取accessToken失败"),
    FETCH_USERINFO_ERROR( 219, "获取用户信息失败"),
    //LOGIN_ERROR( 23005, "登录失败"),

    PAY_RUN(220, "支付中"),
    CANCEL_ORDER_FAIL(225, "取消订单失败"),
    CANCEL_ORDER_NO(225, "不能取消预约"),

    HOSCODE_EXIST(230, "医院编号已经存在"),
    NUMBER_NO(240, "可预约号不足"),
    TIME_NO(250, "当前时间不可以预约"),

    SIGN_ERROR(300, "签名错误"),
    HOSPITAL_OPEN(310, "医院未开通，暂时不能访问"),
    HOSPITAL_LOCK(320, "医院被锁定，暂时不能访问"),
    ;

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
