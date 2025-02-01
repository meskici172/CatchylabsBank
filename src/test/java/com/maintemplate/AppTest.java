package com.maintemplate;

import io.cucumber.core.cli.Main;

public class AppTest {
    public static void main(String[] args) {
        // Cucumber CLI ile test çalıştırması
        String[] cucumberOptions = new String[]{
                "--threads", "5",
                "-g", "com.maintemplate.stepDefinitions",
                "src/test/resources/features/login/failedLoginScenarios.feature",
                "-p", "pretty",
                "-p", "html:target/cucumber-reports.html"
        };

        int exitCode = Main.run(cucumberOptions, Thread.currentThread().getContextClassLoader());
        System.exit(exitCode);
    }
}
