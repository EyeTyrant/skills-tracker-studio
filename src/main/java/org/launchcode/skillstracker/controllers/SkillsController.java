package org.launchcode.skillstracker.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class SkillsController {

  @GetMapping("skills")
  public String skillsList(){
    return
        "<h1>Skills Tracker</h1>" +
        "<h2>Here is a list of skills:</h2>" +
          "<ol>" +
            "<li>Java</li>" +
            "<li>JavaScript</li>" +
            "<li>Python</li>" +
          "</ol>";
  }

  @GetMapping("form")
  public String favForm(){

    String skillOptions =
        "<option value='Java'>Java</option>\n" +
        "<option value='JavaScript'>JavaScript</option>\n" +
        "<option value='Python'>Python</option>";

    return
        "<html>" +
            "<body>" +
              "<form method='post' action='getName'>" +
                "<h3>Name:</h3>" +
                "<input type='text' name='person'>" +   // input box to enter name
                "<h3>First Favorite:</h3>" +
                "<select name='firstSkill'>\n" +        // variable named firstSkill = value in the first select box
                  skillOptions +                    // using variable skillOptions to display the options
                "</select>" +
                "<h3>Second Favorite:</h3>" +
                "<select name='secondSkill'>\n" +       // variable secondSkill = value in the second select box
                  skillOptions +                    // using variable skillOptions to display the options
                "</select>" +
                "<h3>Third Favorite:</h3>" +
                "<select name='thirdSkill'>\n" +        // variable thirdSkill = value in the second select box
                  skillOptions +                    // using variable skillOptions to display the options
                "</select>" +
                "<br>" +
                "<br>" +
                "<input type='submit' value='Submit'>" +
            "</form>" +
          "</body>" +
        "</html>";
  }

@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "getName")

  public String getName(@RequestParam(defaultValue = "Jo Shmo") String person,
                        @RequestParam() String firstSkill,
                        @RequestParam() String secondSkill,
                        @RequestParam() String thirdSkill){

    return
        "<div style=\"text-align: center\">" +
          "<h1 style=\"color: darkorchid\">" + person + "<h1>" +
          "<h3>" +
            "<ol style=\"display: inline-block;color: magenta\">" +
              "<li style=\"text-align: left\">" + firstSkill + "</li>" +
              "<li style=\"text-align: left\">" + secondSkill + "</li>" +
              "<li style=\"text-align: left\">" + thirdSkill + "</li>" +
            "</ol>" +
          "</h3>" +
        "</div>";
  }

}
