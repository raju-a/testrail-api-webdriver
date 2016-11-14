# testrail-api-webdriver
Api which is used to create runner and update the result for that runner in testrail , It provides the basic functionality to authenticate API requests, provides generic support for read and write requests.

1. Environment setup
    
    Please add the contained package to your application or project (e.g. in Eclipse). The API binding also has a separate, external dependency on the JSON.simple library which can downloaded here:

https://code.google.com/p/json-simple/

2. Set up your APIClient using this function 

   intializeClient(String url)
   
   
             Program api = new new Program();
             api.intializeClient("https://<server>/testrail/");
        
3. Set your username and password using this function

   setUser(String username, String password);
   
  
            api.setUser("abc@gmail.com", "12345678");
       
4. To add Runner to your test using this function

   add_run(pid, suiteid, run_name, r_description, r_assignedto_id, r_include_all);
   
           long runnerid= api.add_run(2, 2, "Creating runner "," Creating runner using selenium api", 1, true);
   
   
   
        Name	         Type	                 Description
   
          pid            int                     project id 
   
         suite_id	     int	                 The ID of the test suite for the test run (optional if the project is                                                          operating in single suite mode, required otherwise)
         run_name	     string	                 The name of the test run
   
r_description	   string	               The description of the test run

r_assignedto_id	    int	                 The ID of the user the test run should be assigned to

r_include_all    	bool	               True for including all test cases of the test suite and false for a custom case                                                selection (default: true)


  
   
