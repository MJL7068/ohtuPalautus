Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation succesful with correct username and password
        Given new user is selected
        When  new correct username "maukka" and password "salasana123" are given
        Then  user is created

    Scenario: creation fails with too short username and valid passord
        Given new user is selected
        When  short username "ju" and valid password "salasana123" are given
        Then user is not created and error "username should have at least 3 characters" is reported   

    Scenario: creation fails with correct username and too short password
        Given new user is selected
        When  correct username "henkka" and short password "sa12" are given
        Then user is not created and error "password should have at least 8 characters" is reported   

    Scenario: creation fails with correct username and password consisting of letters
        Given new user is selected
        When  correct username "tommi" and letters only password "assa" are given
        Then user is not created and error "password can not contain only letters" is reported 

    Scenario: creation fails with already taken username and valid pasword
        Given new user is selected
        When  taken username "maukka" and valid password "salasana123" are given
        Then user is not created and error "username is already taken" is reported 

    Scenario: creation fails when password and password confirmation do not match
        Given new user is selected
        When  correct username "salla", correct password "salasana123" and unmatching password "sanasala321" are given
        Then user is not created and error "password and password confirmation do not match" is reported 