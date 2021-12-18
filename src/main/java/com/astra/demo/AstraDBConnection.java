package com.astra.demo;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import java.nio.file.Paths;

public class AstraDBConnection {

  public void connectToAstraDB() {

    // Create the CqlSession object:
    try (CqlSession session =
        CqlSession.builder()
            .withCloudSecureConnectBundle(
                Paths.get("/home/praveen/IdeaProjects/secure-connect-pisis.zip"))
            .withAuthCredentials(
                "vorjMIxjSPgPypYhxvEQlvJa",
                "KP8aHh6f6FuxT+SxABLb4rzk7AkK-GTan,culhD5B1umX4oOc32u1_cTpqjyInDnCzqbOf4c5DIgmjay,y,-vbbU,MnWOrApPpWI.Zy8dztMMf5g-4d28Lt-q5t1.5pe")
            .build()) {

      // Select the release_version from the system.local table:
      ResultSet rs = session.execute("select release_version from system.local");
      Row row = rs.one();

      // Print the results of the CQL query to the console:
      if (row != null) {
        System.out.println(row.getString("release_version"));
      } else {
        System.out.println("An error occurred.");
      }
    }
    System.exit(0);
  }
}
