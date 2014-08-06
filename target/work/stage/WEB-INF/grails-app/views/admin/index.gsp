<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sample title</title>
  </head>
  <body>
    <g:form action="upload" method="post" enctype="multipart/form-data">
  <label for="file">File:</label>
  <input type="file" name="file" id="file" />
  <input class="save" type="submit" value="Upload" />
    </g:form>
  
  </body>
</html>
