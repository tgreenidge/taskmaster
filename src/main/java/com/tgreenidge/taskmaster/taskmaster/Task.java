package com.tgreenidge.taskmaster.taskmaster;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.UUID;

@DynamoDBTable(tableName = "TaskMaster")
public class Task {
    private UUID id;
    private String title;
    private String status;
    private String description;

    public Task() {

    }

    public Task(String title, String status, String description) {
        this.title =  title;
        this.status =  status;
        this. description = description;
    }

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public UUID getId() {
        return id;
    }

    @DynamoDBAttribute
    public String getStatus() {
        return status;
    }

    @DynamoDBAttribute
    public String getTitle() {
        return title;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @DynamoDBAttribute
    public String getDescription() {
        return description;
    }
}