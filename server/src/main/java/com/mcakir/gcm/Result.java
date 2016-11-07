package com.mcakir.gcm;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public final class Result implements Serializable {

  @JsonProperty("message_id")
  private String messageId;

  @JsonProperty("registration_id")
  private String canonicalRegistrationId;

  private String error;

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public String getCanonicalRegistrationId() {
    return canonicalRegistrationId;
  }

  public void setCanonicalRegistrationId(String canonicalRegistrationId) {
    this.canonicalRegistrationId = canonicalRegistrationId;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  @Override
  public String toString() {
    return "Result{" +
            "messageId='" + messageId + '\'' +
            ", canonicalRegistrationId='" + canonicalRegistrationId + '\'' +
            ", error='" + error + '\'' +
            '}';
  }
}
