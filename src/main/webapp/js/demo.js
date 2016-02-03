/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
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
/* global $ */
'use strict';

function _error(xhr) {
  $('.error').show();
  var response = JSON.parse(xhr.responseText);
  console.log(response.error.error);
  $('.error h4').text(response.error.error || 'Internal server error.');
}


$(document).ready(function() {
  var queries = [];
  var query = null;

  $.get('data/queries.json').then(function(data){
    queries = JSON.parse(data).queries;
  }, _error);

  /**
   * Event handler for reset button
   */
  $('.reset-button').click(function() {
    location.reload();
  });

  $('.input--question-generator').click(function(){
    query = queries[Math.floor(Math.random() * queries.length)];
    console.log('ask:', query);
    $('#query').text(query.query);
    $.get('data/response.json').then(function(data){
      var responses = JSON.parse(data);
      console.log(data);
    }, _error);

  });
});

