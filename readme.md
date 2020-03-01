## Issues:                                                                                                                                                     
 - the app does not consider potential name collisions                                                                                                      
   - make model use an id to avoid collisions with names                                                                                                    
     - this change is not API compatible with the previous version, I will assume no previous usage of the API                                              
     - [implemented] I would modify the get /name endpoint to instead accept an id                                                                          
     - [implemented] I would modify the delete /name endpoint to instead accept an id                                                                       
     - I would add an optional name query parameter to the root get endpoint to filter entries by name                                                      
 - the app does not control the number of returned elements in the get request                                                                              
   - I would add some form of pagination to limit the size of responses                                                                                     
 - the delete endpoint logic is needlessly complicated                                                                                                      
   - [implemented] I would replace it with a simple call to filterNot                                                                                       
 - the app does not return meaningful error codes                                                                                                           
   - [implemented] I would return 400 errors for malformed inputs                                                                                           
   - [implemented] I would return a 404 error in the get by id                                                                                              
 - the app changes the port at each run                                                                                                                     
   - this does not make much sense, especially in a production environment (unless the server sits behind a reverse proxy with some auto-discovery feature) 
 - the app mixes restful and non-restful endpoints (the /add endpoint points to a verb, not to a resource)                                                  
   - I would change it to a POST on / (and maybe move all endpoints to a named resource like /phoneentry)                                                   

## Improvements:                                                                                                                                               
 - use case classes for model entities                                                                                                                      
   - [implemented] json4s has support for case classes, I would move the model to a case class for cleaner code                                             
 - persist in a non volatile storage and add a model layer                                                                                                  
   - this application will lose all data if the server is shut down, I would add some form of persistence storage                                           
 - add a validation filter                                                                                                                                  
   - the app performs no validation of its inputs. Considering it is a phone book I would at least check the phone numbers have some format                 
 - add tests                                                                                                                                                
   - this app has no tests, I would create some integration tests leveraging finagle http clients                                                           