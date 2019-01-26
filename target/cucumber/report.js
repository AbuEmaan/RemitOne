$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("myFirst.feature");
formatter.feature({
  "line": 2,
  "name": "Webservices",
  "description": "",
  "id": "webservices",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@RemitOne"
    }
  ]
});
formatter.before({
  "duration": 4968831068,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "ORM Change Language",
  "description": "",
  "id": "webservices;orm-change-language",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@runMyFeature1"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "user is on the \"orm\" landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user clicks the \"Login\" link",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user logs in with his credentials \"dummy@remitone.com\" and \"Password1\"",
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "orm",
      "offset": 16
    }
  ],
  "location": "RemitOneStepDefinitions.user_is_on_the_landing_page(String)"
});
formatter.result({
  "duration": 2976484258,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Login",
      "offset": 17
    }
  ],
  "location": "RemitOneStepDefinitions.user_clicks_the_link(String)"
});
formatter.result({
  "duration": 901203560,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "dummy@remitone.com",
      "offset": 35
    },
    {
      "val": "Password1",
      "offset": 60
    }
  ],
  "location": "RemitOneStepDefinitions.user_logs_in_with_his_credentials(String,String)"
});
formatter.result({
  "duration": 4468694505,
  "status": "passed"
});
formatter.after({
  "duration": 23734,
  "status": "passed"
});
});