Feature: Search and Place the Order For Product
Scenario: Search Exprience for Product search in both home and offers page

Given User is on Landing Page
When User Searched with ShortName "Tom" and Extracted ActualName Of the Product
Then User Searched for Same ShortName "Tom" in offers page 
And Verify the existance of the product 
