package utilities.common;

// Selenium imports
import com.github.javafaker.Faker;
import org.testng.Assert;
import java.util.Locale;

public class RandomValueGenerator {

    // Variable declaration
    public String title;
    public String firstName;
    public String middleName;
    public String lastName;
    public String knownAs;
    public String suffix;
    public String dob;
    public String houseNo;
    public String townCity;
    public String postcode;
    public String mainPhone;
    public String mobilePhone;
    public String workMobile;
    public String businessEmail;
    public String businessName;
    public String secondaryemail;
    public String phonetype;
    public String address2;
    public String county;

    // Method to generate random values using the faker class for input fields
    public RandomValueGenerator() {
        try {

            // Faker setup for using UK language
            Faker faker = new Faker(new Locale("en-GB"));

            // Generate random fake values for the below variables
            title = faker.name().prefix().replace(".", "");
            firstName = faker.name().firstName();
            middleName = faker.name().lastName();
            lastName = faker.name().lastName();
            knownAs = faker.name().lastName();
            suffix = "MC";
            dob = "01/08/1980";
            houseNo = faker.address().buildingNumber();
            address2 = faker.address().streetAddress();
            county = faker.address().state();
            townCity = faker.address().city();
            postcode = faker.address().zipCode();
            mobilePhone = faker.phoneNumber().cellPhone();
            workMobile = faker.phoneNumber().cellPhone().
                    replace("1", "3");
            mainPhone = faker.phoneNumber().phoneNumber();
            businessEmail = faker.internet().emailAddress();
            secondaryemail = faker.internet().safeEmailAddress();
            businessName = faker.company().name().
                    replaceAll("[^\\dA-Za-z ]", "");
            phonetype = "Mobile";

        } catch (Exception e) {

            // Print errors to console
            Assert.fail(e.getMessage());

        }

    }


    // Method to get the value within the specified field
    public String getValue(String valueField) {

        // Variable declaration
        String value = "";
        valueField = valueField.replace("<", "").
                replace(">", "").replace(
                        " ", "");

        // Pass value into switch statement, if it matches return to the case
        // return the value
        switch (valueField.toLowerCase()) {

            case "title":

                value = title;

                break;

            case "firstname":

                value = firstName;

                break;

            case "middlename":

                value = middleName;

                break;

            case "lastname":

                value = lastName;

                break;

            case "suffix":

                value = suffix;

                break;

            case "knownas":

                value = knownAs;

                break;

            case "dateofbirth":

                value = dob;

                break;

            case "Primary Phone":
            case "phonetype":

                value = phonetype;

                break;

            case "homephone":

                value = mainPhone;

                break;

            case "workphone":

                value = mainPhone;

                break;

            case "mobilephone":

                value = mobilePhone;

                break;

            case "workmobile":

                value = workMobile;

                break;

            case "primaryemail":

                value = businessEmail;

                break;

            case "secondaryemail":

                value = secondaryemail;

                break;

            case "house no/name":
            case "houseno/name":
            case "houseno":

                value = houseNo;

                break;

            case "address2":

                value = address2;

                break;

            case "address3":

                value = "";

                break;

            case "address4":

                value = "";

                break;

            case "town/city":
            case "towncity":

                value = townCity;

                break;

            case "postcode":

                value = postcode;

                break;

            case "county":

                value = county;

                break;

            case "business name":
            case "businessname":

                value = businessName;

                break;

        }

        // Return value
        return value;

    }

}