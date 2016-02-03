/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.query.QueryRequest;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.query.QueryResponse;
import com.ibm.watson.developer_cloud.service.ServiceResponseException;


/**
 * Below is a sample class for using the IBM Watson Concept Expansion service. Concept Expansion
 * runs in a job processing environment. In order to use the service, 3 calls must be used. <br>
 * <br>
 * 1. The first call is to upload an initial seed list with a label and selected dataset. This will
 * start the job.<br>
 * <br>
 * 2. The second call is to check on the status of job until it is done. <br>
 * <br>
 * 3. The third and final call is to retrieve the results of Concept Expansion.<br>
 * <br>
 * Once the results are retrieved, they are deleted on the backend and no longer accessible.
 */

@Path("/")
public class RetrieveAndRankResource {

  private static Logger logger = Logger.getLogger(RetrieveAndRankResource.class.getName());

  private RetrieveAndRank retrieveAndRank;
  private String clusterId;
  private String rankerId;
  private String collectionName;

  /**
   * Instantiates a new retrieve and rank resource.
   */
  public RetrieveAndRankResource() {
    String endPoint = "https://gateway.watsonplatform.net/retrieve-and-rank/api";
    String username = "USERNAME";
    String password = "PASSWORD";

    this.retrieveAndRank = new RetrieveAndRank();
    retrieveAndRank.setEndPoint(endPoint);
    retrieveAndRank.setUsernameAndPassword(username, password);

    clusterId = System.getenv("CLUSTER_ID");
    rankerId = System.getenv("RANKER_ID");
    collectionName = System.getenv("COLLECTION_NAME");

    logger.info("RetrieveAndRank service initialized");
  }

  /**
   * Ping.
   *
   * @return the string
   */
  @GET
  @Path("/ping")
  public String ping() {
    return "pong";
  }


  /**
   * Performs a query against the Solr and then makes a call to rank the results. The order of the
   * results after both calls is recorded and the returned results are noted in each payload. Once
   * the ranked results are retrieved a third API call is made to the Solr retrieve service to
   * retrieve the body (text) for each result. A final lookup is performed to get the ground truth
   * relevance value for each returned result. This final lookup would not normally be performed,
   * but as a goal of this sample application is to show the user how training affects the final
   * results of the ranker, we return that info also.
   *
   * @param body the user query
   * @return the string
   */
  @GET
  @Path("/query")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response query(QueryRequest body) {
    try {
      final QueryResponse payload = new QueryResponse(); // pay load which will eventually be
      // TODO: query solr
      return Response.ok(payload).build();
    } catch (ServiceResponseException e) {
      return Response.status(e.getStatusCode()).entity(createError(e)).build();
    }
  }

  /**
   * Creates the JSON error based on the service exception.
   *
   * @param e the {@link ServiceResponseException}
   * @return the JSON error as string
   */
  private String createError(ServiceResponseException e) {
    JsonObject error = new JsonObject();
    error.addProperty("code", e.getStatusCode());
    error.addProperty("error", e.getMessage());
    return error.toString();
  }

}
