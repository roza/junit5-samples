package integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.project.api.Project;
import org.example.library.Library;
import org.junit.jupiter.api.Test;

class IntegrationTests {

  @Test
  void explicitModuleNames() {
    assertEquals("com.example.project", Project.class.getModule().getName());
    assertEquals("org.example.library", Library.class.getModule().getName());
  }

  @Test
  void projectIsAccessable() {
    Project project = new Project();
    assertEquals("47.11", project.getVersion());
  }

  @Test
  void libraryIsAccessable() {
    Library library = new Library();
    assertEquals("Library", library.getClass().getSimpleName());
  }

  // The following does not even compile!
  // error: package com.example.project is not visible
  // package com.example.project is declared in module com.example.project, which does not export it
  //  @Test
  //  void calculatorIsAccessable() {
  //    com.example.project.Calculator calculator = new com.example.project.Calculator();
  //    assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
  //  }
}
