Feature: To validate the jira api's
 
 @createissue
Scenario Outline: To validate the create api issue with post call
  Given To Add the Baseuri 
  And To add the payload for create api "<summary>" and "<description>"
  When To call the "create issue" api with "POST" request
  Then The response code should be 201
  And The self should contain the "suganyakathir"
  
  Examples:
     |summary            |description       |
     |Login not working  |Otp cant received |
  @updateissue
  Scenario: To validate the update api issue with put call
  Given To Add the Baseuri 
  And To add payload for update issue api
  When To call the "updateissue" api with "PUT" request
  Then The response code should be 204
  
  @getissue
  Scenario: To validate the get api issue with get call
  Given To Add the Baseuri 
  When To call the "getissue" api with "GET" request
  Then The reponse code should be 200
  
 @deleteissue 
 Scenario: To validate the delete api issue with delete call
  Given To Add the Baseuri 
  When To call the "deleteissue" api with "DELETE" request
  Then The response code should be 204