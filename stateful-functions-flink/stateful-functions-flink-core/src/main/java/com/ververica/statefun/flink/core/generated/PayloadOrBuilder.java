/*
 * Copyright 2019 Ververica GmbH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/protobuf/stateful-functions.proto

package com.ververica.statefun.flink.core.generated;

public interface PayloadOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:com.ververica.statefun.flink.core.Payload)
    com.google.protobuf.MessageOrBuilder {

  /** <code>string class_name = 2;</code> */
  java.lang.String getClassName();
  /** <code>string class_name = 2;</code> */
  com.google.protobuf.ByteString getClassNameBytes();

  /** <code>bytes payload_bytes = 3;</code> */
  com.google.protobuf.ByteString getPayloadBytes();
}
