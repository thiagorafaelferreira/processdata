# Processing data
## This project is a backend for processing names and take some results

Steps to create project
=================
<!--ts-->
   * Processing names from a file
   * Create the main architecture
        * Java 11
        * Spring boot
        * Jacoco test coverage
        * Lombok reduce boilerplate
        * Sl4j logger
   * Problem solving
      * Understanding of the problem
          * Logical
          * Work with big files, used BufferedReader
          * Used Map to save store information
<!--te-->

1. First way
    - To run the project just need import on intelij and run the project by IDE
2. Second way
    - To run the project just need import on intelij and execute maven clean and install
    to generate a file.jar in processdata/target/processdata-0.0.1-SNAPSHOT.jar
    - open terminal and go to the repository where are the .jar and execute with: 
    java -jar processdata-0.0.1-SNAPSHOT.jar 
    - To process entire file put value of parameter NUMBER_LINES_PROCESSED that are in ProcessdataApplication.java with 0,
    or limit the lines with names that will be processed passing a diferent postive value, like 25.