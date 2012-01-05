/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jayway.restassured.scalatra

/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.scalatra.ScalatraServlet
import org.scalatra.fileupload.FileUploadSupport

class ScalatraMultiPartExample extends ScalatraServlet with FileUploadSupport {

  post("/file") {
    getFileContent
  }

  put("/file") {
    getFileContent
  }

  post("/text") {
    getText
  }

  post("/fileAndText") {
    getFileContent + getText
  }

  private def getFileContent: String = {
    val fileItem = fileParams.get("file").get
    fileItem.getString
  }

  private def getText: String = {
    val option = multiParams.get("text")
    val seq = option.get
    seq.mkString(",")
  }
}