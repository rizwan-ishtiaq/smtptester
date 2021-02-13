package com.aaroca.smtptester.data;

import java.io.File;

public class EmailData {

  private String host;
  private String port;
  private String to;
  private String from;
  private Boolean detailedMessage;
  private String subject;
  private String body;
  private File attachment;
  private Boolean useAuthentication;
  private String username;
  private String password;
  private Boolean useTLS;
  private Boolean useSSL;

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public Boolean isDetailedMessage() {
    return detailedMessage;
  }

  public void setDetailedMessage(Boolean detailedMessage) {
    this.detailedMessage = detailedMessage;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public File getAttachment() {
    return attachment;
  }

  public void setAttachment(File attachment) {
    this.attachment = attachment;
  }

  public Boolean isUsingAuthentication() {
    return useAuthentication;
  }

  public void setUseAuthentication(Boolean useAuthentication) {
    this.useAuthentication = useAuthentication;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean isUsingTLS() {
    return useTLS;
  }

  public void setUseTLS(Boolean useTLS) {
    this.useTLS = useTLS;
  }

  public Boolean isUsingSSL() {
    return useSSL;
  }

  public void setUseSSL(Boolean useSSL) {
    this.useSSL = useSSL;
  }
}
