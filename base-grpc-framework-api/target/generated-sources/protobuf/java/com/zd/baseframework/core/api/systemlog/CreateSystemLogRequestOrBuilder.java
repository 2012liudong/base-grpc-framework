// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: systemlog.proto

package com.zd.baseframework.core.api.systemlog;

public interface CreateSystemLogRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.zd.baseframework.core.api.systemlog.CreateSystemLogRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.google.protobuf.StringValue biz_id = 1;</code>
   * @return Whether the bizId field is set.
   */
  boolean hasBizId();
  /**
   * <code>.google.protobuf.StringValue biz_id = 1;</code>
   * @return The bizId.
   */
  com.google.protobuf.StringValue getBizId();
  /**
   * <code>.google.protobuf.StringValue biz_id = 1;</code>
   */
  com.google.protobuf.StringValueOrBuilder getBizIdOrBuilder();

  /**
   * <code>.google.protobuf.StringValue user_id = 2;</code>
   * @return Whether the userId field is set.
   */
  boolean hasUserId();
  /**
   * <code>.google.protobuf.StringValue user_id = 2;</code>
   * @return The userId.
   */
  com.google.protobuf.StringValue getUserId();
  /**
   * <code>.google.protobuf.StringValue user_id = 2;</code>
   */
  com.google.protobuf.StringValueOrBuilder getUserIdOrBuilder();

  /**
   * <code>.google.protobuf.StringValue code = 3;</code>
   * @return Whether the code field is set.
   */
  boolean hasCode();
  /**
   * <code>.google.protobuf.StringValue code = 3;</code>
   * @return The code.
   */
  com.google.protobuf.StringValue getCode();
  /**
   * <code>.google.protobuf.StringValue code = 3;</code>
   */
  com.google.protobuf.StringValueOrBuilder getCodeOrBuilder();

  /**
   * <code>.google.protobuf.StringValue custom_code = 4;</code>
   * @return Whether the customCode field is set.
   */
  boolean hasCustomCode();
  /**
   * <code>.google.protobuf.StringValue custom_code = 4;</code>
   * @return The customCode.
   */
  com.google.protobuf.StringValue getCustomCode();
  /**
   * <code>.google.protobuf.StringValue custom_code = 4;</code>
   */
  com.google.protobuf.StringValueOrBuilder getCustomCodeOrBuilder();
}
