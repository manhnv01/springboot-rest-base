package io.github.manhnv01.springbootrestbase.exceptions;

public enum ExceptionMessage {
    UNAUTHORIZED("Bạn cần đăng nhập để tiếp tục."),
    FORBIDDEN("Bạn không được phép truy cập tài nguyên này."),
    INTERNAL_SERVER_ERROR("Đã có lỗi xảy ra. Vui lòng thử lại sau."),;

    public final String val;

    ExceptionMessage(String message) {
        val = message;
    }
}
