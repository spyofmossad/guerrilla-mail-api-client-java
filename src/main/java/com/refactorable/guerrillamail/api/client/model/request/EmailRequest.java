package com.refactorable.guerrillamail.api.client.model.request;

import org.apache.commons.lang3.Validate;

public class EmailRequest {

    private final FunctionType functionType;
    private final Long id;
    private final String sessionId;

    /**
     *
     * @param sessionId cannot be blank
     * @param id cannot be null
     */
    public EmailRequest(
            FunctionType functionType,
            String sessionId,
            Long id ) {

        Validate.notNull( functionType, "'functionType' cannot be null" );

        this.functionType = functionType;
        this.sessionId = sessionId;
        this.id = id;
    }

    public static EmailRequest fetch(String sessionId, Long id) {

        Validate.notBlank( sessionId, "'sessionId' cannot be blank" );
        Validate.notNull( id, "'id' cannot be null" );

        return new EmailRequest(
                FunctionType.FETCH_EMAIL,
                sessionId,
                id
        );
    }

    public static EmailRequest delete(String sessionId, Long emailId) {

        Validate.notBlank( sessionId, "'sessionId' cannot be blank" );
        Validate.notNull( emailId, "'id' cannot be null" );

        return new EmailRequest(
                FunctionType.DEL_EMAIL,
                sessionId,
                emailId
        );
    }

    public FunctionType getFunctionType() {
        return functionType;
    }

    public Long getId() {
        return id;
    }



    public String getSessionId() {
        return sessionId;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "functionType=" + functionType +
                ", id=" + id +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
