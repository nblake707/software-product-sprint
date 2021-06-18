package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;



/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

 private List<String> messageList = new ArrayList<String>();


    public HelloWorldServlet(){
        messageList.add("Hello There");
        messageList.add("Hows it going?");
        messageList.add("Hola!");
    }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String json = convertToJsonUsingGson(messageList);
    response.setContentType("text/html;");
    response.getWriter().print(json);

  }

    private String convertToJsonUsingGson(List<String> greeting ) {
        Gson gson = new Gson();
        String json = gson.toJson(messageList);
        return json;
  }
}
