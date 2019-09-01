package com.projekat.poslovna.controller.exception;

import com.projekat.poslovna.entity.exception.DocumentNotValidException;
import com.projekat.poslovna.service.exception.CantTransferWithinSameWarehouseException;
import com.projekat.poslovna.service.exception.NotEnoughArticlesException;
import com.projekat.poslovna.service.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            NotEnoughArticlesException.class,
            CantTransferWithinSameWarehouseException.class,
    })
    private ResponseEntity<Object> handleConflict(CustomException ex) {
        log.info(ex.getMessage());
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), CONFLICT));
    }

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<Object> handleNotFound(NotFoundException ex) {
        log.info(ex.getMessage());
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), NOT_FOUND));
    }

    @ExceptionHandler(DocumentNotValidException.class)
    private ResponseEntity<Object> handleBadRequest(DocumentNotValidException ex) {
        log.info(ex.getMessage());
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), BAD_REQUEST));
    }

    @ExceptionHandler(CustomException.class)
    private ResponseEntity<Object> handleUnknownCustomException(CustomException ex) {
        ex.printStackTrace();
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleUnknownException(Exception ex) {
        ex.printStackTrace();
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), INTERNAL_SERVER_ERROR));
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final ExceptionResponse response = new ExceptionResponse(ex.getMessage(), BAD_REQUEST);
        response.setErrors(ex.getBindingResult().getAllErrors()
                .stream()
                .map(e -> ((FieldError)e).getField() + " " + e.getDefaultMessage())
                .collect(Collectors.toList()));
        return buildResponseEntity(response);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final ExceptionResponse response = new ExceptionResponse(ex.getMessage(), BAD_REQUEST);
        response.setErrors(Collections.singletonList(ex.getRequestPartName() + "is missing."));
        return buildResponseEntity(response);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex, HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(new ExceptionResponse(ex.getMessage(), BAD_REQUEST));
    }

    private ResponseEntity<Object> buildResponseEntity(final ExceptionResponse exceptionResponse) {
        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getStatus());
    }
}
