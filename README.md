# SpringBoot Security with Oauth2 and jwt

1. Spring security application will be hosted on port 1000
2. Configure the database related properties in application.yml files
3. You need to be authenticated and authorised, in order to visit resource "/hello"
4. Hit http://localhost:1000/oauth/authorize?response_type=code&client_id=ClientId and it will ask for authorize client
5. Once authorized, you need to generate token using the authorization code from step 4.
6. Make post request to http://localhost:1000/oauth/token with below parameters
      grant_type:authorization_code
      username:
      password:
      code: generated authorization code
7. Copy the access_token and give it as Authorsation header prefixed with "Bearer", to access the "/hello" resource
