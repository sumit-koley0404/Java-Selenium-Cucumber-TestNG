Feature: Search and Place the Order For Product
Scenario: Search Exprience for Product search in both home and offers page

Given User is on Landing Page
When User Searched with ShortName "Tom" and Extracted ActualName Of the Product
Then User Searched for Same ShortName in offers page to check if product exists 
