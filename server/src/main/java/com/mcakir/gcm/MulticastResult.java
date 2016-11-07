package com.mcakir.gcm;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/*
* { "multicast_id": 216,
      "success": 3,
      "failure": 3,
      "canonical_ids": 1,
      "results": [
        { "message_id": "1:0408" },
        { "error": "Unavailable" },
        { "error": "InvalidRegistration" },
        { "message_id": "1:1516" },
        { "message_id": "1:2342", "registration_id": "32" },
        { "error": "NotRegistered"}
      ]
*   }
* */
public final class MulticastResult implements Serializable {

  private int success;

  private int failure;

  @JsonProperty("canonical_ids")
  private int canonicalIds;

  @JsonProperty("multicast_id")
  private long multicastId;

  private List<Result> results;

  public int getSuccess() {
    return success;
  }

  public void setSuccess(int success) {
    this.success = success;
  }

  public int getFailure() {
    return failure;
  }

  public void setFailure(int failure) {
    this.failure = failure;
  }

  public int getCanonicalIds() {
    return canonicalIds;
  }

  public void setCanonicalIds(int canonicalIds) {
    this.canonicalIds = canonicalIds;
  }

  public long getMulticastId() {
    return multicastId;
  }

  public void setMulticastId(long multicastId) {
    this.multicastId = multicastId;
  }

  public List<Result> getResults() {
    return results;
  }

  public void setResults(List<Result> results) {
    this.results = results;
  }

  @Override
  public String toString() {
    return "MulticastResult{" +
            "success=" + success +
            ", failure=" + failure +
            ", canonicalIds=" + canonicalIds +
            ", multicastId=" + multicastId +
            ", results=" + results +
            '}';
  }
}
