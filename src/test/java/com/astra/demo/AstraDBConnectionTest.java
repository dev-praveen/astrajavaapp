package com.astra.demo;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

class AstraDBConnectionTest {

  @Test
  void connectToAstraDB() {

    AstraDBConnection dbConnection = new AstraDBConnection();
    dbConnection.connectToAstraDB();
  }

  @Test
  void findIPAddress() throws UnknownHostException {

    InetAddress IP = InetAddress.getLocalHost();
    System.out.println("IP of my system is := " + IP.getHostAddress());
  }
}
