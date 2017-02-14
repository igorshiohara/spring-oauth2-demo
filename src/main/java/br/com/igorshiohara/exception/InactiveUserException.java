package br.com.igorshiohara.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * An inactive user exception
 */
public class InactiveUserException extends AuthenticationException {

    private static final long serialVersionUID = 1L;

    public InactiveUserException(String message) {
        super(message);
    }

    public InactiveUserException(String message, Throwable t) {
        super(message, t);
    }
}
