package ravello.com.lifty;

/**
 * Created by anna on 10/28/16.
 */
public class UserData {

        private String firstName;
        private String lastName;
        private String email;
        private String phone;

        public UserData(String firstName, String lastNAme, String email, String phone){
            this.firstName = firstName;
            this.lastName = lastNAme;
            this.email = email;
            this.phone = phone;
        }

        public String getFirstName(){
            return firstName;
        }

        public String getLastName(){
            return lastName;
        }

        public String getEmail(){
            return email;
        }

        public String getPhone(){
            return phone;
        }

        @Override
        public String toString(){
          return "firstName: " + firstName + "\nlastName:  "
                  + lastName + "\nEmail:  " + email + "\nphone:  " + phone ;
        }
}
