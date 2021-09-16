$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/com/qa/features/SearchHotels.feature");
formatter.feature({
  "line": 1,
  "name": "Search Hotels in MakeMyTrip",
  "description": "",
  "id": "search-hotels-in-makemytrip",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Verify Hotels Page in MakemyTrip",
  "description": "",
  "id": "search-hotels-in-makemytrip;verify-hotels-page-in-makemytrip",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Searchhotel"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User Open Browser",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Click on Randoms place",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Click on Hotels Tab",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Select Mumbai from drop down",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Verify the Hotels Page",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Close the search hotels Browser",
  "keyword": "And "
});
formatter.match({
  "location": "HotelList.user_Open_Browser()"
});
formatter.result({
  "duration": 6536200000,
  "status": "passed"
});
formatter.match({
  "location": "HotelList.click_on_Randoms_place()"
});
formatter.result({
  "duration": 234114500,
  "status": "passed"
});
formatter.match({
  "location": "HotelList.click_on_Hotels_Tab()"
});
formatter.result({
  "duration": 639631500,
  "status": "passed"
});
formatter.match({
  "location": "HotelList.select_Mumbai_from_drop_down()"
});
formatter.result({
  "duration": 5540898200,
  "status": "passed"
});
formatter.match({
  "location": "HotelList.verify_the_Hotels_Page()"
});
formatter.result({
  "duration": 61968800,
  "status": "passed"
});
formatter.match({
  "location": "HotelList.close_the_search_hotels_Browser()"
});
formatter.result({
  "duration": 188433100,
  "status": "passed"
});
});