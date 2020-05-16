package com.refactorable.guerrillamail.api.client.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties( ignoreUnknown = true )
public class DeleteResponse {

    private final List<Long> deletedIds;

    @JsonCreator
    public DeleteResponse(
            @JsonProperty( "deleted_ids" ) List<Long> deletedIds) {
                this.deletedIds = deletedIds;
    }


    public List<Long> getDeletedIds() {
        return deletedIds;
    }
}
