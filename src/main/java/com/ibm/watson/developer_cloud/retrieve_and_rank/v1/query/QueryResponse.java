package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.query;


import java.util.List;


/**
 * The query response that contains:<br>
 * <ul>
 * <li>The original query sent from the client</li>
 * <li>The number of results which the Solr portion of the service returned</li>
 * <li>The list of results as returned by Solr</li>
 * <li>The list of results from Solr re-ranked using the ranker portion of the service.</li>
 * </ul>
 */
public class QueryResponse {

  /**
   * An object that encapsulate Ranker results
   */
  public class RankResult {
    /**
     * the Solr answer id
     * 
     */
    private String answerId;

    /**
     * the body of the document returned by Solr
     * 
     */
    private String body;

    /**
     * the confidence assigned by the ranker to the result
     * 
     */
    private double confidence;

    /**
     * the index of the result in the ranked results
     * 
     */
    private int finalRank;

    /**
     * the Ground Truth relevance.
     * 
     */
    private int relevance = -1;

    /**
     * the score assigned by Solr/Ranker
     * 
     */
    private float score;

    /**
     * the index of the result in the solr results
     * 
     */
    private int solrRank;

    /**
     * The title of the document returned by Solr
     * 
     */
    private String title;


    /**
     * Returns the Solr answer id
     * 
     * @return
     */
    public String getAnswerId() {
      return answerId;

    }

    /**
     * Returns the Solr document body for the result
     * 
     * @return
     */
    public String getBody() {
      return body;

    }

    /**
     * Returns the confidence assigned by the ranker service to the result
     * 
     * @return
     */
    public double getConfidence() {
      return confidence;

    }

    /**
     * Returns the position of this result in the list of final results from the ranker
     * 
     * @return
     */
    public int getFinalRank() {
      return finalRank;

    }

    /**
     * Returns the Ground Truth relevance of this result
     * 
     * @return
     */
    public int getRelevance() {
      return relevance;

    }

    /**
     * Returns the score assigned by the system to the result
     * 
     * @return
     */
    public float getScore() {
      return score;

    }

    /**
     * Gets the position this result appears in the list of results from Solr
     * 
     * @return
     */
    public int getSolrRank() {
      if (solrRank > -1) {
        solrRank++;

      }
      return solrRank;

    }

    /**
     * Returns the Solr document title for the result
     * 
     * @return
     */
    public String getTitle() {
      return title;

    }

    /**
     * Sets the Solr answer id
     * 
     * @param answerId
     */
    public void setAnswerId(String answerId) {
      this.answerId = answerId;

    }

    /**
     * Sets the Solr document body for the result
     * 
     * @param body
     */
    public void setBody(String body) {
      this.body = body;

    }

    /**
     * Sets the confidence assigned by the ranker service to the result
     * 
     * @param confidence
     */
    public void setConfidence(double confidence) {
      this.confidence = confidence;

    }

    /**
     * Sets the position of this result in the list of final results from the ranker
     * 
     * @param finalRank
     */
    public void setFinalRank(int finalRank) {
      if (finalRank > -1) {
        finalRank++;

      }
      this.finalRank = finalRank;

    }

    /**
     * Sets the Ground Truth relevance of this result
     * 
     * @param relevance
     */
    public void setRelevance(int relevance) {
      if (relevance < 1) {
        relevance = 0;

      } else if (relevance == 1) {
        relevance = 4;

      } else if (relevance == 2) {
        relevance = 3;

      } else if (relevance == 3) {
        relevance = 2;

      } else if (relevance == 4) {
        relevance = 1;

      }
      this.relevance = relevance;

    }

    /**
     * Sets the score assigned by the system to the result
     * 
     * @param score
     */
    public void setScore(float score) {
      this.score = score;

    }

    /**
     * Sets the position this result appears in the list of results from Solr
     * 
     * @param solrRank
     */
    public void setSolrRank(int solrRank) {
      this.solrRank = solrRank;

    }

    /**
     * Returns the Solr document title for the result
     * 
     * @param title
     */
    public void setTitle(String title) {
      this.title = title;

    }
  }

  /**
   * number of results returned by Solr
   * 
   */
  private int num_solr_results;

  /**
   * Original text from the client
   * 
   */
  private String query;

  /**
   * an ordered list of results as re-ranked by the Ranker
   * 
   */
  private List<RankResult> ranked_results;



  /**
   * an ordered list of results from the Solr query.
   * 
   */
  private List<RankResult> solr_results;



  /**
   * Returns the number of results returned by the Solr search
   * 
   * @return
   */
  public int getNum_solr_results() {
    return num_solr_results;

  }

  /**
   * Returns the original query sent from the client
   * 
   * @return
   */
  public String getQuery() {
    return query;

  }

  /**
   * Returns an ordered list of results, which is the Solr list re-ranked by the Ranker service
   * 
   * @return
   */
  public List<RankResult> getRanked_results() {
    return ranked_results;

  }

  /**
   * Returns an ordered list of results as they were returned by the Solr search.
   * 
   * @return
   */
  public List<RankResult> getSolr_results() {
    return solr_results;

  }

  /**
   * Set the number of results returned by Solr
   * 
   * @param num_solr_results
   */
  public void setNum_solr_results(int num_solr_results) {
    this.num_solr_results = num_solr_results;

  }

  /**
   * Set the original query sent from the client
   * 
   * @param query
   */
  public void setQuery(String query) {
    this.query = query;

  }

  /**
   * Sets an ordered list of results as ranked by the Ranker service.
   * 
   * @param ranked_results
   */
  public void setRanked_results(List<RankResult> ranked_results) {
    this.ranked_results = ranked_results;

  }

  /**
   * Sets an ordered list of results as they were returned by Solr
   * 
   * @param solr_results
   */
  public void setSolr_results(List<RankResult> solr_results) {
    this.solr_results = solr_results;

  }
}
