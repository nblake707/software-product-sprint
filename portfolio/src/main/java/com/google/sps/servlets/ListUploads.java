package com.google.sps.servlets;

import com.google.gson.Gson;
import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/** Shows all of the images uploaded to Cloud Storage. */
@WebServlet("/list-images")
public class ListUploads extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // List all of the uploaded files.
    String projectId = "nblake-sps-summer21";
    String bucketName = "nblake-sps-summer21.appspot.com";
    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);
    Page<Blob> blobList = bucket.list();

    // Output <img> elements as HTML.
    response.setContentType("text/html;");
    for (Blob blob : blobList.iterateAll()) {
      String imgTag = String.format("<img src=\"%s\" />", blob.getMediaLink());
      response.getWriter().println(imgTag);
      response.getWriter().println("<br>");
}
  }

  }
  
 