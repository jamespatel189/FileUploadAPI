# FileUploadAPI

#POST API URL
 
/files

In Body part use key = file and attach file

Currently support upto 10MB

Size can increase by changing application.properties file



#GET API URL

/files 

Return all files meta-data

/files/{ID}

Return file data with this id if present else throw exception

Testing : Used PostMan Clint in Chrome Browser to see how it works.

