package com.bca.cmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)  // İstediğiniz HTTP durum kodunu burada belirtebilirsiniz
public class BaseException extends RuntimeException {

    private final String errorCode;  // Hata kodu
    private final String detailMessage;  // Detaylı mesaj
    private final Object additionalInfo;  // Ekstra bilgi (isteğe bağlı)

    // Temel constructor
    public BaseException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
        this.detailMessage = message;
        this.additionalInfo = null;
    }

    // Detaylı constructor, ek bilgi ile
    public BaseException(String message, String errorCode, Object additionalInfo) {
        super(message);
        this.errorCode = errorCode;
        this.detailMessage = message;
        this.additionalInfo = additionalInfo;
    }

    // Hata kodunu al
    public String getErrorCode() {
        return errorCode;
    }

    // Detaylı mesajı al
    public String getDetailMessage() {
        return detailMessage;
    }

    // Ekstra bilgiyi al
    public Object getAdditionalInfo() {
        return additionalInfo;
    }
}
