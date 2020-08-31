package com.allstate.ceme.crm.model;


import org.springframework.data.annotation.Id;

public class CustomerInteraction {
    @Id
    private String id;
    private String customerId;
    private String createdDate;
    private String description;
    private String status;
    private String channel;

    public CustomerInteraction(String id, String customerId, String createdDate, String description, String status, String channel) {
        this.id = id;
        this.customerId = customerId;
        this.createdDate = createdDate;
        this.description = description;
        this.status = status;
        this.channel = channel;
    }

    public CustomerInteraction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "CustomerInteraction{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }
}
